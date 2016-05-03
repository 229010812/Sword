package com.example.sword;



import com.exampie.dao.impl.UserDaoImpl;
import com.example.dao.UserDao;
import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.sword.R.id;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Regist_tea extends Activity {
	private EditText username,password,realname,age;
	private RadioButton male,female;
	private Spinner school;
	private Button register,cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_teacher);
		username=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
		realname=(EditText) findViewById(R.id.realname);
		age=(EditText) findViewById(R.id.age);
		male=(RadioButton) findViewById(R.id.male);
		female=(RadioButton) findViewById(R.id.female);
		school=(Spinner) findViewById(R.id.school);
		String[] sch = { "苏工院小学", "苏职大小学", "文正小学" };
		ArrayAdapter aa = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, sch);
		school.setAdapter(aa);
		register=(Button) findViewById(R.id.register);
		cancel=(Button) findViewById(R.id.cancle);
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserDao dao = new UserDaoImpl(getApplication());
				Teacher t = new Teacher();
				t.setAccount(username.getText().toString());
				t.setPassword(password.getText().toString());
				t.setName(realname.getText().toString());
				t.setAge(age.getText().toString());
				if (male.isChecked()) {
					t.setGender("男");

				} else {
					t.setGender("女");
				}
				t.setSchool(school.getSelectedItem().toString());
				
				int i = dao.insertTeacher(t);

				if (i != 0)
					Toast.makeText(Regist_tea.this, "用户信息注册成功 ", 8000).show();
				else
					Toast.makeText(Regist_tea.this, "用户信息注册失败 ", 8000).show();

				Intent intent = new Intent(Regist_tea.this, Login.class);

				startActivity(intent);

			}
		});
		
		
	}
	

}
