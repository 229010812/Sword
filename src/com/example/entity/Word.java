package com.example.entity;

public class Word {
	// ���
	private int wid;
	// ����
	private String word;
	// ����
	private String analyze;
	// ����pronunciation
	private String pronunciation;
	// ��Ԫunit
	private String unit;
	// ѧ��semester
	private String semester;
	// ¼��ʱ��inputtime
	private String inputtime;
	// ¼���ʦID tid
	private String tid;
	// ��עnote
	private String note;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAnalyze() {
		return analyze;
	}

	public void setAnalyze(String analyze) {
		this.analyze = analyze;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
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

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
