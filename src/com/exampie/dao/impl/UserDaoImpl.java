package com.exampie.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dao.UserDao;
import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.util.DBUtil;

public class UserDaoImpl implements UserDao {
	DBUtil util;
	private SQLiteDatabase db;

	public UserDaoImpl(Context context) {
		util = new DBUtil(context);
	}

	@Override
	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		int i = 0;
		db = util.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("account", s.getAccount());
		cv.put("password", s.getPassword());
		cv.put("name", s.getName());
		cv.put("gender", s.getGender());
		cv.put("age", s.getAge());
		cv.put("school", s.getSchool());
		cv.put("yeargrade", s.getYeargrade());
		cv.put("grade", s.getGrade());

		i = (int) db.insert("stutable", null, cv);
		db.close();
		return i;

	}

	@Override
	public Cursor queryStudentBy(Student s) {
		// TODO Auto-generated method stub
		db = util.getWritableDatabase();
		Cursor c=db.query("stutable", null, "account=? and password=?", new String[]{s.getAccount(),s.getPassword()}, null, null,null);

		return c;
	}

	@Override
	public int insertTeacher(Teacher t) {
		// TODO Auto-generated method stub
		int i = 0;
		db = util.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("account", t.getAccount());
		cv.put("password", t.getPassword());
		cv.put("name", t.getName());
		cv.put("gender", t.getGender());
		cv.put("age", t.getAge());
		cv.put("school", t.getSchool());
		i = (int) db.insert("teatable", null, cv);
		db.close();
		return i;
	}

	@Override
	public Cursor queryTeacherBy(Teacher t) {
		// TODO Auto-generated method stub
		db = util.getWritableDatabase();
		Cursor c=db.query("teatable", null, "account=? and password=?", new String[]{t.getAccount(),t.getPassword()}, null, null,null);

		return c;
	}



}
