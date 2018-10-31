package com.ahmed.httpprojectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    ListView listView = findViewById(R.id.list);
    Button button = findViewById(R.id.btn_load);
    URL url;
    String link = "http://pastebin.com/raw/wgkJgazE";
    HttpURLConnection urlConnection;
    InputStream inputStream;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            url = new URL(link);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        try {
                            urlConnection = (HttpURLConnection) url.openConnection();
                            urlConnection.setRequestMethod("GET");
                            inputStream = urlConnection.getInputStream();
                            int c =0;
                            StringBuffer buffer = new StringBuffer();
                            int responceCode = urlConnection.getResponseCode();
                            if(responceCode == HttpURLConnection.HTTP_OK){
                                while ((c = inputStream.read()) != -1){
                                    buffer.append((char)c);
                                }

                            }
                            result = buffer.toString();

                            JSONArray array = new JSONArray(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
    }
}
