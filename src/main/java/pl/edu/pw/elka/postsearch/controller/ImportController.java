package pl.edu.pw.elka.postsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.elka.postsearch.controller.beans.FileUpload;
import pl.edu.pw.elka.postsearch.model.Posts;
import pl.edu.pw.elka.postsearch.service.harvesting.TwitterCorpusHarvester;
import pl.edu.pw.elka.postsearch.service.repositories.PostIndexRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
public class ImportController extends PostSearchAbstractController {

    @Autowired
    private PostIndexRepository postIndexRepository;

    @RequestMapping(value = "/harvest", method = RequestMethod.GET)
    public ModelAndView harvestPostsRender() {
        final ModelAndView modelAndView = new ModelAndView("harvest");

        return modelAndView;
    }

    @ModelAttribute("fileUpload")
    public FileUpload getFileUpload() {
        return new FileUpload();
    }

    @RequestMapping(value = "/harvest", method = RequestMethod.POST)
    public ModelAndView harvestPosts(@ModelAttribute("fileUpload") FileUpload fileUpload) throws IOException {
        final ModelAndView modelAndView = new ModelAndView("harvest");

        final InputStream inputStream = fileUpload.getMultipartFile().getInputStream();
        final Integer pageSize = fileUpload.getPageSize();
        final String countryCode = fileUpload.getCountryCode();

        final TwitterCorpusHarvester harvester = new TwitterCorpusHarvester(new InputStreamReader(inputStream), pageSize, countryCode);

        long count = 0l;
        for (Posts posts : harvester) {
            count += posts.getPostList().size();
            postIndexRepository.save(posts.getPostList());
        }

        modelAndView.addObject(MESSAGE, "Zaimportowano %size% post(ów)".replace("%size%", Long.toString(count)));

        return modelAndView;
    }
}
