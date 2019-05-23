package com.app.travelapp.data.local;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SeatsResponse{


	@SerializedName("seatinformation")
	private List<SeatInformationItem> seatinformation;

	public SeatsResponse(List<SeatInformationItem> seatinformation) {
		this.seatinformation = seatinformation;
	}

	public void setSeatinformation(List<SeatInformationItem> seatinformation){
		this.seatinformation = seatinformation;
	}

	public List<SeatInformationItem> getSeatinformation(){
		return seatinformation;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"seatinformation = '" + seatinformation + '\'' + 
			"}";
		}
}