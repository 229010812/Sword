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
		// 单词表（wordtable）编号wid;单词 word;解析analyze;
		// 读音pronunciation单元unit学期semester录入时间inputtime录入教师ID tid备注note
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
