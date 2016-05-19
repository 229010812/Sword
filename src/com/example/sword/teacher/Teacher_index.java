package com.example.sword.teacher;

/*
 * Copyright 2013 Csaba Szugyiczki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sword.R;
import com.example.sword.R.id;
import com.example.sword.R.layout;
import com.example.sword.R.string;
import com.example.sword.view.CircleImageView;
import com.example.sword.view.CircleLayout;
import com.example.sword.view.CircleLayout.OnItemClickListener;
import com.example.sword.view.CircleLayout.OnItemSelectedListener;

public class Teacher_index extends Activity implements OnItemSelectedListener, OnItemClickListener{
	TextView selectedTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_index);
		
		CircleLayout circleMenu = (CircleLayout)findViewById(R.id.main_circle_layout);
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);

		selectedTextView = (TextView)findViewById(R.id.main_selected_textView);
		selectedTextView.setText(((CircleImageView)circleMenu.getSelectedItem()).getName());
	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {		
		selectedTextView.setText(name);
		
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		if(name.equals("单词录入")){
			Intent intent=new Intent(this,Teacher_index_word_insert.class);
			startActivity(intent);
		}
		if(name.equals("单词查看")){
			Intent intent=new Intent(this,Teacher_index_word_see.class);
			startActivity(intent);
		}
		if(name.equals("例句录入")){
			Intent intent=new Intent(this,Teacher_index_sentence_insert.class);
			startActivity(intent);
		}
		if(name.equals("例句查看")){
			Intent intent=new Intent(this,Teacher_index_sentence_see.class);
			startActivity(intent);
		}
		Toast.makeText(getApplicationContext(), getResources().getString(R.string.start_app) + " " + name, Toast.LENGTH_SHORT).show();
	}

}
