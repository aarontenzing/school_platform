package com.app.platform.forms;
import java.util.ArrayList;
import java.util.List;

import com.app.platform.model.Score;

public class MyForm {
	
	private List<Score> scores;
	
	public MyForm(List<Score> scores) {
		this.scores = scores;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

}