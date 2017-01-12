package com.example.liyanju.androiddemo.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liyanju on 2016/12/29.
 */

public interface GitHubService {

    public static class Contributor {
        public final String login;
        public final int contributions;
        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
        @Override
        public String toString() {
            return "Contributor{" +
                    "login='" + login + '\'' +
                    ", contributions=" + contributions +
                    '}';
        }
    }

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>>  contributors(@Path("owner") String owner,
                           @Path("repo") String repo);

}
