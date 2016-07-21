package com.example.liyanju.androiddemo.phone360;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.liyanju.androiddemo.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;

import okio.BufferedSink;

/**
 * Created by liyanju on 16/6/12.
 */
public class Phone360Activity extends Activity{

    OkHttpClient client = new OkHttpClient();

    String url = "http://scan.call.f.360.cn/HarassingCallQuery";

    String url2 = "https://apis-android.dianhua.cn/batchresolvetel/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.only_button_layout);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            requestAPI();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }

    private void requestAPI() throws IOException {
//        Log.v("xx", " requestAPI ");
//        esb e1 = new esb();
//        e1.a = 11;
//        e1.b = "22";
//        e1.c = "33no";
//        byte b[] = e1.f();
//
//        RequestBody requestBody = RequestBody.create(null, b);
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        Response response = client.newCall(request).execute();
        //byte body[] = response.body().bytes();




    }
}
