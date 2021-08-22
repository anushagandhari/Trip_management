package com.example.demo.repository;

import com.example.demo.model.Route;
//import java.util.*;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends CrudRepository<Route,String>{
	Route findByRouteId(String routeId);	
}





