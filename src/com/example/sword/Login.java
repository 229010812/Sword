package com.example.sword;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exampie.dao.impl.UserDaoImpl;
import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.sword.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	UserDBHelper dbhelper;
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	int count = 0;
	private EditText userEditText, pwdEditText;
	private RadioButton tearadio;
	private TextView register, about;
	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		dbhelper = new UserDBHelper(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userEditText = (EditText) findViewById(R.id.userEditText);
		pwdEditText = (EditText) findViewById(R.id.pwdEditText);
		tearadio = (RadioButton) findViewById(R.id.tearadios);
		register = (TextView) findViewById(R.id.register);
		about = (TextView) findViewById(R.id.about);
		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);
		about.setOnClickListener(this);
		register.setOnClickListener(this);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

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
			// ��ת��Aboutҳ��
			Intent intent = new Intent();
			intent.setClass(this, About.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	// ��ת��indexҳ��
	private void intLogin() {
		// TODO Auto-generated method stub
		String user = userEditText.getText().toString();
		String pwd = pwdEditText.getText().toString();
		// ���� dbhelper.queryUserByname()����ʵ���û���¼����
		UserDaoImpl dao = new UserDaoImpl(getApplication());

		if (tearadio.isChecked()) {
			Teacher t = new Teacher();
			t.setAccount(user);
			t.setPassword(pwd);
			Cursor c = dao.queryTeacherBy(t);
			if (c.getCount() > 0) {
				Toast.makeText(getApplication(), "��ʦ��¼�ɹ�",
						Toast.LENGTH_LONG).show();
				// saveLoinginfor();
				Intent intent = new Intent();
				intent.setClass(Login.this, ContentActivity.class);
				startActivity(intent);
			} else
				Toast.makeText(getApplication(), "��¼ʧ�ܣ��û��������벻��ȷ��",
						Toast.LENGTH_LONG).show();

		} else {
			Student s = new Student();
			s.setAccount(user);
			s.setPassword(pwd);
			Cursor c = dao.queryStudentBy(s);

			if (c.getCount() > 0) {
				Toast.makeText(getApplication(), "��ϲ��¼�ɹ�", Toast.LENGTH_LONG)
						.show();
				// saveLoinginfor();
				Intent intent = new Intent();
				intent.setClass(Login.this, sContentActivity.class);
				startActivity(intent);
			} else
				Toast.makeText(getApplication(), "��¼ʧ�ܣ��û��������벻��ȷ��",
						Toast.LENGTH_LONG).show();

		}
	}

	// ��ת��registerҳ��
	private void intRegister() {
		// TODO Auto-generated method stub
		Intent intent1 = new Intent();
		intent1.setClass(this, Register.class);
		startActivity(intent1);
	}

	void saveLoinginfor() {
		// д���û���¼��ʱ�������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��" + "hh:mm:ss");
		editor.putString("time", sdf.format(new Date()));
		editor.putString("username", userEditText.getText().toString());
		count = preferences.getInt("count", 0);
		editor.putInt("count", ++count);
		editor.commit();

	}

}
