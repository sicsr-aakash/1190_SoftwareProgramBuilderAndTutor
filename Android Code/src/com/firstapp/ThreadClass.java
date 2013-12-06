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

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadClass implements Runnable{

	String data,responseText;
	Handler handler;
	/*public ThreadClass(Handler handler,String Data) {
		data = Data;
		
	}*/
		public ThreadClass(Handler handler1, String Data) {
			this.data = Data;
			
			this.handler = handler1;
	}
		// TODO Auto-generated constructor stub
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
		        System.out.println(responseText+"^^^^^^^^^^^^^ OUTPUT IN THREADCLASS ^^^^^^^^^^^^^^^");
		        //doRemaining(responseText);
		        Message message = new Message();
		        Bundle bundle1 = new Bundle();
		        bundle1.putString("output",responseText);
		        message.setData(bundle1);
		        System.out.println(message);
		        //this.handler.dispatchMessage(message);
		        String temp = message.getData().toString();
		        System.out.println(temp);
		        this.handler.sendMessage(message);
		        return;
		        
		    }


		    catch(Exception e) {
		        Log.e("log_tag", "Error in http connection"+e.toString());

		    }

		        
		}

	

}
