package com.app.travelapp.data.model;

import com.google.gson.annotations.SerializedName;

public class CityItem{

	@SerializedName("cityname")
	private String cityname;

	@SerializedName("citylongtitude")
	private String citylongtitude;

	@SerializedName("citylatitude")
	private String citylatitude;

	public void setCityname(String cityname){
		this.cityname = cityname;
	}

	public String getCityname(){
		return cityname;
	}

	public void setCitylongtitude(String citylongtitude){
		this.citylongtitude = citylongtitude;
	}

	public String getCitylongtitude(){
		return citylongtitude;
	}

	public void setCitylatitude(String citylatitude){
		this.citylatitude = citylatitude;
	}

	public String getCitylatitude(){
		return citylatitude;
	}

	public CityItem(String cityname, String citylongtitude, String citylatitude) {
		this.cityname = cityname;
		this.citylongtitude = citylongtitude;
		this.citylatitude = citylatitude;
	}

	@Override
 	public String toString(){
		return 
			"CityItem{" + 
			"cityname = '" + cityname + '\'' + 
			",citylongtitude = '" + citylongtitude + '\'' + 
			",citylatitude = '" + citylatitude + '\'' + 
			"}";
		}
}