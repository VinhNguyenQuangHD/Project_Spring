package com.coffee.controller;

import com.coffee.dao.AccountDAO;
import com.coffee.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "index";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page(ModelAndView model) throws IOException {
        List<Account> listContact = accountDAO.list();
        model.addObject("listContact", listContact);
        model.setViewName("page");

        return model;
    }

    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public ModelAndView page2(ModelAndView model){
        Account acc = new Account();
        model.addObject("account",new Account());
        model.setViewName("page1");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Account account) {
        accountDAO.saveOrUpdate(account);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("__id_account"));
        accountDAO.delete(contactId);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("__id_account"));
        Account account = accountDAO.get(contactId);
        ModelAndView model = new ModelAndView("page1");
        model.addObject("account", account);

        return model;
    }
}
