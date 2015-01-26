package com.tejo.sf;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private String name;
	private List<Item> dependenciesList;
	private int dependentCount;
	private boolean installed = false;
	
	public Item(String itemName){
		this.name = itemName;
		dependenciesList = new ArrayList<Item>();
		dependentCount = 0;
	}
	public String getName(){
		return name;
	}
	
	//Increment When any other item is dependent on this item
	public void incrementDependentCount(){
		dependentCount++;
	}
	
	public boolean isInstalled(){
		return installed;
	}
	
	//Increment When any other item which is dependent on this removed
	public void decrementDependentCount(){
		dependentCount--;
	}
	
	//Add the dependency and increment the dependent counter on dependent item
	public void addDependency(Item item){
		dependenciesList.add(item);
		item.incrementDependentCount();
	}
	
	public void install(){
		//Install all dependencies first
		for (int i = 0; i < dependenciesList.size(); i++) {
			dependenciesList.get(i).install();
		}
		//Install the item only if it is not installed before
		if(!installed)
			System.out.println("\tInstalling "+this.name);
		
		//Mark the item as installed
		installed = true;
	}
	
	/*
	 * @parameter: echo - Echo if the item cannot be removed
	 */
	public boolean remove(boolean echo){
		//Check if there are any items dependent on this item. If so, do not remove
		if(dependentCount > 0){
			if(echo)
			System.out.println("\t"+this.name +" is still needed");
			return false;
		}		
		else{
			//Remove the item if there are no dependencies on this item
			System.out.println("\t"+"Removing "+ this.name);
			
			//Remove dependency of this item on other items. If the other item is no more dependent by any other items, remove that item as well.
			for (int i = 0; i < dependenciesList.size(); i++) {
				dependenciesList.get(i).decrementDependentCount();
				dependenciesList.get(i).remove(false);
			}
			return true;
		}
			
	}
}
