package com.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.entity.Bus;
import com.transport.service.BusService;

@Controller
@RequestMapping("/Buses")
public class BusController {
    @Autowired
    private BusService service;

    @ModelAttribute("timeTable")
    public Bus getBus(@RequestParam(value = "id", required = false) final Long id) {
        Bus bus;
        if (id == null) {
            bus = new Bus();
        } else {
            bus = service.getBus(id);
        }
        return bus;
    }

    /**
     * 
     * @param map
     * @return send buses to page
     */
    @RequestMapping("/list.html")
    public String timeTables(ModelMap map) {
        final List<Bus> bus = service.getBuses();
        map.addAttribute("buses", bus);
        return "timetables/list";
    }
}
