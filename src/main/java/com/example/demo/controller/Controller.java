package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Proceso;
import com.example.demo.repository.ProcesoRepository;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private ProcesoRepository procesoRepository;

	
	public Proceso addProcess(Proceso proceso) {
		return procesoRepository.save(proceso);
	}
	
	
	public boolean deleteProcess(Proceso proceso) {
		
		boolean flag=false;
		
		if(proceso!=null) {
			procesoRepository.deleteById(proceso.getId());
			flag=true;
			
		}
		
		return flag;
		
	}
	
	public List<Proceso> listProcess(){
		return (List<Proceso>) procesoRepository.findAll();
	}
	
	
	@RequestMapping(value= "/listarProcesos", method= RequestMethod.GET)
	public String handleRequestListarProcesos(Model model) {
	
		List<Proceso> procesos = listProcess();
		model.addAttribute("procesos",procesos);
		return "listarFormProcesos.html";
		
	}
	

	@RequestMapping(value= "/borrarProceso/{id}", method= RequestMethod.GET)
	public String handleRequestBorrarUsuarios(Model model, @PathVariable Long id)
	{
		Proceso proceso = procesoRepository.findById(id).get();
		deleteProcess(proceso);
		List<Proceso> processList = listProcess();
		model.addAttribute("procesos", processList);
		return "listarFormProcesos.html";
	}
	
	
}
