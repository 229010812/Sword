package com.example.sword;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Index_student extends Activity {
	private AutoCompleteTextView acTextView;
	private String[] res={"active","act","auto","absolute","android","shanghai"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index_student);
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
