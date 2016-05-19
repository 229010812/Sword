package com.example.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dao.SentenceDao;
import com.example.entity.Sentence;
import com.example.util.DBUtil;

public class SentenceDaoImpl implements SentenceDao {
	DBUtil util;
	private SQLiteDatabase db;

	public SentenceDaoImpl(Context context) {
		util = new DBUtil(context);
	}

	@Override
	public int insertSentence(Sentence u) {
		// TODO Auto-generated method stub
		int j = 0;
		db = util.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("sentence", u.getSentence());
		cv.put("translate", u.getTranslate());
		cv.put("inputtime", u.getInputtime());
		cv.put("semester", u.getSemester());
		cv.put("unit", u.getUnit());
		cv.put("tid", u.getTid());

		j = (int) db.insert("sentable", null, cv);
		db.close();
		return j;
	}

	@Override
	public Cursor querySentenceBy() {
		// TODO Auto-generated method stub
		db = util.getWritableDatabase();
		Cursor c=db.query("sentable", null, null, null, null, null, null);
		return c;
	}

}
