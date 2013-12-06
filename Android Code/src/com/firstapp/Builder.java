package com.firstapp;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Builder extends Activity implements Runnable {
	EditText edt_res;
	Handler handler;
	Bundle temp;
	Button button;
	TextView txt;
	String option;
	String tmpData;
	public String Data;
	public static String responseText;
	//String data="Dummy text this is";
	String optionArr[];
	public static String data = "#include<iostream> \n using namespace std;";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_builder);
		temp = getIntent().getExtras();
		option = (String) temp.get("option");
		edt_res=(EditText) findViewById(R.id.EditText02);
		button = (Button) findViewById(R.id.button1);
		txt = (TextView) findViewById(R.id.textView1);
		
		
		
	if(option.equalsIgnoreCase("Basic_Template"))
	{	
		
		data=data+"int main() { cout<<\"Helloworld\";"+""+"return 0;}";
		System.out.println("++++++++++ Complete data "+data);
	}
	else if(option.equalsIgnoreCase("Functions"))
	{
		data=data+"int main() { function hello() {cout<<\"Helloworld\";"+"} hello();"+"return 0;}";
		System.out.println("++++++++++ Complete data "+data);
	}
	else if(option.equalsIgnoreCase("Classes"))
	{
		
	}
	else if(option.equalsIgnoreCase("Arrays"))
	{}
	else if(option.equalsIgnoreCase("DataTypes"))
	{
		data=data+"int i=5 ;" +"\n"+
			 "float f=9.9 ;" +"\n"+
			 "long l=3.4 ;" +"\n"+
			 "double d=99 ;" +"\n"+
			 "char ch=\"d\";"+
			 "System.out.println(\"Integer i\""+"i"+
					 "Float f"+"+"+"f}";
		
	}		
	else if(option.equalsIgnoreCase("Constants"))
	{}
	else
	{}
	edt_res.setText(data.toString());
	
	button.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) 
		{
			//txt.setText(responseText.toString());
			System.out.println("------------------"+option);
			data = edt_res.getText().toString();
			System.out.println("------------------"+data);
			//(new Thread(new Builder())).start();
			ThreadClass obj = new ThreadClass(handler,data);
			Thread childThread = new Thread(obj);
			childThread.start();
			/*Intent obj = new Intent(getApplicationContext(),Abc_activity.class);
			startActivity(obj);*/
			System.out.println("This is SKJSDfkJSDKFJKDJF"+responseText);
			
		}
		});
		handler = new Handler()
		{
			
			public void handleMessage(Message msg)
			{
				//System.out.println("--------------- In Handler -------------------");
				String Output = msg.getData().getString("output").toString();
				System.out.println("--------------- In Handler -------------------");
				System.out.println(Output);
				txt.setText(Output.toString());
				
			}
			
		};
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.builder, menu);
		return true;
	}
	
	
	public void ShowSelectedOption(String result)
	{
		
		
	}
	public void doRemaining(String output)
	{
		System.out.println("Id : DoRemaining ---------"+output);
		
	}
	
	
	@Override
	public void run() {
		
		ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		System.out.println("In runnable classs*******************"+data);
		nameValuePair.add(new BasicNameValuePair("uname", data));
	    nameValuePair.add(new BasicNameValuePair("pwd", "sachin"));

	    try {
	    	
	        //EXECUTE POST
	        HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://192.168.0.101/local.php");
	        httppost.setHeader("Content-Type",
	                "application/x-www-form-urlencoded;");
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
	        HttpResponse response = httpclient.execute(httppost);
	        System.out.println("----------------------------");
	        responseText = EntityUtils.toString(response.getEntity());
	        System.out.println(responseText+"^^^^^^^^^^^^^ OUTPUT ^^^^^^^^^^^^^^^");
	        //doRemaining(responseText);
	        Message message = new Message();
	        Bundle bundle1 = new Bundle();
	        bundle1.putString("output",responseText);
	        message.setData(bundle1);
	        this.handler.sendMessage(message);
	        
	    }


	    catch(Exception e) {
	        Log.e("log_tag", "Error in http connection"+e.toString());

	    }

	        
	}
	

}
