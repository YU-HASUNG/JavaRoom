package com.example.myjavaroom.crawl;

import android.util.Log;

import com.example.myjavaroom.MainActivity;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BasicCrawl extends Thread{

    public String position;
    public String position1;
    public String position2;

    public String season;
    public String pay;
    public String nation;


    public void run() {

        //for(int i=0; i< MainActivity.APIArray.length; i++) {
        for(int i=0; i< 54647; i++) { //전체 줄개수 (나누기 4) (빼기 1)

//            position = "N";
            //position1 = "N";
            //position2 = "N";
//            season = "";
//            pay = "";
//            nation = "";

            String spid = MainActivity.APIArray[i];
            String first = "https://fifaonline4.nexon.com/DataCenter/PlayerInfo?spid=";
            String last = "&n1Strong=1";
            String url = first + spid + last;

            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert doc != null;

            // 시즌 이미지 주소
            Elements nameWrap = doc.getElementsByAttributeValue("class", "name_wrap");
            Elements fullSeasonUrl =nameWrap.select("img");
            String temp = fullSeasonUrl.toString();
            int plus = 76;
            if(temp.length()>85){ //길이가 다른 링크를 통일해주기 위함
                plus = plus + (temp.length()-85);
            }
            season = fullSeasonUrl.toString().substring(70,plus-4);

            //포지션 정보
            Elements infoLine = doc.getElementsByAttributeValue("class", "info_line info_ab");
            Elements positionLine = infoLine.select("span");

            Element positionData = positionLine.get(1);
            position = positionData.text();
            if(positionLine.size()>=4) {
                Element positionData2 = positionLine.get(4);
                //position1 = positionData2.text().substring(0, positionData2.text().length()-3);
                position1 = positionData2.text();
            }
            else{
                position1 = "";
            }

            if(positionLine.size()>=7) {
                Element positionData3 = positionLine.get(7);
                //position2 = positionData3.text().substring(0, positionData3.text().length()-3);
                position2 = positionData3.text();
            }
            else{
                position2 = "";
            }

            //급여 정보
            Elements sideUtils = doc.getElementsByAttributeValue("class", "side_utils");
            Element sideUtils2 = sideUtils.get(0);
            pay = sideUtils2.text();

            //nation 정보
            Elements etcNation = doc.getElementsByAttributeValue("class", "etc nation");
            Elements nationLine = etcNation.select("span");
            Element nationEtc = nationLine.get(1);
            nation = nationEtc.text();


            //배열에 저장
            MainActivity.Season[i] = season;
            MainActivity.Position[i] = position;
            MainActivity.Position1[i] = position1;
            MainActivity.Position2[i] = position2;
            MainActivity.Nation[i] = nation;
            MainActivity.Pay[i] = pay;

            System.out.println(season);
            System.out.println(position);
            System.out.println(position1);
            System.out.println(position2);
            System.out.println(nation);
            System.out.println(pay);
            System.out.println(i);
            Log.d("crawl", String.valueOf(i));
        }
    }
}
