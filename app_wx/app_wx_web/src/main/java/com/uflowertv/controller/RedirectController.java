package com.uflowertv.controller;

import com.uflowertv.support.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/4/20.
 */
@Controller
@RequestMapping("redirect")
public class RedirectController extends BaseController{

    @RequestMapping("/redirect/{message}")
    public ModelAndView redirect(@PathVariable String message){
        ModelAndView mv = new ModelAndView("redirect");
        mv.addObject("message",message);
        return mv;
    }
}
