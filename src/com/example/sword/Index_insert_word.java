package com.example.sword;

import android.app.Activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class Index_insert_word extends Activity {
	private EditText insertword,insertdetails,insertsentence,fanyi;
	private Spinner insertunit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_word);
		insertword=(EditText) findViewById(R.id.insertword);
		insertdetails=(EditText) findViewById(R.id.insertdetails);
		insertsentence=(EditText) findViewById(R.id.insertsentence);
		fanyi=(EditText) findViewById(R.id.fanyi);
		insertunit=(Spinner) findViewById(R.id.insertunit);
		
	}

}
