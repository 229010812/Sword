package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	// 学生表(stutable)：编号id;账号account;密码password;用户名称name;性别gender;年龄age;学校school;年级yeargrade;
	private static final String CREATE_SQLstu = "create table stutable"
			+ "(_id integer primary key autoincrement," + "account text,"
			+ "password text," + "name text," + "gender text," + "age text,"
			+ "school text," + "yeargrade text," + "grade text)";
	// 教师表(teatable):编号id;账号account;密码password;用户名称name;性别gender;年龄age;学校school;审核状态check；
	private static final String CREATE_SQLtea = "create table teatable"
			+ "(_id integer primary key autoincrement," + "account text,"
			+ "password text," + "name text," + "gender text," + "age text,"
			+ "school text," + "tcheck text)";
	// 单词表（wordtable）编号id;单词
	// word;解析analyze;读音pronunciation单元unit学期semester录入时间inputtime录入教师ID
	// tid备注note
	private static final String CREATE_SQLword = "create table wordtable"
			+ "(_id integer primary key autoincrement," + "word text,"
			+ "analyze text," + "pronunciation text," + "semester text,"
			+ "unit text," + "inputtime text," + "tid text," + "note text)";
	// 例句表（sentable）编号id;单词编号
	// wid;例句sentence;翻译translate;单元unit学期semester录入时间inputtime录入教师ID tid备注note
	private static final String CREATE_SQLsen = "create table sentable"
			+ "(_id integer primary key autoincrement," + "wid text,"
			+ "sentence text," + "translate text," + "semester text,"
			+ "unit text," + "inputtime text," + "tid text," + "note text)";

	public DBUtil(Context context) {
		super(context, "sword.db", null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		this.db = db;
		db.execSQL(CREATE_SQLstu);
		db.execSQL(CREATE_SQLtea);
		db.execSQL(CREATE_SQLword);
		db.execSQL(CREATE_SQLsen);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		this.db = db;
		db.execSQL(CREATE_SQLstu);
		db.execSQL(CREATE_SQLtea);
		db.execSQL(CREATE_SQLword);
		db.execSQL(CREATE_SQLsen);

	}

	public void close() {
		if (db != null)
			db.close();
	}

}
