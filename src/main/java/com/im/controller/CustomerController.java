package com.im.controller;

import com.im.model.Customer;
import com.im.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.GET,value="/")
    public String printHello(ModelMap model){
        model.addAttribute("message","Hello Spring MVC in maven");
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView home1(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("pageTitle","Home Page");
        modelAndView.addObject("message","Hi Welcome to Sprint MVC");
        return modelAndView;
    }

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
    @RequestMapping(method = RequestMethod.GET, value ="/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer Customer = new Customer();
        model.put("customer", Customer);
        return "newPokemon";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public ModelAndView editPokemonForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPokemon");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET, value ="/delete")
    public String deletePokemonForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/pokemanage";
    }

    @RequestMapping(method = RequestMethod.GET, value ="/searchCustomerByIdAndName")
    public ModelAndView findByIdAndName(Long customerId, String name) {
        List<Customer> result = customerService.findByIdAndName(customerId, name);
        ModelAndView mav = new ModelAndView("searchCustomerByIdAndName");
        mav.addObject("resultByIdAndName", result);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/searchByIdAndNameDetail")
    public ModelAndView searchByNameDetail(@RequestParam long customerId, @RequestParam String name) {
        List<Customer> result = customerService.findByIdAndName(customerId, name);
        ModelAndView mav = new ModelAndView("searchCustomerByIdAndNameDetail");
        mav.addObject("resultByIdAndNameDetail", result);
        return mav;
    }
}
