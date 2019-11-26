package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class Controller {

	@Autowired
	private ProcesoRepository procesoRepository;

	// Prueba

	@PostConstruct
	public void init() {

		// prueba

		try {
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("powershell ./src/main/resources/scripts/process.ps1");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String line;

			int count = 0;
			while ((line = reader.readLine()) != null) {

				System.out.println(line);

				String[] p = line.split("\\s+");
				System.out.println(Arrays.toString(p));
				System.out.println(p.length);

				if (p.length >= 7 && count > 2) {
					// System.out.println(Arrays.toString(p));

					Proceso p1 = new Proceso();
					
					if(p.length==8) {
						p1.setNombre(p[7]);
					}
					else {
						p1.setNombre(p[8]);	
					}
					

					procesoRepository.save(p1);

				}

				count++;
			}

			reader.close();
			proc.getOutputStream().close();
		} catch (Exception e) {

		}

	}

	public Proceso addProcess(Proceso proceso) {
		return procesoRepository.save(proceso);
	}

	public boolean deleteProcess(Proceso proceso) {

		boolean flag = false;

		if (proceso != null) {
			procesoRepository.deleteById(proceso.getId());
			flag = true;

		}

		return flag;

	}

	public List<Proceso> listProcess() {
		return (List<Proceso>) procesoRepository.findAll();
	}

	@RequestMapping(value = "/listarProcesos", method = RequestMethod.GET)
	public String handleRequestListarProcesos(Model model) {

		List<Proceso> procesos = listProcess();
		model.addAttribute("procesos", procesos);
		return "listarFormProcesos.html";

	}

	@RequestMapping(value = "/borrarProceso/{id}", method = RequestMethod.GET)
	public String handleRequestBorrarUsuarios(Model model, @PathVariable Long id) {
		Proceso proceso = procesoRepository.findById(id).get();
		deleteProcess(proceso);
		List<Proceso> processList = listProcess();
		model.addAttribute("procesos", processList);
		return "listarFormProcesos.html";
	}

	@RequestMapping(value = "/volver", method = RequestMethod.GET)
	public String handleRequestVover() {
		return "index.html";

	}

}
