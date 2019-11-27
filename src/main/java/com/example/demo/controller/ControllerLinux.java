package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.model.Proceso;



@org.springframework.stereotype.Controller
public class ControllerLinux {

	
	/**
	 * List different process running in the host with unix
	 * @return list of process
	 */
	public List<Proceso> listProcess(){

		List<Proceso> procesos = new ArrayList<>();
		try {
			Process proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ps -ef" });
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = reader.readLine();

			while ((line = reader.readLine()) != null)
			{
				
				String[] p = line.split("\\s+");
				Proceso p1 = new Proceso();
				
//				System.out.println(line);
//				System.out.println(Arrays.toString(p));
//				System.out.println(p.length);
				
				if(p.length==8) {
					p1.setId(Long.parseLong(p[1]));
					p1.setNombre(p[7]);
					p1.setSi(p[0]);
					p1.setCpu(p[6]);
					
				}else {
					
					p1.setId(Long.parseLong(p[1]));
					p1.setSi(p[0]);
					p1.setCpu(p[6]);
					p1.setNombre("");
					for (int i = 7; i < p.length; i++) {
						p1.setNombre(p1.getNombre()+ " "+p[i]);						
					}
				}
				
				procesos.add(p1);
			}
			
			
		}
		catch (Exception e)
		{
			// handle error
		}
		return procesos;
	}
	
	
	
	/**
	 * handle of list process
	 * @param model
	 * @return page with the process runnig
	 */
	@RequestMapping(value = "/listarProcesos/linux", method = RequestMethod.GET)
	public String listProcessLinux(Model model) {

		List<Proceso> procesos = listProcess();
		model.addAttribute("procesos", procesos);
		return "listarFormProcesosLinux.html";

	}
	
	/**
	 * Cancela determinado proceso el cual se le pasa el id por parametro
	 * @param model
	 * @param id
	 * @return lista de procesos
	 */
	@RequestMapping(value = "/borrarProceso/linux/{id}", method = RequestMethod.GET)
	public String CancelProcessLinux(Model model, @PathVariable Long id) {
		
		try {
			Process proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", "kill "+ id });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProcessLinux(model);
	}
	
	/**
	 * Devuelve a la página  de inicio
	 * @return index.html: página de inicio
	 */
	@RequestMapping(value = "/volver/linux", method = RequestMethod.GET)
	public String handleRequestVolver() {
		return "index.html";
	}

	
}