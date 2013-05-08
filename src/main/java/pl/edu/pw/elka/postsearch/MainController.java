package pl.edu.pw.elka.postsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController
{
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String mainRender(Model model)
	{
        model.addAttribute("message", "Witajta");
		return "hello";
	}
}
