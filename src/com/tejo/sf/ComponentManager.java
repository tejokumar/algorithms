package com.tejo.sf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ComponentManager {
	
	//Map to store components
	Map<String,Item> items;
	
	public ComponentManager(){
		items = new HashMap<String, Item>();
	}
	
	//Add the item to map if it was not added before
	public void addItem(String name){
		if(!items.containsKey(name)){
			Item item = new Item(name);
			items.put(name, item);
		}	
	}
	
	//Add dependency to an item
	public void addDependentItem(String itemName,String dependentItemName){
		if(!items.containsKey(dependentItemName)){
			Item item = new Item(dependentItemName);
			items.put(dependentItemName, item);
		}
		items.get(itemName).addDependency(items.get(dependentItemName));
	}
	
	public void removeItem(String itemName){
		//If the item and its dependencies are removed, remove the item from map
		if(items.get(itemName).remove(true)){
			items.remove(itemName);
		}
	}
	
	public void installItem(String itemName){
		//Add item to map before installing
		addItem(itemName);
		items.get(itemName).install();
	}
	
	public void listItems(){
		Iterator<Item> iter = items.values().iterator();
		while (iter.hasNext()) {
			System.out.println("\t"+iter.next().getName());
			
		}

	}
}
