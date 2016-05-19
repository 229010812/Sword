package com.example.sword.admin;

import com.example.sword.About;
import com.example.sword.R;
import com.example.sword.Register_start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Admin_content extends Activity implements OnClickListener {
	
	private Button school_insert,teacher_check,admin_user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_content);
		school_insert=(Button) findViewById(R.id.school_insert);
		teacher_check=(Button) findViewById(R.id.teacher_check);
		admin_user=(Button) findViewById(R.id.Administration_user);
		school_insert.setOnClickListener(this);
		teacher_check.setOnClickListener(this);
		admin_user.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.school_insert:
		
			break;
		case R.id.teacher_check:
		
			break;
		case R.id.Administration_user:
		
			break;

		default:
			break;
		}
		
	}

}
