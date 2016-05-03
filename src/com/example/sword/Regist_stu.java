package com.example.sword;

import com.exampie.dao.impl.UserDaoImpl;
import com.example.entity.Student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Regist_stu extends Activity {
	private EditText Susername, Spassword, Srealname, Sage;
	private RadioButton Smale, Sfemale;
	private Spinner school, ygrade, grade;
	private Button Scancle, Sregister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_student);
		Susername = (EditText) findViewById(R.id.Susername);
		Spassword = (EditText) findViewById(R.id.Spassword);
		Srealname = (EditText) findViewById(R.id.Srealname);
		Sage = (EditText) findViewById(R.id.Sage);
		Smale = (RadioButton) findViewById(R.id.Smale);
		Sfemale = (RadioButton) findViewById(R.id.Sfemale);
		school = (Spinner) findViewById(R.id.school);
		String[] sch = { "�չ�ԺСѧ", "��ְ��Сѧ", "����Сѧ" };
		ArrayAdapter aa = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, sch);
		school.setAdapter(aa);
		
		ygrade = (Spinner) findViewById(R.id.ygrade);
		String[] yg = { "һ�꼶", "���꼶", "���꼶", "���꼶", "���꼶", "���꼶" };
		ArrayAdapter bb = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, yg);
		ygrade.setAdapter(bb);
		
		
		grade = (Spinner) findViewById(R.id.grade);
		String[] gr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		ArrayAdapter cc = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, gr);
		grade.setAdapter(cc);
		
		Scancle = (Button) findViewById(R.id.Scancle);
		Sregister = (Button) findViewById(R.id.Sregister);

		Sregister.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserDaoImpl dao = new UserDaoImpl(getApplication());
				Student s = new Student();
				s.setAccount(Susername.getText().toString());
				s.setPassword(Spassword.getText().toString());
				s.setName(Srealname.getText().toString());
				s.setAge(Sage.getText().toString());
				if (Smale.isChecked()) {
					s.setGender("��");

				} else {
					s.setGender("Ů");
				}
				s.setSchool(school.getSelectedItem().toString());
				s.setYeargrade(ygrade.getSelectedItem().toString());
				s.setGrade(grade.getSelectedItem().toString());

				int i = dao.insertStudent(s);

				if (i != 0)
					Toast.makeText(Regist_stu.this, "�û���Ϣע��ɹ� ", 8000).show();
				else
					Toast.makeText(Regist_stu.this, "�û���Ϣע��ʧ�� ", 8000).show();

				Intent intent = new Intent(Regist_stu.this, Login.class);

				startActivity(intent);

			}
		});
		Scancle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

}
