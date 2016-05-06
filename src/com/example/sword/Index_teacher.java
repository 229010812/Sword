package com.example.sword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Index_teacher extends Activity implements OnClickListener {
	private Button insertword, seeword, insersentence, seesentence,
			information, system;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index_teacher);
		insertword = (Button) findViewById(R.id.insertword);
		seeword = (Button) findViewById(R.id.seeword);
		insersentence = (Button) findViewById(R.id.insersentence);
		seesentence = (Button) findViewById(R.id.seesentence);
		information = (Button) findViewById(R.id.information);
		system = (Button) findViewById(R.id.system);

		insertword.setOnClickListener(this);
		seeword.setOnClickListener(this);
		insersentence.setOnClickListener(this);
		seesentence.setOnClickListener(this);
		information.setOnClickListener(this);
		system.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.insertword:
			Intent intent=new Intent();
			intent.setClass(Index_teacher.this, Index_insert_word.class);
			startActivity(intent);

			break;
		case R.id.seeword:

			break;
		case R.id.insersentence:

			break;
		case R.id.seesentence:

			break;
		case R.id.information:

			break;
		case R.id.system:

			break;

		default:
			break;
		}
	}

}
