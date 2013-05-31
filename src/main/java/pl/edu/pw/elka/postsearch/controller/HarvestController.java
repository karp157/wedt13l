package pl.edu.pw.elka.postsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HarvestController {
    @RequestMapping(value = "/harvest", method = RequestMethod.POST)
    public ModelAndView harvestPosts(MultipartFile multipartFile) {
        final ModelAndView modelAndView = new ModelAndView("search");


        return modelAndView;
    }
}
