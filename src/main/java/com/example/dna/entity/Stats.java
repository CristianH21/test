package com.example.dna.entity;


public class Stats {

	private int count_mutation;
	private int count_no_mutation;
	private double ratio;
	
	public Stats() {
		super();
	}
	
	public Stats(int count_mutation, int count_no_mutation, double ratio) {
		super();
		this.count_mutation = count_mutation;
		this.count_no_mutation = count_no_mutation;
		this.ratio = ratio;
	}

	public int getCount_mutation() {
		return count_mutation;
	}
	public void setCount_mutation(int count_mutation) {
		this.count_mutation = count_mutation;
	}
	public int getCount_no_mutation() {
		return count_no_mutation;
	}
	public void setCount_no_mutation(int count_no_mutation) {
		this.count_no_mutation = count_no_mutation;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	
}
