package com.example.sword.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.dao.impl.SentenceDaoImpl;
import com.example.dao.impl.WordDaolmpl;
import com.example.entity.Sentence;
import com.example.entity.Teacher;
import com.example.entity.Word;
import com.example.sword.R;
import com.example.sword.R.id;
import com.example.sword.R.layout;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Teacher_index_word_insert extends Activity {
	private EditText insertword, insertdetails, insertsentence, fanyi;
	private Spinner insertunit, insertsemester;
	private Button Scancle, inputword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_index_word_insert);
		insertword = (EditText) findViewById(R.id.insertword);
		insertdetails = (EditText) findViewById(R.id.insertdetails);
		insertsentence = (EditText) findViewById(R.id.insertsentence);
		fanyi = (EditText) findViewById(R.id.fanyi);
		insertsemester = (Spinner) findViewById(R.id.insertsemester);
		String[] sch = { "三年级上", "三年级下", "四年级上", "四年级下", "五年级上", "五年级下",
				"六年级上", "六年级下" };
		ArrayAdapter aa = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, sch);
		insertsemester.setAdapter(aa);
		insertunit = (Spinner) findViewById(R.id.insertunit);
		String[] un = { "1", "2", "3", "4", "5", "6", "7", "8" };
		ArrayAdapter bb = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, un);
		insertunit.setAdapter(bb);
		Scancle = (Button) findViewById(R.id.Scancle);
		inputword = (Button) findViewById(R.id.inputword);

		inputword.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Teacher t=new Teacher();
				WordDaolmpl dao = new WordDaolmpl(getApplication());
				Word w = new Word();
				w.setWord(insertword.getText().toString());
				w.setAnalyze(insertdetails.getText().toString());
				w.setSemester(insertsemester.getSelectedItem().toString());
				w.setUnit(insertunit.getSelectedItem().toString());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsshs");
				w.setInputtime(sdf.format(new Date()));
				w.setTid(t.getId());
				int i = dao.insertWord(w);

				SentenceDaoImpl dao1 = new SentenceDaoImpl(getApplication());
				Sentence u = new Sentence();
				u.setSentence(insertsentence.getText().toString());
				u.setTranslate(fanyi.getText().toString());
				u.setSemester(insertsemester.getSelectedItem().toString());
				u.setUnit(insertunit.getSelectedItem().toString());
				u.setInputtime(sdf.format(new Date()));
				u.setTid(t.getId());
				u.setNote(t.getName());

				int j = dao1.insertSentence(u); 

				if ((i != 0)|| (j != 0))
					Toast.makeText(Teacher_index_word_insert.this, "成功", 8000).show();
				else
					Toast.makeText(Teacher_index_word_insert.this, "失败 ", 8000)
							.show();
			}
		});
		Scancle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Teacher_index_word_insert.this,Teacher_content.class);
				startActivity(intent);

			}
		});

	}

}
