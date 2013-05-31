package pl.edu.pw.elka.postsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping("/")
    public ModelAndView mainRender() {
        final ModelAndView modelAndView = new ModelAndView("search");

        return modelAndView;
    }

}
