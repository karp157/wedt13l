package pl.edu.pw.elka.postsearch.controller;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.search.suggest.Suggest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.edu.pw.elka.postsearch.service.repositories.SuggestService;

import javax.annotation.Resource;

@Controller
public class SearchController extends PostSearchAbstractController {
    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
    @Resource
    private PostSearchRepository postSearchRepository;

    @Autowired
    private SuggestService suggestService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainRender() {
        final ModelAndView modelAndView = new ModelAndView("search");

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "query")
    public ModelAndView search(@RequestParam("query") String query,
                               @PageableDefault(size = 5)
                               Pageable pageable) {
        final ModelAndView modelAndView = new ModelAndView("search");

        Page<Post> posts;
        if ("".equals(StringUtils.trim(query))) {
            posts = postSearchRepository.findAll(pageable);
        } else {
            posts = postSearchRepository.findByMessage(query, pageable);
            String suggestion = suggestService.getMostLikelySuggestions(query);
            if(suggestion != null) {
                modelAndView.addObject("suggestion", suggestion);
            }
        }

        modelAndView.addObject("query", query);
        modelAndView.addObject("postsPage", posts);
        modelAndView.addObject("posts", posts.iterator());
        return modelAndView;
    }
}
