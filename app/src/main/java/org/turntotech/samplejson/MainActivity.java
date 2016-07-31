/*
 * JSON is very light weight, structured, easy to parse and much human readable. 
 * JSON is best alternative to XML when your android app needs to interchange data 
 * with your server.
 * In this example we are going to learn how to parse JSON in android.
 */

package org.turntotech.samplejson;


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
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MainActivity extends Activity {
	MainActivity yes;
	private final String TAG = "Sample JSON";
	private ListView lView;
	private ArrayAdapter<String> adapter;
	ArrayList<String> data;

	private static String[] json_url = {"http://finance.google.com/finance/info?q=NASDAQ:AAPL", "http://finance.google.com/finance/info?q=NASDAQ:AMZN", "http://finance.google.com/finance/info?q=NASDAQ:MSFT", "http://finance.google.com/finance/info?q=NASDAQ:FB", "http://finance.google.com/finance/info?q=NASDAQ:GOOG"};
	//private static String json_url2 = "http://finance.google.com/finance/info?q=NASDAQ:GOOG";
	public String json_urld = "http://192.168.1.109/arduino/digital/13/1";
	public String json_urld2 = "http://192.168.1.109/arduino/digital/13/0";


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        Log.i("TurnToTech", "Project Name - Sample JSON");

	}

	public void buttonClicked(View view) {

		//new MyAsyncTask().execute(json_url[0]);
		//	new MyAsyncTask().execute(json_url[1]);
		//new MyAsyncTask().execute(json_url[2]);
		//new MyAsyncTask().execute(json_url[3]);
		//new MyAsyncTask().execute(json_url[4]);
		//new MyAsyncTask().execute(json_url2);
	}

	/*
        public void hello(View view){
            LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

            mealLayout.setBackgroundColor(Color.GREEN);
            new MyAsyncTask().execute(json_urld);
        }
        public void helloOff(View view){
            LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

            mealLayout.setBackgroundColor(Color.RED);
            new MyAsyncTask().execute(json_urld2);
            //mealLayout.setBackgroundColor(Color.parseColor("#fffff"));
        }
        */
	public void next(View view) {
		EditText txt = (EditText) findViewById(R.id.editText);
		EditText use = (EditText) findViewById(R.id.editText5);
		String url = "https://churchacunit.firebaseio.com/users/" + use.getText().toString() + ".json";
System.out.println();
		if (txt.getText().toString().equals("password2") && use.getText().toString().equals("admin")) {
			System.out.println("yuoooooooooooooooooooooooooooooooooooooooooo");

			txt.setText("");
			LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

			mealLayout.setBackgroundColor(Color.RED);
			System.out.println("hey man");
			Intent i = new Intent(this, TempControl.class);
			startActivity(i);

		}

		if (txt.getText().toString().equals("password") && use.getText().toString().equals("pastor")) {
			System.out.println("yuoooooooooooooooooooooooooooooooooooooooooo");

			txt.setText("");
			LinearLayout mealLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

			mealLayout.setBackgroundColor(Color.RED);
			System.out.println("hey man");
			Intent i = new Intent(this, TempControl2.class);
			startActivity(i);

		}
	}




public void nah(View view){

	postData("https://churchacunit.firebaseio.com/users.json", "admin", "password2");
	//requestData("https://parentchild-6751b.firebaseio.com/users/-KMpDrArYDA3w0GyaR_n/users.json");



}
	private String requestData(String uri) {

		RequestPackage p = new RequestPackage();
		p.setMethod("GET");
		p.setUri(uri);
		p.setParam("admin", "password2");
		//p.setParam("price", "13.95");

		//MyTask task = new MyTask();
		//task.execute(p);
		MyTask task = new MyTask();
		try {
			String hey  = task.execute(p).get();
			hey = hey.replace("\"", "");
			hey.replaceAll("\n\r", "");
			return hey;

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	private void postData(String uri, String user, String password) {

		RequestPackage p = new RequestPackage();
		p.setMethod("PUT");
		p.setUri(uri);
		p.setParam(user, password);


		MyTask task = new MyTask();
		task.execute(p);
	}



	private class MyTask extends AsyncTask<RequestPackage, String, String> {

		@Override
		protected String doInBackground(RequestPackage... params) {
			String content = HttpManager.getData(params[0]);
			//System.out.println("heuyyyyyyyyyyyyyyy" + content);
			return content;
		}



	}





}


