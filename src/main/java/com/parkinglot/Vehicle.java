package com.parkinglot;

public class Vehicle {
	
	private int spotsReq;
	
	private String spotIndex;
	
	private boolean isReservedParking;

	public int getSpotsReq() {
		return spotsReq;
	}

	public void setSpotsReq(int spotsReq) {
		this.spotsReq = spotsReq;
	}

	public String getSpotIndex() {
		return spotIndex;
	}

	public Vehicle(int spotsReq, boolean isReservedParking) {
		super();
		this.spotsReq = spotsReq;
		this.isReservedParking = isReservedParking;
	}

	public void setSpotIndex(String spotIndex) {
		this.spotIndex = spotIndex;
	}

	public boolean isReservedParking() {
		return isReservedParking;
	}

	public void setReservedParking(boolean isReservedParking) {
		this.isReservedParking = isReservedParking;
	}

}
