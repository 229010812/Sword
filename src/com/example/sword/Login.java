package com.example.sword;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.dao.impl.UserDaoImpl;
import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.sword.*;
import com.example.sword.student.Student_content;
import com.example.sword.teacher.Teacher_content;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	int count = 0;
	private EditText userEditText, pwdEditText;
	private RadioButton tearadio, sturadio, adminradio;
	private TextView register, about;
	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//去掉标题栏
		setContentView(R.layout.login);
		userEditText = (EditText) findViewById(R.id.userEditText);
		pwdEditText = (EditText) findViewById(R.id.pwdEditText);
		tearadio = (RadioButton) findViewById(R.id.tearadios);
		sturadio = (RadioButton) findViewById(R.id.sturadio);
		adminradio = (RadioButton) findViewById(R.id.adminradio);
		register = (TextView) findViewById(R.id.register);
		about = (TextView) findViewById(R.id.about);
		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);
		about.setOnClickListener(this);
		register.setOnClickListener(this);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login, menu);
//		return true;
//	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.login:
			intLogin();
			break;
		case R.id.register:
			Intent intent1 = new Intent();
			intent1.setClass(this, Register_start.class);
			startActivity(intent1);
			break;
		case R.id.about:
			// 跳转到About页面
			Intent intent = new Intent();
			intent.setClass(this, About.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	// 跳转到index页面
	private void intLogin() {
		// TODO Auto-generated method stub
		String user = userEditText.getText().toString();
		String pwd = pwdEditText.getText().toString();
		// 调用 dbhelper.queryUserByname()方法实现用户登录功能
		UserDaoImpl dao = new UserDaoImpl(getApplication());

		if (tearadio.isChecked()) {
			Teacher t = new Teacher();
			t.setAccount(user);
			t.setPassword(pwd);
			Cursor c = dao.queryTeacherBy(t);
			if (c.getCount() > 0) {
				Toast.makeText(getApplication(), "教师登录成功", Toast.LENGTH_LONG)
						.show();
				 saveLoinginfor();
				Intent intent = new Intent();
				intent.setClass(Login.this, Teacher_content.class);
				startActivity(intent);
			} else
				Toast.makeText(getApplication(), "登录失败，用户名或密码不正确！",
						Toast.LENGTH_LONG).show();

		} else if (sturadio.isChecked()) {
			Student s = new Student();
			s.setAccount(user);
			s.setPassword(pwd);
			Cursor c = dao.queryStudentBy(s);

			if (c.getCount() > 0) {
				Toast.makeText(getApplication(), "恭喜登录成功", Toast.LENGTH_LONG)
						.show();
				// saveLoinginfor();
				Intent intent = new Intent();
				intent.setClass(Login.this, Student_content.class);
				startActivity(intent);
			} else
				Toast.makeText(getApplication(), "登录失败，用户名或密码不正确！",
						Toast.LENGTH_LONG).show();

		} else if (adminradio.isChecked()) {
			Student s = new Student();
			s.setAccount(user);
			s.setPassword(pwd);
			Cursor c = dao.queryStudentBy(s);

			if (user.equals("admin")&&pwd.equals("123")) {
				Toast.makeText(getApplication(), "恭喜登录成功", Toast.LENGTH_LONG)
						.show();
				// saveLoinginfor();
				Intent intent = new Intent();
				intent.setClass(Login.this, Student_content.class);
				startActivity(intent);
			} else
				Toast.makeText(getApplication(), "登录失败，用户名或密码不正确！",
						Toast.LENGTH_LONG).show();

		}
	}

	private void saveLoinginfor() {
		// TODO Auto-generated method stub
		Teacher t = new Teacher();
		
	}

}
