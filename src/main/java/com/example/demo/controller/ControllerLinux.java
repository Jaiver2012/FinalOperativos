package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Proceso;
import com.example.demo.repository.ProcesoRepository;

@org.springframework.stereotype.Controller
public class ControllerLinux {

	@Autowired
	private ProcesoRepository procesoRepository;

	
	
	/**
	 * Cancela determinado proceso el cual se le pasa el id por parametro
	 * @param model
	 * @param id
	 * @return lista de procesos
	 */
	@RequestMapping(value = "/borrarProceso/linux/{id}", method = RequestMethod.GET)
	public String CancelProcessLinux(Model model, @PathVariable Long id) {
		
		Proceso proceso = procesoRepository.findById(id).get();
		deleteProcess(proceso);
		//List<Proceso> processList = listProcess();
		//model.addAttribute("procesos", processList);
		return "listarFormProcesosWindows.html";
	}
	
	/**
	 * Devuelve a la página  de inicio
	 * @return index.html: página de inicio
	 */
	@RequestMapping(value = "/volver/linux", method = RequestMethod.GET)
	public String handleRequestVolver() {
		return "index.html";
	}

	@PostConstruct
	public void listProcess(){

		try {
			Process proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ps aux" });
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (Exception e)
		{
			// handle error
		}
	}
	
	
	/**
	 * 
	 * @param proceso
	 * @return
	 */
	public boolean deleteProcess(Proceso proceso) {

		boolean flag = false;
		return flag;
	}
	
}