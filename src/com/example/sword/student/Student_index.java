package com.example.sword.student;

import com.example.sword.R;
import com.example.sword.R.id;
import com.example.sword.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Student_index extends Activity {
	private AutoCompleteTextView acTextView;
	private String[] res={"active","act","auto","absolute","android","shanghai"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_index);
		/*
		 * ��һ������ʼ���ؼ�
		 * �ڶ�������Ҫһ��������
		 * ����������ʼ������Դ---������ȥ
		 * 
		 */
		acTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, res);
		acTextView.setAdapter(adapter);
		
		
	}
 
}
