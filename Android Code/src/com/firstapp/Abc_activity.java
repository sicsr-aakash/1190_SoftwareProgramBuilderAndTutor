package com.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Abc_activity extends Activity {

	Button button;
	Button btn_Tutor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abc_activity);
		button = (Button) findViewById(R.id.button2);
		btn_Tutor=(Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					//Intent obj = new Intent(getApplicationContext(),Abc_activity.class);
					Intent obj = new Intent(getApplicationContext(),OptionLandup.class);
					startActivity(obj);
				}
			});
		
		btn_Tutor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),TutorSelectTopicActivity.class);
				startActivity(i);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.abc_activity, menu);
		return true;
	}

}
