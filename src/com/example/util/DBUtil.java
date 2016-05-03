package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	// ѧ����(stutable)�����id;�˺�account;����password;�û�����name;�Ա�gender;����age;ѧУschool;�꼶yeargrade;
	private static final String CREATE_SQLstu = "create table stutable"
			+ "(_id integer primary key autoincrement," + "account text,"
			+ "password text," + "name text," + "gender text," + "age text,"
			+ "school text," + "yeargrade text," + "grade text)";
	// ��ʦ��(teatable):���id;�˺�account;����password;�û�����name;�Ա�gender;����age;ѧУschool;
	private static final String CREATE_SQLtea = "create table teatable"
			+ "(_id integer primary key autoincrement," + "account text,"
			+ "password text," + "name text," + "gender text," + "age text,"
			+ "school text)";

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

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		this.db = db;
		db.execSQL(CREATE_SQLstu);
		db.execSQL(CREATE_SQLtea);

	}

	public void close() {
		if (db != null)
			db.close();
	}

}
