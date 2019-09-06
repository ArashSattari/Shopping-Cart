package com.example.arash.shoppinglist;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Arash on 4/28/2016.
 */
public class ExitFamily extends AsyncTask<Void, Void, Void> {

    Runnable mR;
    ProgressDialog dialog;
    String res_str = "";
    final String url;
    Context context;
    DatabaseHelper database;

    public ExitFamily(Context CONTEXT) {
        context = CONTEXT;
        dialog = new ProgressDialog(context);
        url = "https://black-function-122210.appspot.com/ms/family/" + FamilyGroupActivity.familyName_static +
                "/users/" + FamilyGroupActivity.userID_static;
    }

    @Override
    protected void onPreExecute() {
        dialog.setMessage("Processing...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(Void result) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        if (res_str.equals(""))
            Toast.makeText(context, "Server not responding", Toast.LENGTH_SHORT).show();
        else{
            FamilyGroupActivity.JoinStatus_static = false;
            database = new DatabaseHelper(context);
            database.clearFamilyMembers();
            database.clearNewItems();
            ((FamilyGroupActivity)context).updateMembersList();
            ((FamilyGroupActivity)context).updatePanel();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        Thread networkChecking = new Thread() {
            @Override
            public void run() {
                mR = new Runnable() {
                    @Override
                    public void run() {
                        HttpCallback cb = new HttpCallback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.d("main", "failed");
                            }

                            @Override
                            public void onSuccess(Response response) {
                                Log.d("main", "succeed");
                                try {
                                    res_str = response.body().string();
                                    Log.d("main", res_str);
                                }catch (IOException e){
                                    e.printStackTrace();
                                }

                            }
                        };


                        try {
                            deleteRequest(url, cb);

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                mR.run();
            }
        };
        networkChecking.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


    public interface HttpCallback{
        void onFailure(Call call, IOException e);

        void onSuccess(Response response);
    }

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void deleteRequest(String url, final HttpCallback cb) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .addHeader("Accept", "application/json")
                .addHeader("token", "test")
                .build();
        //request = addBasicAuthHeaders(request);       // add pwd and id

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //Log.i(TAG, Boolean.toString(httpService.NETWORK_AVAILABLE));
                cb.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                cb.onSuccess(response);

            }
        });
    }


}




