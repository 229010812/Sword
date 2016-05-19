package com.example.entity;

public class Sentence {
	// 编号

	private int id;
	// 单词编号
	private int wid;
	// 例句
	private String sentence;
	// 翻译
	private String translate;
	// 单元unit
	private String unit;
	// 学期semester
	private String semester;
	// 录入时间inputtime
	private String inputtime;
	// 录入教师ID tid
	private int tid;
	// 备注note
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getTranslate() {
		return translate;
	}
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getInputtime() {
		return inputtime;
	}
	public void setInputtime(String inputtime) {
		this.inputtime = inputtime;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int i) {
		this.tid = i;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
