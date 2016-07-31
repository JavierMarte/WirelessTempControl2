package org.turntotech.samplejson;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.GestureDetectorCompat;
import android.util.*;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiso on 7/10/2016.
 */
public class OtherActivity extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private Spinner spinner2;
    public String json_urld = "http://192.168.240.1/arduino/digital/13/1";
    public String json_urld2 = "http://192.168.240.1/arduino/digital/13/0";
    public String json_urld3 = "http://192.168.240.1/arduino/digital/12/1";
    public String json_urld4 = "http://192.168.240.1/arduino/digital/12/0";
    public String json_urld5 = "http://192.168.240.1/arduino/digital/11/1";
    public String json_urld6 = "http://192.168.240.1/arduino/digital/11/0";
    public String json_urld7 = "http://192.168.240.1/arduino/digital/10/1";
    public String json_urld8 = "http://192.168.240.1/arduino/digital/10/0";
    String s2 = "192.168.240.1";
    String pin;
    TextView pinWord;
    private GestureDetectorCompat mDetector;

    //String str;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherlayout);
        EditText maxOne = (EditText) findViewById(R.id.editText3);
        EditText minTwo = (EditText) findViewById(R.id.editText4);


        Intent intent = getIntent();
        int message = intent.getIntExtra("max",TempControl.max);
        int message2 = intent.getIntExtra("min",TempControl.min);

        maxOne.setText(Integer.toString(message));
        minTwo.setText(Integer.toString(message2));
        System.out.println("yooooooooooooooooo" + message + message2);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        List<String> list = new ArrayList<String>();
        list.add("DigitOut13");
        list.add("DigitOut12");
        list.add("DigitOut11");
        list.add("DigitOut10");
        list.add("DigitOut9");
        list.add("DigitOut8");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("DigitOut13"))
                {
                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 13");

                    pin = "13";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);
                    // do your stuff
                }else if(selectedItem.equals("DigitOut12")){
                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 12");

                    pin = "12";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);

                }else if(selectedItem.equals("DigitOut11")){

                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 11");

                    pin = "11";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);
                }else if(selectedItem.equals("DigitOut10")){

                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 10");

                    pin = "10";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);
                }else if(selectedItem.equals("DigitOut9")){
                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 9");

                    pin = "9";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);

                }else if(selectedItem.equals("DigitOut8")){
                    pinWord = (TextView) findViewById(R.id.textView7) ;
                    pinWord.setText("Digital Pin 8");

                    pin = "8";
                    pin = pin.replaceAll("[\n\r]", "");
                    OtherActivity.this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
                    OtherActivity.this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
                    System.out.println(json_urld);

                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }
    public void next(View view) {
        EditText txt = (EditText) findViewById(R.id.editText);
        if (txt.getText().toString().equals("hello")) {
            LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

            mealLayout.setBackgroundColor(Color.RED);
            System.out.println("hey man");
            Intent i = new Intent(this, OtherActivity.class);
            startActivity(i);
        }

    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
//        //Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
//
//       EditText maxOne = (EditText) findViewById(R.id.editText3);
//        EditText minTwo = (EditText) findViewById(R.id.editText4);
//        //================================
//        String passone = "blue";
//        Intent returnIntent = new Intent();
//
//        returnIntent.putExtra("max",maxOne.getText().toString());
//        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        returnIntent.putExtra("min",minTwo.getText().toString());
//        setResult(Activity.RESULT_OK,returnIntent);
//
//        finish();
//        System.out.println("hello");
        return true;
    }

    @Override
    public void onBackPressed() {
        // your code.
        EditText maxOne = (EditText) findViewById(R.id.editText3);
        EditText minTwo = (EditText) findViewById(R.id.editText4);
        //================================
        String passone = "blue";
        Intent returnIntent = new Intent();
        int m = Integer.parseInt(maxOne.getText().toString());
        int n = Integer.parseInt(minTwo.getText().toString());
if(maxOne.getText().toString().equals(null) || minTwo.getText().toString().equals(null)) {
    returnIntent.putExtra("max", "90");
    System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    returnIntent.putExtra("min", "60");
}else if(m >= 100 || n <= 0){
    returnIntent.putExtra("max", "90");
    System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    returnIntent.putExtra("min", "60");

}else{
    returnIntent.putExtra("max", maxOne.getText().toString());
    System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    returnIntent.putExtra("min", minTwo.getText().toString());

}
        setResult(Activity.RESULT_OK,returnIntent);

        finish();
        System.out.println("hello");
    }
    public void hello(View view){
        //LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

       // mealLayout.setBackgroundColor(Color.GREEN);
        new MyAsyncTask().execute(json_urld);
        System.out.println(json_urld);
    }
    public void helloOff(View view){
       // LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

       // mealLayout.setBackgroundColor(Color.RED);
        new MyAsyncTask().execute(json_urld2);
        //mealLayout.setBackgroundColor(Color.parseColor("#fffff"));
    }
    public void onSelection(View view){
        //LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

        // mealLayout.setBackgroundColor(Color.GREEN);
        new MyAsyncTask().execute(json_urld);
        System.out.println(json_urld);
    }
    public void offSelection(View view){
        // LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

        // mealLayout.setBackgroundColor(Color.RED);
        new MyAsyncTask().execute(json_urld2);
        //mealLayout.setBackgroundColor(Color.parseColor("#fffff"));
    }
    public void IPchange(View view){
        EditText change = (EditText) findViewById(R.id.editText2);
        //str = "";
        String str = change.getText().toString();
        s2 = str.replaceAll("[\n\r]", "");

        this.json_urld = "http://"+ s2 +"/arduino/digital/13/1";
        this.json_urld2 = "http://"+ s2 +"/arduino/digital/13/0";
        //new MyAsyncTask().execute(json_urld);
        System.out.println(json_urld);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }
    public void wifi(View view){
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));

    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    //    public void thirteen(View view){
//        //String s2 = str.replaceAll("[\n\r]", "");
//        pinWord = (TextView) findViewById(R.id.textView7) ;
//        pinWord.setText("Digital Pin 13");
//
//        pin = "13";
//        pin = pin.replaceAll("[\n\r]", "");
//        this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
//        this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
//        System.out.println(json_urld);
//
//    }
//    public void twelve(View view){
//        //String s2 = str.replaceAll("[\n\r]", "");
//        pinWord = (TextView) findViewById(R.id.textView7) ;
//        pinWord.setText("Digital Pin 12");
//        pin = "12";
//        pin = pin.replaceAll("[\n\r]", "");
//        this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
//        this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
//        System.out.println(json_urld);
//
//    }
//    public void eleven(View view){
//        //String s2 = str.replaceAll("[\n\r]", "");
//        pinWord = (TextView) findViewById(R.id.textView7) ;
//        pinWord.setText("Digital Pin 11");
//        this.pin = "11";
//        this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
//        this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
//
//    }
//    public void ten(View view){
//        //String s2 = str.replaceAll("[\n\r]", "");
//        pinWord = (TextView) findViewById(R.id.textView7) ;
//        pinWord.setText("Digital Pin 10");
//        this.pin = "10";
//        this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
//        this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
//
//    }
//    public void nine(View view){
//        //String s2 = str.replaceAll("[\n\r]", "");
//        pinWord = (TextView) findViewById(R.id.textView7) ;
//        pinWord.setText("Digital Pin 9");
//        this.pin = "9";
//        this.json_urld = "http://"+ s2 +"/arduino/digital/"+ pin +"/1";
//        this.json_urld2 = "http://"+ s2 +"/arduino/digital/" + pin +"/0";
//
//    }
    private class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            // http client
            DefaultHttpClient httpclient = new DefaultHttpClient(
                    new BasicHttpParams());
            HttpGet httpget = new HttpGet(params[0]);
            HttpResponse response;
            try {
                // Calling async task to get json
                response = httpclient.execute(httpget);
                return EntityUtils.toString(response.getEntity());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }


        protected void onPostExecute(String result) {

            //Log.d(TAG, "JSON Raw Data" + result);

            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
