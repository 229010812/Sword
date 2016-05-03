package com.example.dao;

import java.util.List;

import android.database.Cursor;

import com.example.entity.Student;
import com.example.entity.Teacher;

public interface UserDao {
	public int insertStudent(Student s);
	public Cursor queryStudentBy(Student s);
	
//	public int deletetStudent(int serid);
//	public int updateStudent(int serid);
//	public Student findStudentByID(int serid);
//	public List<Student> listUser();
//	public List<Student> listUser(int serid);
//	
	public int insertTeacher(Teacher t);
	public Cursor queryTeacherBy(Teacher t);
//	public int deletetTeacher(int serid);
//	public int updateTeacher(int serid);
//	public Teacher findTeacherByID(int serid);
//	public List<Teacher> listTeacher();
//	public List<Teacher> listTeacher(int serid);


}
