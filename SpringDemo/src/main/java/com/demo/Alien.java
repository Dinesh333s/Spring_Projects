package com.demo;

public class Alien {

	private int age;
	private Computer com;
	public Alien()
	{
		System.out.println("I'm constructor..");
		
     }
	
//	public Alien(int age) {
//		
//		this.age = age;
//	}
//	
	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public void code() {
		System.out.println("HI I'm code function...");
	}
	
	public int getAge() {
		
		return age;
	}
	
	public void setAge(int age) {
		System.out.println("Age assigned");
		this.age = age;
	}
	
	
	

	public void code_Laptop()
	{
		System.out.println("I'm coding");
		com.compile();
	}

}
