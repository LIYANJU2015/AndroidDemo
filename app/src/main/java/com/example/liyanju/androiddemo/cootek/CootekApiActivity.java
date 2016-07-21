package com.example.liyanju.androiddemo.cootek;

import android.app.Activity;
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

/**
 * Created by liyanju on 16/6/8.
 */
public class CootekApiActivity extends Activity{

    String authUrl = "http://ws2.cootekservice.com:80/auth/activate";
    String authJSON = "{\"activate_type\":\"new\",\"api_level\":\"19\",\"app_name\":\"cootek.contactplus.android.public\",\"app_version\":\"5163\",\"channel_code\":\"010004\",\"device_info\":\"GT-I9300I\",\"dpi\":\"320\",\"identifier\":\"359776058226830##38:2D:D1:FC:F6:3B\",\"imei\":\"359776058226830\",\"locale\":\"zh-cn\",\"manufacturer\":\"samsung\",\"os_name\":\"Android\",\"os_version\":\"4.4.4\",\"physical_size\":\"4.59\",\"recommend_channel\":\"010004\",\"resolution\":\"1280*720\"}";

    String info2Url = "http://ws2.cootekservice.com:80/yellowpage/info2";
    String info2JSON= "{\"need_advertisement\":true,\n" +
            "\"need_promotion\":true,\n" +
            "\"need_slots\":true,\n" +
            "\"phone\":[\"+73134084525\"],\n" +
            "\"survey\":false}";


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.only_button_layout);

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        requestCookeApi();
                    }
                }).start();
            }
        });
    }

    private void requestCookeApi(){
        RequestBody body = RequestBody.create(JSON, authJSON);

        Request request = new Request.Builder().url(authUrl).post(body).build();

        try {
            Response response = client.newCall(request).execute();

            String token = response.header("Set-Cookie");

            Log.v("xx", " token " + token);
           // token = "auth_token=sssss-461b-4e4b-89ed-5cf73945a6c4; Path=/";

            RequestBody body2 = RequestBody.create(JSON, info2JSON);

            Request request2 = new Request.Builder().url(info2Url).post(body2)
                    .header("Cookie", token).build();

            Response response2 = client.newCall(request2).execute();

            Log.v("xx", " response2 body " + response2.body().string());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
