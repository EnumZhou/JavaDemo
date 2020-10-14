package com.mercury.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. private all fields
// 2. only getters, no setters
// 3. provide constructors to initialize all values
// 4. make sure no function to change fields
// 5. primitive type: getter only return value
//    customized class : make it immutable(String is immutable)
//    List/Set/Map: Collections.unmodifiableList(list)
// 6.final the class, so no function can be overridden (no other behavior)
// 7. BY USING THE REFLECTION, NO IMMUTABLE CLASS IN JAVA( SO, NORMALLY SHOULD NOT USE REFLECTION)
public final class MyImmutable {
	public static int batch=20020;
	private final int id;
	private final String name;
	private final List<String> info;
	
	public MyImmutable(int id, String name, List<String> info) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public List<String> getInfo() {
		return Collections.unmodifiableList(info);
	}
	
	
	//to indicate the object information, what "this" object looks like
	@Override
	public String toString() {
		return "MyImmutable [id=" + id + ", name=" + name + ", info=" + info + "]";
	}
	
	
	public static void main(String args[]){
		MyImmutable mi=new MyImmutable(1,"Voodoo",new ArrayList());
		System.out.println(mi.getClass().getName());
		System.out.println(mi);
		System.out.println(mi.toString());
		
	}

}
