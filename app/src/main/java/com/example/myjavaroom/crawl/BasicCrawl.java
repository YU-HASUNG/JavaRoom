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
        //todo
        //메모장 줄 개수 (나누기 4) (빼기 1) / 소수점 아래는 버림 처리
        for(int i=0; i< 59768; i++) {

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

//            //소속팀 정보
//            String[] teams = new String[20];
//            Elements team = doc.getElementsByAttributeValue("class", "data_table");
//            Elements li = team.select("li");
//            for(int t=0; t<20; t++){
//                teams[t] = "";
//            }
//            for(int t=0; t<li.size(); t++){
//                Element teamOne = li.get(t);
//                if(teamOne.text().contains("~")) {
//                    teams[t] = teamOne.text().substring(12);
//                }
//                else{
//                    teams[t] = teamOne.text();
//                }
//            }

            //소속팀 정보
            String[] teams = new String[20];
            Elements team = doc.getElementsByAttributeValue("class", "td club");

            for(int t=0; t<20; t++){
                teams[t] = "";
            }
            for(int t=0; t<team.size(); t++){
                Element teamOne = team.get(t);
                teams[t] = teamOne.text();
            }

            //배열에 저장
            MainActivity.Season[i] = season;
            MainActivity.Nation[i] = nation;
            MainActivity.Pay[i] = pay;

            MainActivity.Position[i] = position;
            MainActivity.Position1[i] = position1;
            MainActivity.Position2[i] = position2;

            MainActivity.team1[i] = teams[0];
            MainActivity.team2[i] = teams[1];
            MainActivity.team3[i] = teams[2];
            MainActivity.team4[i] = teams[3];
            MainActivity.team5[i] = teams[4];
            MainActivity.team6[i] = teams[5];
            MainActivity.team7[i] = teams[6];
            MainActivity.team8[i] = teams[7];
            MainActivity.team9[i] = teams[8];
            MainActivity.team10[i] = teams[9];
            MainActivity.team11[i] = teams[10];
            MainActivity.team12[i] = teams[11];
            MainActivity.team13[i] = teams[12];
            MainActivity.team14[i] = teams[13];
            MainActivity.team15[i] = teams[14];
            MainActivity.team16[i] = teams[15];
            MainActivity.team17[i] = teams[16];
            MainActivity.team18[i] = teams[17];
            MainActivity.team19[i] = teams[18];
            MainActivity.team20[i] = teams[19];


//            System.out.println(season);
//            System.out.println(position);
//            System.out.println(position1);
//            System.out.println(position2);
//            System.out.println(nation);
//            System.out.println(pay);
            Log.d("crawl", "crawl"+i);
        }
    }
}
