package com.gcontento.wchallenge.entities;

public enum PermissionType {

	READ(1), WRITE(2), READ_WRITE(3);

	private long id;
	
	PermissionType(long id) {
		this.id = id;
	}
	
	
	public static PermissionType getId(long id) {
		for (PermissionType permType : values()) {
			if (permType.id == id) {
				return permType;
			}
		}
		return null;
		
		
	}
	
	
	

}
