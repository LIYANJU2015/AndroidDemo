package com.example.liyanju.androiddemo.dianhuabang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liyanju.androiddemo.R;

import java.util.HashMap;

/**
 * Created by liyanju on 16/6/14.
 */
public class DianhuaBangActivity extends Activity{

    String requestUrl = "https://apis-android.dianhua.cn/batchresolvetel/";
    String params = "{\"apikey\":\"kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k\",\"auth_id\":\"62760cefadf59a71124986289f8d37bb997b08f629e1a4511feb4346dfc0720c\",\"uid\":\"359776058226830\",\"sig\":\"0dea28f2e7bcd7ee35ee1e8d4593199b\",\"tels\":[\"01057123600\",\"13716439744\",\"18635757843\",\"119\",\"01059924781\",\"01050892073\",\"15340059879\",\"10086\",\"18611580475\",\"15810856853\",\"076938945606\"]}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.only_button_layout);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HashMap<String ,String> map = new HashMap<String, String>();
                        map.put("i", params);

                        try{
                            NetUtils.post(DianhuaBangActivity.this, requestUrl, map);
                         }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
    }



}
