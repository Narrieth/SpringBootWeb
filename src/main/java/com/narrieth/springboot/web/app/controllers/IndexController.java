package com.narrieth.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narrieth.springboot.web.app.models.Usuario;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexController {
	
//	@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo","holaaa spring framework!");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Narrieth");
		usuario.setApellido("Felipe");
		usuario.setEmail("narrieth@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Narrieth", "Felipe", "narrieth@gmail.com"));
		usuarios.add(new Usuario("Pedro", "Peres", "pedro@gmail.com"));
		usuarios.add(new Usuario("Juan", "Peres", "juan@gmail.com"));
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
