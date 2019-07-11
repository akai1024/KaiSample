package kai.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @Value("${welcome.message}")
    private String welcomeMsg;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        model.addAttribute("welcomeMsg", welcomeMsg);
        return "home";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String getChat(Model model) {
        return "chat";
    }

}
