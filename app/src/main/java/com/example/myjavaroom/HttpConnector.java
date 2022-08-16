package com.example.myjavaroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpConnector extends Thread{
    public static String[] APIArray = new String[15];
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
                    for(int i=0;i<30;i++){ //216706
                        line = reader.readLine();
                        if((i+2)%4==0){
                            String spid = line.substring(14,23);
                            APIArray[num] = spid;
                            System.out.println(spid);
                            num++;
                        }
                    }
                }
                conn.disconnect();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

