package pl.edu.pw.elka.postsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController
{

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String mainRender()
	{
		return "hello";
	}
}
