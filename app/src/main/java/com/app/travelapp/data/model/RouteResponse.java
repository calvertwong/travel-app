package com.app.travelapp.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RouteResponse{

	@SerializedName("route")
	private List<RouteItem> route;

	public void setRoute(List<RouteItem> route){
		this.route = route;
	}

	public List<RouteItem> getRoute(){
		return route;
	}

	@Override
 	public String toString(){
		return 
			"RouteResponse{" + 
			"route = '" + route + '\'' + 
			"}";
		}
}