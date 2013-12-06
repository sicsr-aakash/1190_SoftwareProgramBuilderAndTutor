package com.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class OptionLandup extends Activity {

	Button button;
	Spinner option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_landup);
        button = (Button) findViewById(R.id.button1);
        option = (Spinner) findViewById(R.id.spinner1);
        button.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//System.out.println("============== System print =============");
				Intent obj = new Intent(getApplicationContext(),Builder.class);
				String OptionName = option.getSelectedItem().toString();
				obj.putExtra("option",OptionName);
				startActivity(obj);
			}
		});
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
