package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingRow {
	
	
	private int numReserved;
	
	public int getNumReserved() {
		return numReserved;
	}

	public void setNumReserved(int numReserved) {
		this.numReserved = numReserved;
	}

	private List<Integer> regEmptySpots;
	
	private List<Integer> resEmptySpots;
	
	private int rowId;
	
	
  

	public List<Integer> getRegEmptySpots() {
		return regEmptySpots;
	}

	public void setRegEmptySpots(List<Integer> regEmptySpots) {
		this.regEmptySpots = regEmptySpots;
	}

	public List<Integer> getResEmptySpots() {
		return resEmptySpots;
	}

	public void setResEmptySpots(List<Integer> resEmptySpots) {
		this.resEmptySpots = resEmptySpots;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public boolean isParkingAvailable(Vehicle v){
		
		if(v.isReservedParking()){
			return isValid(getResEmptySpots(),v.getSpotsReq());
		}else{
			return isValid(getRegEmptySpots(), v.getSpotsReq());
		}
	
    }
	
    public Vehicle park(Vehicle v){
    	
    	List<Integer> aSpots;
    	if(v.isReservedParking()){
    		aSpots = getSpots( getResEmptySpots(), v.getSpotsReq());
    		updateSpots(getResEmptySpots(), aSpots);
    		
    	}else{
    		aSpots = getSpots( getRegEmptySpots(), v.getSpotsReq());
    		updateSpots(getRegEmptySpots(), aSpots);
    		
    	}
     
     String parkingIndex = this.getRowId()+ "-" + aSpots.get(0);
     v.setSpotIndex(parkingIndex);
     return v;
    	
    }
    
    public void leave(Vehicle v){
    	
    	int spotId = Integer.parseInt(v.getSpotIndex().split("-")[1]);
    
    	
    	  if(v.isReservedParking()){
    		
    		 getResEmptySpots().add(spotId);
    	  }else{
    		  getRegEmptySpots().add(spotId);
    	  }
    	
    }
    
    
    private boolean isValid(List<Integer> spots,int numAdjSpots){
    	
    	List<Integer> aSpots = getSpots( spots, numAdjSpots);
    	return aSpots.size() == numAdjSpots;
    		
    }
	
    
  private List<Integer> getSpots(List<Integer> spots,int numAdjSpots){
	  
	  List<Integer> aSpots = new ArrayList<Integer>();
    	
    	int numAdj = 0;
    	int prev = -1;
    	boolean valid = false;
    	
    	for(int i:spots){
    		if(numAdj<numAdjSpots){
    		if(prev == -1){
    			prev = i;
    			numAdj=1;
    			aSpots.add(i);
    		}else{
    		
    				if(i==prev+1){
        				numAdj++;
        				aSpots.add(i);
        				
        			}else{
        				numAdj=1;
        				aSpots.clear();
        				aSpots.add(i);
        			}
    				prev = i;
    			}
    			
    		}else{
    			valid = true;
    			break;
    		}
    	}
    	return aSpots;
    }
	
  	public void updateSpots(List<Integer> spots,List<Integer> spotsToUpdate){
  		
  		for(int i:spotsToUpdate){
  			spots.remove(new Integer(i));
  		}
  		
  	}

}
