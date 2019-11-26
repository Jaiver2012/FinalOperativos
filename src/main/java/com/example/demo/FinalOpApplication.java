package com.example.demo;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	        	
//	        		
//	        		line = reader.readLine();
//	        		String[] test1 = line.split(":");
//	        		
//	        		line = reader.readLine();
//	        		String[] test2 = line.split(":");
//	        		
//	        		line = reader.readLine();
//	        		String[] test3 = line.split(":");
//	        		
//	        		line = reader.readLine();
//	        		String[] test4 = line.split(":");
//	        		
//	        		line = reader.readLine();
//	        		String[] test5 = line.split(":");
//	        		
//	        		line = reader.readLine();
//	        		String[] test6 = line.split(":");
//	        		
//	        		
//	        		System.out.println(processArray.size());
//	        		Proceso p = new Proceso(test1[1], test2[1], test3[1],
//	        				test4[1], test5[1], test6[1]);
//	        		processArray.add(p);
	        	}


	        	

	    
	        reader.close();
	        proc.getOutputStream().close();
		}catch(Exception e) {
			
		}

				
	}

}
