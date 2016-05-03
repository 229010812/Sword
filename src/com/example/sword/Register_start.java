package com.example.sword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Register_start extends Activity {
	private Button btnstu,btntea;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_start);
		btnstu=(Button) findViewById(R.id.btnstu);
		btntea=(Button) findViewById(R.id.btntea);
		btntea.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Register_start.this,Regist_tea.class);
				startActivity(intent);
			}
		});
		btnstu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Register_start.this,Regist_stu.class);
				startActivity(intent);
				
			}
		});
		
		
	}

}
