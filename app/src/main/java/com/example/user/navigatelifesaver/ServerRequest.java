package com.example.user.navigatelifesaver;

import android.util.Log;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by User on 8/27/2016.
 */
public class ServerRequest {
    String SERVER = " https://2e0096f8.ngrok.io/";
    String value = "";
    Boolean check_request = false;
    Patient[] patient_list;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public String user_sign_up(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    OkHttpClient client = new OkHttpClient();

    public void doctor_view_setup() {
        try
        {
            value = req( SERVER + "general");


            Log.d("RESPONSE", "this is the responce in json from server: " + value);
            JSONtoPatient(value);
        }
        catch (Exception e)
        {


            check_request =true;
            Log.d("server requests error", e.toString());
            e.printStackTrace();
        }
    }






    String req(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        Log.d("RAW_RESPONCE" , response.toString());
        return response.body().string();
    }


    private Patient[] JSONtoPatient(String message){
        ObjectMapper mapper = new ObjectMapper();
        try {

            patient_list = mapper.readValue(message, Patient[].class);
            Log.d("JSON convertion", " ################ success ###########");
            return patient_list;
        } catch(JsonGenerationException e){
            Log.d("JSON convertion error", e.toString());
            e.printStackTrace();

        } catch (JsonMappingException e){
            Log.d("JSON convertion error", e.toString());
            e.printStackTrace();
        } catch (IOException e){
            Log.d("JSON convertion error", e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
