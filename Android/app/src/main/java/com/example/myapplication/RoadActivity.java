package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RoadActivity extends AppCompatActivity {
    private String jsonString;
    ArrayList<test> memberArrayList;
    TextView text1;
    TextView text2;
    TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);

        text1=(TextView)findViewById(R.id.text1);
        text2=(TextView)findViewById(R.id.text2);
        text3=(TextView)findViewById(R.id.text3);
        String url = "http://hostsoo.dothome.co.kr/subin.php";

        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();


        test1 test1 = new test1();

        if(test1.getName().equals("kpu")){
            text1.setText("한국산업기술대학교");
            text1.setPaintFlags(text1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        }else{
            text1.setText("아무것도아님");
        }
        text2.setText("온도: " + test.getTemp1() + ",  습도: " + test.getHumi1() + "  날씨: " + test.getWeather());

        if(test1.getRoad().equals("blackice")){
            text3.setText(" ★ 블랙아이스 위험 도로입니다 ★");

        }else if(test1.getRoad().equals("noblack")){
            text3.setText("블랙아이스 의심 도로입니다.");
        }else{
            text3.setText("안전한 도로입니다.");
        }

        final JsonParse jsonParse = new JsonParse();    //AsyncTask 생성
        jsonParse.execute("http://hostsoo.dothome.co.kr/sebin.php");
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpConnection requestHttpConnection = new RequestHttpConnection();
            result = requestHttpConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);
            test1 test1 = new test1();

            String str[]=s.split(",");
            test1.setRoad(str[0]);
            test1.setName(str[1]);
            //test1.setRoad(s);
            // test1.setRoad(s);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            if(str[0].equals("blackice")) {


            }
        }
    }




    public class JsonParse extends AsyncTask<String, Void, String> {
        String TAG = "JsonParseTest";

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];    //excute의 매개변수를 받아와 사용
            try {
                String selectData = "tem=TEM";

                URL serverURL = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) serverURL.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();

                //어플에서 데이터 전송
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(selectData.getBytes("UTF-8"));
                //et_password.setText(selectData);
                outputStream.flush();
                outputStream.close();

                int responseStatusCode = httpURLConnection.getResponseCode();

                //연결 상태 확인
                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }

                bufferedReader.close();
                Log.d(TAG, sb.toString().trim());

                return sb.toString().trim();    //받아온 JSON의 공백 제거
            } catch (Exception e) {
                Log.d(TAG, "InsertData: Error", e);
                return null;
            }
        }

        //doInBackgroundString에서 return한 값을 받음
        @Override
        protected void onPostExecute(String fromdoInBackgroundString) {
            super.onPostExecute(fromdoInBackgroundString);

            if (fromdoInBackgroundString == null) {//text.setText("1");
            } else {
                jsonString = fromdoInBackgroundString;
                memberArrayList = doParse();
                if (memberArrayList.size() == 0) {
                } else {

                    //text.setText("온도: "+test.getTemp()+", 습도: "+test.getHum());
                }
            }
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        //JSON을 가공하여 ArrayList에 넣음
        private ArrayList<test> doParse() {
            ArrayList<test> tmpMemberArray = new ArrayList<test>();

            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("arduino");

                test tmpTest = new test();
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject item = jsonArray.getJSONObject(i);

                    tmpTest.setTemp1(item.getString("temp1"));
                    tmpTest.setHumi1(item.getString("humi1"));
                    tmpTest.setWeather(item.getString("weather"));
                    tmpMemberArray.add(tmpTest);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return tmpMemberArray;
        }
    }
}
