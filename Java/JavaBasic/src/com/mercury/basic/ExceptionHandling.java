package com.mercury.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.org.apache.xerces.internal.impl.xpath.XPathException;

public class ExceptionHandling {

	public static void testBasic(){
		//throw new IOExpection();
		try{
			FileOutputStream fos=new FileOutputStream("c:123.txt");
			//if exception, remaining code ignored
		}catch(Exception e)
		{
			
		}
		
		System.out.println();  //after catch, code conntinue
	}
	
	//try-catch: handle the exception right here,right now
	// throws: not handle, throw it to the caller
	//throws: may throws
	
	public static void testBasic2(String filePath) throws FileNotFoundException{
		FileOutputStream fos=new FileOutputStream("c:123.txt");
	}
	//Normal Exception has to be handled, but it is Not a must
	
	
	
	
	public static void testRuntimeException(){
		//Runtime exception can also be handled, even it is NOT a must
		throw new NullPointerException("ABCD");
	}
	
	public static void testMultiExpection(int id){
		try{
			//to catch multiple exception:
			// 1. catch them one by one, in multiple catch blocks
			//  if par/sub exception, must catch sub exception first
			// 2. | to list all exceptions
			// 3. to catch a shared parent Exception ( Exception/ Throwable)
			if(id>5){
				throw new IOException(); // par exception
			}
			if(id<0){
				
				throw new XPathException("ABC");
				//throw new FileNotFoundException(); //child exception
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(XPathException xe){
			xe.printStackTrace();
		}
	}
	
	public static void main2(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		testBasic2("C:123.text");	
	}
	
	public static void testFinaly(){
		FileOutputStream fos=null;
		FileInputStream fis=null;
		
		
		try{
			System.out.println(1);
			fos=new FileOutputStream("c:123.txt");
			
			//System.exit(1);
			if(true){
				throw new NullPointerException();
			}
			//fos.write(123);
			fos.close();
		}catch(Exception e){
			System.out.println(2);
			e.printStackTrace();
			System.out.println(3);	
		} finally{
			//finally block will always be executed no matter what happened in try/catch blocks
			//unless JVM shut down System.exit(1);
			
			/********* normally use finally to close resources*********/
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(4);
	}
	/***important part for exception    ***/
	public static void testTryWithResource(){
		// only AutoClosable can be put in the try()
		//resource: AutoClosable implementation
		//try(): try with resource
		try(FileOutputStream fos=new FileOutputStream("c:123.txt");
			FileInputStream fis=new FileInputStream("d:/234.txt");	
				){
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void main (String args[]){
		
		
		
	}

}
