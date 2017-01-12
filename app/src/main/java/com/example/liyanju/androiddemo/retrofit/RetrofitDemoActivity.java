package com.example.liyanju.androiddemo.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.liyanju.androiddemo.R;


import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.liyanju.androiddemo.R.string.test;

/**
 * Created by liyanju on 2016/12/29.
 */

public class RetrofitDemoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_button_layout);

        TextView textView = (TextView)findViewById(R.id.tv);
        textView.setText(Html.fromHtml(getString(R.string.test)));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {

                    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    GitHubService gitHubService = retrofit.create(GitHubService.class);
                    Call<List<GitHubService.Contributor>> call = gitHubService.contributors("square", "retrofit");
                    call.enqueue(new Callback<List<GitHubService.Contributor>>() {
                        @Override
                        public void onResponse(Call<List<GitHubService.Contributor>> call, Response<List<GitHubService.Contributor>> response) {
                            Log.v("xx", " response.body(): " + response.body().toString());
                        }

                        @Override
                        public void onFailure(Call<List<GitHubService.Contributor>> call, Throwable t) {

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
