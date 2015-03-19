package com.ocean.gradualchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {

	private Button btn_single;
	private Button btn_gradual;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		btn_single = (Button) findViewById(R.id.btn_single);
		btn_gradual = (Button) findViewById(R.id.btn_gradual);
		
		btn_single.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent singleIntent = new Intent(StartActivity.this,SingleActivity.class);
				startActivity(singleIntent);
			}
		});
		
		btn_gradual.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent gradualIntent = new Intent(StartActivity.this,GradientActivity.class);
				startActivity(gradualIntent);
			}
		});
	}
}
