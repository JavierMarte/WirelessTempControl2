package org.turntotech.samplejson;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

/**
 * Created by kaiso on 7/16/2016.
 */
public class TempControl2 extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private GestureDetectorCompat mDetector;
    DonutProgress hey;
    ProgressBar hey2;
    static int max = 90;
    static int min = 60;
    boolean condition = false;
    int lowTempthresh = 72;
    int highTempthresh = 78;
    int i = 60;
    Float x = 0f;
    String s2 = "192.168.240.1";
    String pin;
    String json_urld;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.templayout2);
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        //android.util.Log.i("TurnToTech", "Project Name - Sample JSON");

        //progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        hey = (DonutProgress) findViewById(R.id.view);
        hey.setProgress(50);
        hey2 = (ProgressBar) findViewById(R.id.progressBar);
//        Thread t = new Thread() {
//
//            @Override
//            public void run() {
//                try {
//                    while (!isInterrupted()) {
//                        Thread.sleep(1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                if(lowTempthresh > i) {
//                                    new MyAsyncTask().execute("http://192.168.240.1/arduino/digital/13/1");
//                                }else {
//                                    new MyAsyncTask().execute("http://192.168.240.1/arduino/digital/13/0");
//                                }
//                                if(highTempthresh < i){
//
//                                    new MyAsyncTask().execute("http://192.168.240.1/arduino/digital/12/1");
//                                }else {
//                                    new MyAsyncTask().execute("http://192.168.240.1/arduino/digital/12/0");
//                                }
//
//
//                            }
//                        });
//                    }
//                } catch (InterruptedException e) {
//                }
//            }
//        };
//
//        t.start();

    }







    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
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
    public void onBackPressed() {
        // your code.
        System.out.println("heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        finish();
    }


    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }
public void on(View view){

    json_urld = "http://"+ s2 +"/arduino/digital/13/1";
    new MyAsyncTask().execute(json_urld);
    condition = true;
}
    public void off(View view){
        json_urld = "http://"+ s2 +"/arduino/digital/13/0";
        new MyAsyncTask().execute(json_urld);
        json_urld = "http://"+ s2 +"/arduino/analog/11/0";
        new MyAsyncTask().execute(json_urld);
        condition = false;
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {

        int diff = (max - min) + 1;
        Float inc = (255f/diff);

        //Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
        if(velocityX < 0 && i < max) {
            if(condition == true) {
            x = x + inc;
                System.out.println(x);
            i = 1 + i;

                    hey.setProgress(i);
                    hey2.setProgress(i);

            //analog/2/123"

           // json_urld = "http://"+ s2 +"/arduino/digital/13/1";
          //  new MyAsyncTask().execute(json_urld);

                json_urld = "http://" + s2 + "/arduino/analog/11/" + Float.toString(x);
                new MyAsyncTask().execute(json_urld);
            }else{

                json_urld = "http://" + s2 + "/arduino/analog/11/0";
                new MyAsyncTask().execute(json_urld);
                json_urld = "http://"+ s2 +"/arduino/digital/13/0";
                new MyAsyncTask().execute(json_urld);
                Context context = getApplicationContext();
                CharSequence text = "Currently disabled";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

            //
            ;
        }else if(velocityX > 0 && i > min){
            if(condition == true) {
            i = i - 1;
            x = x - inc;
                System.out.println(x);
            hey.setProgress(i);
            hey2.setProgress(i);
            //json_urld = "http://"+ s2 +"/arduino/analog/11/" + Integer.toString(i);
            //json_urld = "http://"+ s2 +"/arduino/digital/13/0";
            //requestData(json_urld);
           // json_urld = "http://"+ s2 +"/arduino/digital/13/0";
           // new MyAsyncTask().execute(json_urld);

                json_urld = "http://" + s2 + "/arduino/analog/11/" + Float.toString(x);
                new MyAsyncTask().execute(json_urld);
            }else{

                json_urld = "http://" + s2 + "/arduino/analog/11/0";
                new MyAsyncTask().execute(json_urld);
                json_urld = "http://"+ s2 +"/arduino/digital/13/0";
                new MyAsyncTask().execute(json_urld);
                Context context = getApplicationContext();
                CharSequence text = "Currently disabled";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        }
        if(i <= min ){
            i = min;
        }
        if(i >= max){
            i = max;
        }
        TextView hello = (TextView) findViewById(R.id.textView6);

        hello.setText(Integer.toString(i));
        System.out.println("incremtnt = " + i);
        System.out.println("x =" + velocityX);
        System.out.println("y =" + velocityY);
        return true;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
    public void heyy(View view){
        Intent intent = new Intent(this, OtherActivity.class);
        int a = 0;
        int b = 0;
        //intent.putExtra("result", a);
       // intent.putExtra("result", b);
        //Bundle extras = new Bundle();
        intent.putExtra("max",max);
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        intent.putExtra("min",min);

        //setResult(Activity.RESULT_OK,returnIntent);
        startActivityForResult(intent, 1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                this.max = Integer.parseInt(data.getStringExtra("max"));
                this.min = Integer.parseInt(data.getStringExtra("min"));

            }
        }
    }
    public void login(View view){

        finish();
    }

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
