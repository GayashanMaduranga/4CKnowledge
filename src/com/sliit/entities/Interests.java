package com.sliit.entities;

import java.util.ArrayList;

public class Interests {

	public static int ARTIFITIAL_INTELIGENCE = 1;
	public static int SI_FI = 2;
	public static int IMAGE_PROCESSING = 3;
	public static int POLITICS = 4;
	public static int MIDDLEWARE = 5;
	public static int RELIGION = 6;
	
	private int mid;
	private ArrayList<Integer> interestId;
	public Interests() {
		
		interestId = new ArrayList<>();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public ArrayList<Integer> getInterestId() {
		return interestId;
	}
	public void setInterestId(ArrayList<Integer> interestId) {
		this.interestId = interestId;
	}
	
	
	
	
}
