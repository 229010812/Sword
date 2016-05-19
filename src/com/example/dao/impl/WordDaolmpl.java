package com.example.dao.impl;

import java.util.List;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dao.WordDao;
import com.example.entity.Word;
import com.example.util.DBUtil;


public class WordDaolmpl implements WordDao {
	DBUtil util;
	private SQLiteDatabase db;

	public WordDaolmpl(Context context) {
		util = new DBUtil(context);
	}

	@Override
	public int insertWord(Word w) {
		// TODO Auto-generated method stub
		int i = 0;
		db = util.getWritableDatabase();
		ContentValues cv = new ContentValues();
		// ���ʱ�wordtable�����wid;���� word;����analyze;
		// ����pronunciation��Ԫunitѧ��semester¼��ʱ��inputtime¼���ʦID tid��עnote
		cv.put("word", w.getWord());
		cv.put("analyze", w.getAnalyze());
		cv.put("inputtime", w.getInputtime());
		cv.put("semester", w.getSemester());
		cv.put("unit", w.getUnit());
		cv.put("tid", w.getTid());
		cv.put("note", w.getNote());

		i = (int) db.insert("wordtable", null, cv);
		db.close();
		return i;
	}

	@Override
	public Cursor queryWordBy() {
		// TODO Auto-generated method stub
		db = util.getWritableDatabase();
		Cursor c=db.query("wordtable", null, null, null, null, null, null);
		return c;
	}


}
