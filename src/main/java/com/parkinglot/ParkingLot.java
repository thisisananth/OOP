package com.parkinglot;

import java.util.List;

public class ParkingLot {
	
	private List<ParkingRow> rows;
	
	public List<ParkingRow> getRows() {
		return rows;
	}

	public void setRows(List<ParkingRow> rows) {
		this.rows = rows;
	}

	public Vehicle park(Vehicle v) throws Exception{
		
		for(ParkingRow row:rows){
			if(row.isParkingAvailable(v)){
				row.park(v);
				return v;
			}
			
		}
		
		throw new Exception();
		
	}
	
	public boolean isParkingAvailable(Vehicle v){
		
		boolean isParkingAvailable = false;
		
		for(ParkingRow row:rows){
			if(row.isParkingAvailable(v)){
				return true;
			}
			
		}
		
		return isParkingAvailable;
		
	}
	
	
	public void leave(Vehicle v){
		
		String parkingId = v.getSpotIndex();
		
		String[] parkDetails = parkingId.split("-");
		
		int rowId = Integer.parseInt(parkDetails[0]) - 1;
		int spotId = Integer.parseInt(parkDetails[1]) - 1;
		
		ParkingRow row = rows.get(rowId);
	    
		row.leave(v);
		
		
		
	}
	

}
