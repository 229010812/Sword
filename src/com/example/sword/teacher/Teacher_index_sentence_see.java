package com.example.sword.teacher;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.dao.impl.SentenceDaoImpl;
import com.example.dao.impl.WordDaolmpl;
import com.example.sword.R;
import com.example.util.DBUtil;

public class Teacher_index_sentence_see extends Activity{
	DBUtil util;
	 SentenceDaoImpl sentencedaoimpl;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_index_teacher_word_see);
		sentencedaoimpl=new SentenceDaoImpl(getApplication());
		setContentView(R.layout.teacher_index_sentence_see);
		listView=(ListView) findViewById(R.id.senlv);
		Cursor c=sentencedaoimpl.querySentenceBy();
		String[] from = {"_id","sentence", "translate","semester","unit","note"};
		int[] to = {R.id.textid,R.id.sentextword, R.id.sentextdetail,R.id.sentextsemester,R.id.sentextunit,R.id.sentextnote};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),
				R.layout.teacher_index_sentence_see_listitem, c, from, to);
		
		listView.setAdapter(adapter);
		
	}

}
