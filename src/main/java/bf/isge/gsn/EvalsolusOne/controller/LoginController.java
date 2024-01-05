/*
package bf.isge.gsn.EvalsolusOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
*/
package bf.isge.gsn.EvalsolusOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginPage() {
        return "home";
    }



    @GetMapping("/addCriteria")
    public String showaddPage() {
        return "addCriteria";
    }



    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/afterLogin")
    public ModelAndView redirectToHome() {
        // Ici, vous pouvez ajouter des données à la vue si nécessaire
        return new ModelAndView(new RedirectView("/home"));
    }

    // Ajoutez d'autres méthodes au besoin
}
