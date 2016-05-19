package com.example.dao;

import java.util.List;

import android.database.Cursor;

import com.example.entity.Sentence;

public interface SentenceDao {
	public int insertSentence(Sentence u);
	public Cursor querySentenceBy();
//	public int deletetSentence(int serid);
//	public int updateSentence(int serid);
//	public Sentence findSentenceByID(int serid);
//	public List<Sentence> listSentence();
//	public List<Sentence> listSentence(int serid);


}
