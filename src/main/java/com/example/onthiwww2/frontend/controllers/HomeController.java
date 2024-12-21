/*
 * @ (#) HomeController.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.frontend.controllers;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */

import com.example.onthiwww2.frontend.models.CandidateModels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableWebSecurity
@Slf4j
public class HomeController {

    @Autowired
    private CandidateModels cm;


    @GetMapping("/candidates")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("candidate");
        mav.addObject("candidates", cm.findAll());
        return mav;
    }

    @GetMapping("/cand_detail/{id}")
    public ModelAndView getAll(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cand_detail");
        mav.addObject("candidate", cm.findById(id));
        return mav;
    }

    @GetMapping("report1")
    public ModelAndView getByCompName(@RequestParam(value = "compName", required = false) String name){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("report1");
        mav.addObject("candidates", cm.findByCompanyName(name));
        return mav;
    }

    @GetMapping("report2")
    public ModelAndView getByExperience(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("report2");
        mav.addObject("candidates", cm.findByExperienceGreaterThan5Year());
        return mav;
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

}
