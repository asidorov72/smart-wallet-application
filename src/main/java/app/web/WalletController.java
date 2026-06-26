package app.web;

import app.model.dto.user.UserDto;
import app.model.dto.wallet.WalletDto;
import app.service.user.AuthenticationUserDetails;
import app.service.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/wallets")
public class WalletController {

    private final UserService userService;

    public WalletController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getWallets(@AuthenticationPrincipal AuthenticationUserDetails principal) {

        UserDto user = userService.getById(principal.getId());

        List<WalletDto> wallets = user.getWallets();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wallets");
        modelAndView.addObject("wallets", wallets);

        return modelAndView;
    }
}
