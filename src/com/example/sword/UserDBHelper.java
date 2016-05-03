package com.example.sword;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	private static final String CREATE_SQLuser = "create table usertable"
			+ "(_id integer primary key autoincrement," + "username text,"
			+ "pwd text," + "name text," + "ssex text," + "class text,"
			+ "favorite text," + "position text)";

	public UserDBHelper(Context context) {
		super(context, "sword.db", null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		this.db = db;
		db.execSQL(CREATE_SQLuser);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		this.db = db;
		db.execSQL(CREATE_SQLuser);

	}

	public int insertUser(String username, String pwd) {
		int i = 0;
		db = getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("username", username);
		cv.put("pwd", pwd);

		i = (int) db.insert("usertable", null, cv);
		db.close();
		return i;
	}

	public Cursor queryUserByname(String username, String pwd) {
		db = getWritableDatabase();
		Cursor c=db.query("usertable", null, "username=? and pwd=?", new String[]{username,pwd}, null, null,null);
		return c;
	}

	public void close() {
		if (db != null)
			db.close();
	}

}
