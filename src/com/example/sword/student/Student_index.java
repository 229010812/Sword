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
		 * 第一步：初始化控件
		 * 第二部：需要一个适配器
		 * 第三部：初始化数据源---这数据去
		 * 
		 */
		acTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, res);
		acTextView.setAdapter(adapter);
		
		
	}
 
}
