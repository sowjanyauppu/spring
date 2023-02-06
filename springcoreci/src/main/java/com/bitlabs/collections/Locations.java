package com.bitlabs.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Locations {
	private String country;
	private List<String> state;
	private Set<String> city;
	private Map<String,String> places;
	public Locations(String country, List<String> state, Set<String> city, Map<String,String> places) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.places=places;
	}
	public void display()
	{
		System.out.println(country);
		System.out.println();
		System.out.println("Iterating over states");
		Iterator<String> itr=state.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("Iterating over cities");
		Iterator<String> itr1=city.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
		System.out.println();
		System.out.println("Iterating over places using map");
		Set<Entry<String, String>> sets=places.entrySet();  
	    Iterator<Entry<String, String>> itr2=sets.iterator(); 
	    while(itr2.hasNext()){  
	        Entry<String,String> entry=itr2.next();  
	        System.out.println("state:"+entry.getKey()+" city:"+entry.getValue());  
		
	}
	
	

}
}
