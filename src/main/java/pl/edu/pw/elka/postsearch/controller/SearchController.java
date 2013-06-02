package pl.edu.pw.elka.postsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.elka.postsearch.model.Post;
import pl.edu.pw.elka.postsearch.service.repositories.PostSearchRepository;

import javax.annotation.Resource;

@Controller
public class SearchController extends PostSearchAbstractController {
    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
    @Resource
    private PostSearchRepository postSearchRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainRender() {
        final ModelAndView modelAndView = new ModelAndView("search");

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "query")
    public ModelAndView search(@RequestParam("query") String query,
                               @PageableDefault(size = 2)
                               Pageable pageable) {
        final ModelAndView modelAndView = new ModelAndView("search");

        Page<Post> posts = postSearchRepository.findByMessage (query, pageable);

        modelAndView.addObject("query", query);
        modelAndView.addObject("postsPage", posts);
        modelAndView.addObject("posts", posts.iterator());
        return modelAndView;
    }
}
