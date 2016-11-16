package com.parkinglot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
	
    ParkingLot lot;
	
	@Before
	public void setUp(){
		lot = new ParkingLot();
		List<ParkingRow> rows = new ArrayList<ParkingRow>();
		lot.setRows(rows);
	
		for(int i=0;i<2;i++){
			
			ParkingRow row = new ParkingRow();
			
			List<Integer> regEmptyspots = new ArrayList<Integer>();
			row.setRegEmptySpots(regEmptyspots);
			List<Integer> resEmptyspots = new ArrayList<Integer>();
			row.setResEmptySpots(resEmptyspots);
			
			
			row.setRowId(i+1);
			row.setNumReserved(2);
			for(int j=0;j<4;j++){
				
				if(j<row.getNumReserved()){
					resEmptyspots.add(j+1);
				}else{
					regEmptyspots.add(j+1);
				}
				
			}
			
			rows.add(row);
			
		}
		
		
	}
	


	@Test
	public void testisParkingAvailable() {
		
		//assertFalse(lot.isParkingAvailable(new Vehicle(1,false)));
		assertTrue(lot.isParkingAvailable(new Vehicle(1, false)));
		
		assertTrue(lot.isParkingAvailable(new Vehicle(2, true)));
		
	}
	
	@Test
	public void testPark() throws Exception{
		Vehicle v;
	v=	lot.park(new Vehicle(1,false));
	v=lot.park(new Vehicle(2,false));
	v=	lot.park(new Vehicle(1,true));
	v=	lot.park(new Vehicle(2, true));
		assertFalse(lot.isParkingAvailable(new Vehicle(2,true)));
		assertTrue(lot.isParkingAvailable(new Vehicle(1,false)));
		v=	lot.park(new Vehicle(1, true));
		v=	lot.park(new Vehicle(1, false));
		assertFalse(lot.isParkingAvailable(new Vehicle(1,false)));
	}
	
	@Test
	public void testLeave() throws Exception{
		Vehicle v;
		v=lot.park(new Vehicle(1,false));
		v=lot.park(new Vehicle(2,false));
		v=lot.park(new Vehicle(1,true));
		v=lot.park(new Vehicle(2, true));
		v=lot.park(new Vehicle(1, true));
		v=lot.park(new Vehicle(1, false));
		assertFalse(lot.isParkingAvailable(new Vehicle(1,false)));
		lot.leave(v);
		assertTrue(lot.isParkingAvailable(new Vehicle(1,false)));
	}
	
	
	

}
