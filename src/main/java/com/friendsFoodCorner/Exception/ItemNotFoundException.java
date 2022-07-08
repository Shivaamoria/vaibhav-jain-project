package com.friendsFoodCorner.Exception;

public class ItemNotFoundException extends IllegalArgumentException{
	public ItemNotFoundException(String msg){
		super(msg);
	}
	
}
