package app.web;

import app.model.dto.user.UserDto;
import app.service.user.AuthenticationUserDetails;
import app.service.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(@AuthenticationPrincipal AuthenticationUserDetails principal) {
        //UserDto user = userService.getById(); // kaloyan123

//        AuthenticationUserDetails principal = (AuthenticationUserDetails) SecurityContextHolder
//                .getContext()
//                .getAuthentication()
//                .getPrincipal();

        UserDto user = userService.getById(principal.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
