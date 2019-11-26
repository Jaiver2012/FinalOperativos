package com.example.demo;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FinalOpApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(FinalOpApplication.class, args);
		
		try {
			Runtime runtime = Runtime.getRuntime();
	        Process proc = runtime.exec("powershell ./src/main/resources/scripts/process.ps1");
	        InputStream is = proc.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader reader = new BufferedReader(isr);
	        String line;
	        String line2;
	        while ((line = reader.readLine()) != null)
	        {
	        	
	        	System.out.println(line);
	        	String[] p=line.split("\\s+");
	        	System.out.println(Arrays.toString(p));	  
	        	
	        	
	        	}


	        	

	    
	        reader.close();
	        proc.getOutputStream().close();
		}catch(Exception e) {
			
		}

				
	}

}
