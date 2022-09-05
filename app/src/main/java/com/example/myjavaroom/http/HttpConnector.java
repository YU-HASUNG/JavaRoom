package com.example.myjavaroom.http;

import static com.example.myjavaroom.MainActivity.APIArray;

import com.example.myjavaroom.crawl.BasicCrawl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpConnector extends Thread{
    int num = 0;

    @Override
    public void run() {
        try{
            URL url = new URL("https://static.api.nexon.co.kr/fifaonline4/latest/spid.json");
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

            if(conn != null) {
                conn.setConnectTimeout(10000000);
                conn.setRequestMethod("GET");

                int resCode = conn.getResponseCode();
                int HTTP_OK = HttpsURLConnection.HTTP_OK;

                if(resCode == HTTP_OK) {
                    String line = null;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    for(int i=0;i<217469;i++){ //216706
                    for(int i=0;i<217910;i++){ //22.08.26
                        line = reader.readLine();
                        if((i+2)%4==0){
                            String spid = line.substring(14,23);
                            APIArray[num] = spid;
                            System.out.println(spid);
                            num++;
                        }
                    }
                    //System.out.println("마지막 spid"+APIArray[54366]);
                    System.out.println("마지막 spid"+APIArray[54477]);
                }
                conn.disconnect();
                Thread.sleep(10000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //position,season 얻어오는 crawl Thread
        BasicCrawl basicCrawl = new BasicCrawl();
        basicCrawl.start();
    }

}

