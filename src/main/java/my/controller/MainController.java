package my.controller;

import my.database.implement.AccountTable;
import my.database.implement.RoleTable;
import my.database.implement.SqlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 12.09.2018.
 */

@Controller
public class MainController {

    final String ROOT="/";
    private RoleTable role;
    private AccountTable account;

    @Autowired
    public void setRole(RoleTable role) {
        this.role = role;
    }
    @Autowired
    public void setAccount(AccountTable account) {
        this.account = account;
    }

    @RequestMapping("/**")
    public ModelAndView welcomePage(ModelMap model){
        model.addAttribute("message","WelcomePage");
        return new ModelAndView("helloworld",model);
    }

    @RequestMapping("/login")
    public ModelAndView showAuthorizePage(ModelMap model){
        model.addAttribute("message","Admin prishel");
        return new ModelAndView("login",model);
    }

    @RequestMapping("/sa")
    public ModelAndView saView(ModelMap model){
        model.addAttribute("message","Super Odmen");
        return new ModelAndView("protected",model);
    }

    @RequestMapping(path = "/reg")
    public ModelAndView showRegistration(@RequestParam Map<String, String> param, ModelMap model) {
        model.addAttribute("status","Введите данные для регистрации");
        return new ModelAndView("account/registration",model);
    }

    @RequestMapping(path = "/reg",method = RequestMethod.POST)
    public ModelAndView createAccount(@RequestParam Map<String, String> param, ModelMap model) {
        String viewName=ROOT;
        HashMap result=account.createAccount(param.get("username"),param.get("password"));
        model.addAttribute("status",result.get("mess"));
        switch ((byte)result.get("status")){
            case (0):
                viewName="account/registration";
                break;
            case (1):
                viewName="login";
                break;
        }
        return new ModelAndView(viewName,model);
    }


}
