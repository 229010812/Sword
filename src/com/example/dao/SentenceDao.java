package com.example.dao;

import java.util.List;

import com.example.entity.Sentence;

public interface SentenceDao {
	public int insertSentence(Sentence u);
	public int deletetSentence(int serid);
	public int updateSentence(int serid);
	public Sentence findSentenceByID(int serid);
	public List<Sentence> listSentence();
	public List<Sentence> listSentence(int serid);


}
