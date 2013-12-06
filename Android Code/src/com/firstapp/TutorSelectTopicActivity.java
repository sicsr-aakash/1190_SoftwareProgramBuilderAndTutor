package com.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class TutorSelectTopicActivity extends Activity
{
Spinner option;
Button btn_Show;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutor_select_topic);
	
		btn_Show=(Button) findViewById(R.id.button1);
		option=(Spinner) findViewById(R.id.spinner1);
		
		btn_Show.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent obj = new Intent(getApplicationContext(),TutorDetailActivity.class);
				String OptionName = option.getSelectedItem().toString();
				obj.putExtra("option",OptionName);
				startActivity(obj);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutor_select_topic, menu);
		return true;
	}

}
