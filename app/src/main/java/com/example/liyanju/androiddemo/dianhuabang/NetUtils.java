package com.example.liyanju.androiddemo.dianhuabang;


import android.content.Context;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class NetUtils {
    private static final String CHARSET_UTF8 = "UTF-8";
    public static final int CONNECTION_TIMEOUT = 20000;
    public static final String KEY = "ACCESS";
    public static final int MAX_TOTAL_CONNECTION_NUM = 200;
    public static final String NAME = "NETACCESS";
    public static final int SO_TIMEOUT = 20000;
    private static final String TAG = NetUtils.class.getSimpleName();
    private static HttpClient customerHttpClient;

    public static String post(Context context, String requestUrl, HashMap<String,String> map) throws ClientProtocolException, IOException {
        HttpClient client = getNewHttpClient(context);
        //Logger.i(TAG, "post RequestVo URL:" + reqVo.requestUrl);

        HttpPost post = new HttpPost(requestUrl);
        HttpParams params = new BasicHttpParams();
//        if (reqVo.connectionTimeout > 0) {
            HttpConnectionParams.setConnectionTimeout(params, 20000);
//        }
//        if (reqVo.soTimeout > 0) {
            HttpConnectionParams.setSoTimeout(params, 30000);
//        }
        post.setParams(params);
        post.setHeader("Accept-Encoding", "gzip");
//        if (reqVo.headers != null && reqVo.headers.size() > 0) {
//            for (Entry<String, String> me : reqVo.headers.entrySet()) {
//                post.setHeader((String) me.getKey(), (String) me.getValue());
//            }
//        }
        String result = null;
        if (map != null) {
            ArrayList<BasicNameValuePair> pairList = new ArrayList();
            for (Entry<String, String> entry : map.entrySet()) {
                pairList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
            post.setEntity(new UrlEncodedFormEntity(pairList, "UTF-8"));
        }
        HttpResponse response = client.execute(post);
        int code = response.getStatusLine().getStatusCode();
        Log.i(TAG, "状态码：" + code);
        if (code == 200) {
            InputStream in = null;
            try {
                in = response.getEntity().getContent();
                Header contentEncoding = response.getFirstHeader("Content-Encoding");
                if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                   // Logger.i(TAG, "gzip InputStream in post");
                    in = new GZIPInputStream(in);
                }
                result = getHTMLContent(in);
//                if (reqVo.callback != null) {
//                    reqVo.callback.onSuccess(result);
//                    reqVo.callback.processHeaders(response.getAllHeaders());
//                }
                Log.i(TAG, " result " + result);
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    public static String get(Context context, String requestUrl) throws ClientProtocolException, IOException {
        HttpClient client = getNewHttpClient(context);
        Log.i(TAG, "get RequestVo URL:" + requestUrl);
        HttpGet get = new HttpGet(requestUrl);
        HttpParams params = new BasicHttpParams();

        get.setParams(params);
        get.setHeader("Accept-Encoding", "gzip");
//        if (reqVo.headers != null && reqVo.headers.size() > 0) {
//            for (Entry<String, String> me : reqVo.headers.entrySet()) {
//                get.setHeader((String) me.getKey(), (String) me.getValue());
//            }
//        }
        String result = null;
        HttpResponse response = client.execute(get);
        int code = response.getStatusLine().getStatusCode();
        Log.i(TAG, "状态码：" + code);
        if (code == 200) {
            InputStream in = null;
            try {
                in = response.getEntity().getContent();
                Header contentEncoding = response.getFirstHeader("Content-Encoding");
                if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                    //Logger.i(TAG, "gzip InputStream in get");
                    in = new GZIPInputStream(in);
                }
                result = getHTMLContent(in);
//                if (reqVo.callback != null) {
//                    reqVo.callback.onSuccess(result);
//                    reqVo.callback.processHeaders(response.getAllHeaders());
//                }
                Log.i(TAG, result);
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    private static String getHTMLContent(InputStream in)throws Throwable {
        IOException e;
        Throwable th;
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in, "utf-8"));
            while (true) {
                try {
                    String line = br2.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (IOException e2) {
                    e = e2;
                    br = br2;
                } catch (Throwable th2) {
                    th = th2;
                    br = br2;
                }
            }
            if (br2 != null) {
                try {
                    br2.close();
                    br = br2;
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return sb.toString();
            }
            br = br2;
        } catch (IOException e4) {
            e = e4;
            try {
                e.printStackTrace();
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return sb.toString();
    }

    private static HttpClient getNewHttpClient(Context context) {
        SchemeRegistry schReg;
        if (customerHttpClient == null) {
            synchronized (NetUtils.class) {
                if (customerHttpClient == null) {
                    HttpParams params = new BasicHttpParams();
                    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
                    HttpProtocolParams.setContentCharset(params, "UTF-8");
                    String userAgent = System.getProperty("http.agent");
                   // Logger.d("userAgent", userAgent);
                    HttpProtocolParams.setUserAgent(params, userAgent);
                    ConnManagerParams.setTimeout(params, 20000);
                    ConnManagerParams.setMaxTotalConnections(params, 200);
                    ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(20));
                    int ConnectionTimeOut = 20000;
                    HttpConnectionParams.setConnectionTimeout(params, ConnectionTimeOut);
                    HttpConnectionParams.setSoTimeout(params, ConnectionTimeOut);
                    try {
                        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        trustStore.load(null, null);
                        SSLSocketFactory sf = new SSLSocketFactoryEx(trustStore);
                        sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                        schReg = new SchemeRegistry();
                        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                        schReg.register(new Scheme("https", sf, 443));
                        customerHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params, schReg), params);
                    } catch (Exception e) {
                        schReg = new SchemeRegistry();
                        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                        schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                        customerHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params, schReg), params);
                    }
                }
            }
        }
        return customerHttpClient;
    }
}
