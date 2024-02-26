package ed.app.eatlist.services.impl;

import android.os.StrictMode;

import org.chromium.base.task.AsyncTask;

import java.io.IOException;

import ed.app.eatlist.services.FoodService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FoodServiceImpl extends AsyncTask implements FoodService  {

    @Override
    public String getFood() throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.1.67:8080/food")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected String doInBackground() {
        return "Loading";
    }

    @Override
    protected void onPostExecute(Object o) {
    }
}
