package com.transport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.entity.Checkpoint;
import com.transport.service.CheckpointService;

@Controller
@RequestMapping("/checkpoints")
public class CheckpointController {
	private CheckpointService service;
	 /**
     * 
     * @param id
     * @return get 
     */
    @ModelAttribute("Checkpoint")
    public Checkpoint getCheckpoints(
            @RequestParam(value = "id", required = false) final Long id) {
    	Checkpoint checkpoint;
        if (id == null) {
        	checkpoint = new Checkpoint();
        } else {
        	checkpoint = service.getCheckpoint(id);
        }
        return checkpoint;
    }
    
    @RequestMapping(value = "/list.html")
    public String checkpoints(ModelMap map) {
        List<Checkpoint> checkpoints = service.getCheckpoints();
        map.addAttribute("checkpoints", checkpoints);
        return "checkpoint/list";
    }
}
