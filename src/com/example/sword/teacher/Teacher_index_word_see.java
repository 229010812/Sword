package com.example.sword.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dao.impl.WordDaolmpl;
import com.example.entity.Word;
import com.example.sword.R;
import com.example.util.DBUtil;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class Teacher_index_word_see extends Activity {
	DBUtil util;
	 WordDaolmpl worddaoimpl;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_index_teacher_word_see);
		worddaoimpl=new WordDaolmpl(getApplication());
		setContentView(R.layout.teacher_index_word_see);
		listView=(ListView) findViewById(R.id.lv);
		Cursor c=worddaoimpl.queryWordBy();
		String[] from = {"_id","word", "analyze","semester","unit","note"};
		int[] to = {R.id.textid,R.id.textword, R.id.textdetail,R.id.textsemester,R.id.textunit,R.id.textnote};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),
				R.layout.teacher_index_word_see_listitem, c, from, to);
		
		listView.setAdapter(adapter);
		
	}
	
	

}
