package com.im.controller;

import com.im.model.Customer;
import com.im.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //    Default home path '/' will return view index with message
    @RequestMapping(method = RequestMethod.GET,value="/")
    public String printHello(ModelMap model){
        model.addAttribute("message","Hello Spring MVC in maven");
        return "index";
    }
    //  When the path is routed to '/home' below method to be called and view returned is home
    @RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView home1(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("pageTitle","Home Page");
        modelAndView.addObject("message","Hi Welcome to Sprint MVC");
        return modelAndView;
    }
    //  When the path is routed to '/pokemanage' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value = "/pokemanage")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        for (Customer Customer : listCustomer) {
            System.out.println(Customer.toString());
        }
        ModelAndView mav = new ModelAndView("pokemanage");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }
    //  When the path is routed to '/new' below method to be called and view returned is newPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer Customer = new Customer();
        model.put("customer", Customer);
        return "newPokemon";
    }
    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editPokemon
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public ModelAndView editPokemonForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPokemon");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value ="/delete")
    public String deletePokemonForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/pokemanage";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchPokemon
//    @RequestMapping(method = RequestMethod.GET, value ="/search")
//    public ModelAndView search(@RequestParam String keyword) {
//        List<Customer> result = customerService.search(keyword);
//        ModelAndView mav = new ModelAndView("searchPokemon");
//        mav.addObject("result", result);
//
//        return mav;
//    }

    @RequestMapping(method = RequestMethod.GET, value ="/searchCustomerByIdAndName")
    public ModelAndView findByIdAndName(Long customerId, String name) {
        List<Customer> result = customerService.findByIdAndName(customerId, name);
        ModelAndView mav = new ModelAndView("searchCustomerByIdAndName");
        mav.addObject("resultByIdAndName", result);
        return mav;
    }
}
