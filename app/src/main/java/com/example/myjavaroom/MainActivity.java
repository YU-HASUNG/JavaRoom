package com.example.myjavaroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myjavaroom.crawl.BasicCrawl;
import com.example.myjavaroom.http.HttpConnector;

import java.util.ArrayList;
import java.util.List;

//22.08.19 데이터 추출 한 30개 누락되고 나머지는 성공
public class MainActivity extends AppCompatActivity
{

    EditText editText;
    Button btAdd, btReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;

    //DB에 넣을 정보 저장할 배열 선언
//    public static String[] APIArray = new String[54367];
//    public static String[] Season = new String[54367];
//    public static String[] Position = new String[54367];
    public static String[] APIArray = new String[54649]; //(나누기 4) (플러스 1)
    public static String[] Season = new String[54649];
    public static String[] Nation = new String[54649];
    public static String[] Pay = new String[54649];

    public static String[] Position = new String[54649];
    public static String[] Position1 = new String[54649];
    public static String[] Position2 = new String[54649];

    public static String[] team1 = new String[54649];
    public static String[] team2 = new String[54649];
    public static String[] team3 = new String[54649];
    public static String[] team4 = new String[54649];
    public static String[] team5 = new String[54649];
    public static String[] team6 = new String[54649];
    public static String[] team7 = new String[54649];
    public static String[] team8 = new String[54649];
    public static String[] team9 = new String[54649];
    public static String[] team10 = new String[54649];
    public static String[] team11 = new String[54649];
    public static String[] team12 = new String[54649];
    public static String[] team13 = new String[54649];
    public static String[] team14 = new String[54649];
    public static String[] team15 = new String[54649];
    public static String[] team16 = new String[54649];
    public static String[] team17 = new String[54649];
    public static String[] team18 = new String[54649];
    public static String[] team19 = new String[54649];
    public static String[] team20 = new String[54649];



    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면꺼짐 방지
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //spid 얻어오는 Http 연결 Thread
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();

        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapter(MainActivity.this, dataList);

        recyclerView.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                String sText = editText.getText().toString().trim();
//                if (!sText.equals(""))
//                {
//                    MainData data = new MainData();
//                    data.setText(sText);
//                    database.mainDao().insert(data);
//
//                    editText.setText("");
//
//                    dataList.clear();
//                    dataList.addAll(database.mainDao().getAll());
//                    adapter.notifyDataSetChanged();
//                }
                while (true) {

                    //if (count > APIArray.length) {
                    //if (count > APIArray.length-1) { //08/26 에러로 인해 -1 추가
                    if (count > 54646) { //전체 줄개수 (나누기 4) (빼기 2)
//                    if (count > 99) { //전체 줄개수 (나누기 4) (빼기 2) test
//                        System.out.println("이제 그만");
                        Log.d("stop", "이제그만");
                        //adapter.notifyDataSetChanged();
                        break;
                    } else {

                        String sText = APIArray[count];
                        String sSeason = Season[count];
                        String sPosition = Position[count];
                        String sPosition1 = Position1[count];
                        String sPosition2 = Position2[count];
                        String sNation = Nation[count];
                        String sPay = Pay[count];

                        String sTeam1 = team1[count];
                        String sTeam2 = team2[count];
                        String sTeam3 = team3[count];
                        String sTeam4 = team4[count];
                        String sTeam5 = team5[count];
                        String sTeam6 = team6[count];
                        String sTeam7 = team7[count];
                        String sTeam8 = team8[count];
                        String sTeam9 = team9[count];
                        String sTeam10 = team10[count];
                        String sTeam11 = team11[count];
                        String sTeam12 = team12[count];
                        String sTeam13 = team13[count];
                        String sTeam14 = team14[count];
                        String sTeam15 = team15[count];
                        String sTeam16 = team16[count];
                        String sTeam17 = team17[count];
                        String sTeam18 = team18[count];
                        String sTeam19 = team19[count];
                        String sTeam20 = team20[count];

                        MainData data = new MainData();

                        data.setText(sText);
                        data.setSeason(sSeason);
                        data.setPosition(sPosition);
                        data.setPosition1(sPosition1);
                        data.setPosition2(sPosition2);
                        data.setNation(sNation);
                        data.setPay(sPay);

                        data.setTeam1(sTeam1);
                        data.setTeam2(sTeam2);
                        data.setTeam3(sTeam3);
                        data.setTeam4(sTeam4);
                        data.setTeam5(sTeam5);
                        data.setTeam6(sTeam6);
                        data.setTeam7(sTeam7);
                        data.setTeam8(sTeam8);
                        data.setTeam9(sTeam9);
                        data.setTeam10(sTeam10);
                        data.setTeam11(sTeam11);
                        data.setTeam12(sTeam12);
                        data.setTeam13(sTeam13);
                        data.setTeam14(sTeam14);
                        data.setTeam15(sTeam15);
                        data.setTeam16(sTeam16);
                        data.setTeam17(sTeam17);
                        data.setTeam18(sTeam18);
                        data.setTeam19(sTeam19);
                        data.setTeam20(sTeam20);

                        database.mainDao().insert(data);
                        Log.d("save", "save"+count);
//                        System.out.println(sText);
//                        System.out.println(sSeason);
//                        System.out.println(sPosition);
//                        System.out.println(count);

//                        dataList.clear();
//                        dataList.addAll(database.mainDao().getAll());
                        //adapter.notifyDataSetChanged();


                        count++;
                    }
                }
            }
        });

        btReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                database.mainDao().reset(dataList);
//
//                dataList.clear();
//                dataList.addAll(database.mainDao().getAll());
//                adapter.notifyDataSetChanged();
            }
        });
    }
}