package com.example.myjavaroom;

import android.os.Bundle;
import android.view.View;
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
    public static String[] APIArray = new String[54477];
    public static String[] Season = new String[54477];
    public static String[] Position = new String[54477];
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    if (count > APIArray.length-1) { //08/26 에러로 인해 -1 추가
                        System.out.println("이제 그만");
                        //adapter.notifyDataSetChanged();
                        break;
                    } else {

                        String sText = APIArray[count];
                        String sSeason = Season[count];
                        String sPosition = Position[count];

                        MainData data = new MainData();

                        data.setText(sText);
                        data.setSeason(sSeason);
                        data.setPosition(sPosition);

                        database.mainDao().insert(data);
                        System.out.println(sText);
                        System.out.println(sSeason);
                        System.out.println(sPosition);
                        System.out.println(count);

                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
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
                database.mainDao().reset(dataList);

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}