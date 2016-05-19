package com.example.dao;

import java.util.List;

import android.database.Cursor;

import com.example.entity.Student;
import com.example.entity.Word;

public interface WordDao {
	public int insertWord(Word w);
	public Cursor queryWordBy();
//	public int deletetWord(int serid);
//	public int updateWord(int serid);
//	public Word findWordByID(int serid);
//	public List<Word> listWord();
//	public List<Word> listWord(int serid);
//	public List<Word> listWordByUnit(String unit);
//	public List<Word> listWordByTerm(String term);
//	public List<Word> listWordByUid(int userserid);


}
