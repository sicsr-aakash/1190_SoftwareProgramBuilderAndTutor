package com.firstapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;

public class TutorDetailActivity extends Activity {
TextView show_about;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutor_detail);
	
		show_about=(TextView) findViewById(R.id.edt_ShowText);
		Intent i=getIntent();
		Bundle get_data=i.getExtras();
				
		String option=get_data.getString("option");
		
		String temp=null,fileName=null;
		StringBuffer rawData=new StringBuffer();
		//InputStream in=null;
		if(option.equalsIgnoreCase("Arrays"))
		{
			fileName="aboutArrays.txt";
		}
		else if(option.equalsIgnoreCase("Classes"))
		{
			fileName="aboutClass.txt";
		}
		else if(option.equalsIgnoreCase("Constants"))
		{
			fileName="aboutConstants.txt";
		}
		else if (option.equalsIgnoreCase("DataTypes"))
		{
			fileName="aboutDataTypes.txt";
		}

		else if(option.equalsIgnoreCase("Functions"))
		{
			fileName="aboutFunctionss.txt";
		}
		else if (option.equalsIgnoreCase("Input/Output"))
		{
			fileName="aboutInputOutput.txt";
		}

				
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new InputStreamReader(getAssets().open(fileName)));
			while((temp=br.readLine())!=null)
			{
				rawData.append(temp);
				rawData.append("\n");
			
			}
		} 
		
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				show_about.setText(Html.fromHtml(rawData.toString()));
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutor_detail, menu);
		return true;
	}

}
