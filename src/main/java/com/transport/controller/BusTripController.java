package com.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.entity.BusTrip;
import com.transport.service.BusTripService;
import com.transport.service.CheckpointService;
import com.transport.service.StopService;

@Controller
@RequestMapping("/busTrips")
public class BusTripController {
    @Autowired
    private BusTripService btservice;

    @Autowired
    private CheckpointService cService;

    @Autowired
    private StopService sService;

    @ModelAttribute("busTrip")
    public BusTrip getBusTrip(
            @RequestParam(value = "id", required = false) final Long id) {
    	BusTrip busTrip;
        if (id == null) {
        	busTrip = new BusTrip();
        } else {
        	busTrip = btservice.getBusTrip(id);
        }
        return busTrip;
    }

    @RequestMapping(value = "/cFind", method = RequestMethod.POST)
    public String getBusInfo(@ModelAttribute("busTrips") BusTrip busTrip, ModelMap map) {
        if (busTrip.getId() != null) {
            // List<BusTrip> busTrips = btservice.filterBusTrip(busTrip., idStopTo, t, day_type);
            // map.addAttribute("busTrip", busTrips);
        }
        return "busTrips/list";
    }
    
    @RequestMapping(value = "/cFind", method = RequestMethod.GET)
    public String getBusInfo1(ModelMap map) {
        return "/index";
    }
}

