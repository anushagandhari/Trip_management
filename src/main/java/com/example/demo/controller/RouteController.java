package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.model.Admin;
//import com.example.demo.model.Customer;
import com.example.demo.model.Route;
import com.example.demo.repository.IRouteRepository;
import com.example.demo.repository.IAdminRepository;

@RestController
public class RouteController {
	@Autowired
	IRouteRepository  repo;
	
	@Autowired 
	IAdminRepository repo2;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
		
	}
	
	@PostMapping("admin/addroutes")
	public Boolean saveRoute(@RequestBody Route r) {
		try {			
			System.out.println(r.routeId);
			System.out.println(r.routeFrom);
			System.out.println(r.routeTo);
			System.out.println(r.fare);
			
			
			repo.save(r);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@GetMapping("/routes")
	public List<Route> getRoute()
	{
		return (List<Route>) repo.findAll();
	}
	
	@DeleteMapping("/deleteRoutes/{id}")
	public Boolean deleteRoute(@PathVariable String id)
	{
		try {
			
			System.out.println("Id is "+id);
			System.out.println("deleting");
			System.out.println(repo.findById(id));
			repo.deleteById(id);

			return true;
		}
		catch(Exception ee)
		{
			return false;
		}
	}

}


