
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

    @GetMapping("/Swagger-ui")
    public String showSwaggerPage() {
        return "Swagger-ui";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
    @GetMapping("/reload")
    public String reloadPage() {
        return "redirect:/loading";
    }
    @GetMapping("/loading")
    public String loadingPage() {
        return "loading";
    }
    @GetMapping("/afterLogin")
    public ModelAndView redirectToHome() {
        return new ModelAndView(new RedirectView("/home"));
    }
    // Nouvelle route pour rediriger vers la page d'accueil
    @GetMapping("/redirectHome")
    public String redirectHome() {
        return "redirect:/home";
    }

}
