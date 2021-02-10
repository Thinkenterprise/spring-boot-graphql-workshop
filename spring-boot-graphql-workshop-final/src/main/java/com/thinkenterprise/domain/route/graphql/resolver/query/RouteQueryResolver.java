package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.model.repository.FlightRepository;
import com.thinkenterprise.domain.route.jpa.model.repository.RouteRepository;

import graphql.kickstart.tools.GraphQLResolver;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Component
public class RouteQueryResolver implements GraphQLResolver<Route> {

	
    private FlightRepository flightRepository;
    private RouteRepository routeRepository;

    @Autowired
    public RouteQueryResolver(RouteRepository routeRepository,
    					      FlightRepository flightRepository) {
    	this.routeRepository=routeRepository;
        this.flightRepository=flightRepository;
    }

    public List<Flight> flights(Route route) {
        return flightRepository.findByRoute(route);	
    }

    public Route route(Route route) {
    	return routeRepository.findByRoute(route);
    }

}