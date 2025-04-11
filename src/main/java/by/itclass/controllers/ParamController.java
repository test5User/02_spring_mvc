package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {

    @GetMapping("/paramsOld")
    public String paramOldApproach(HttpServletRequest request) {
        var stringParam = request.getParameter("param1");
        var intParam = Integer.parseInt(request.getParameter("param2"));
        request.setAttribute("stringParam", stringParam);
        request.setAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/paramsSpring")
    public String paramsSpring(@RequestParam(name = "param1", required = false) String name,
                               @RequestParam(name = "param2", required = false) Integer age,
                               HttpServletRequest request) {
        request.setAttribute("stringParam", name);
        request.setAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/paramsSession")
    public String paramsSession(@RequestParam(name = "param1", required = false) String name,
                                @RequestParam(name = "param2", required = false) Integer age,
                                HttpSession session) {
        session.setAttribute("stringParam", name);
        session.setAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/paramsAsUrlPart/{param1}/{param2}")
    public String paramsAsUrlPart(@PathVariable(name = "param1") String str,
                                  @PathVariable(name = "param2") int number,
                                  HttpServletRequest request) {
        request.setAttribute("stringParam", str);
        request.setAttribute("intParam", number);
        return "main";
    }

    @GetMapping("/paramsModel/{param1}/{param2}")
    public String paramsModel(@PathVariable(name = "param1") String str,
                              @PathVariable(name = "param2") int number,
                              Model model) {
        model.addAttribute("stringParam", str);
        model.addAttribute("intParam", number);
        return "main";
    }

    @GetMapping("/paramsModelAndView/{param1}/{param2}")
    public ModelAndView paramsModelAndView(@PathVariable(name = "param1") String str,
                              @PathVariable(name = "param2") int number,
                              Model model) {
        var modelAndView = new ModelAndView();
        if (number >= 32) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("stringParam", str);
            modelAndView.addObject("intParam", number);
            modelAndView.setViewName("main");
        }
        return modelAndView;
    }
}
