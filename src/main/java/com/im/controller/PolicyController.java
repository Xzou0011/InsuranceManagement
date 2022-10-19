package com.im.controller;

import com.im.model.Policy;
import com.im.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@Controller
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    //  When the path is routed to '/pokemanage' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value = "/policymanage")
    public ModelAndView home() {
        List<Policy> listPolicy = policyService.listAll();
        for (Policy Policy : listPolicy) {
            System.out.println(Policy.toString());
        }
        ModelAndView mav = new ModelAndView("policymanage");
        mav.addObject("listPolicy", listPolicy);
        return mav;
    }
    //  When the path is routed to '/new' below method to be called and view returned is newPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/newPolicy")
    public String newPolicyForm(Map<String, Object> model) {
        Policy listPolicy = new Policy();
        model.put("policy", listPolicy);
        return "newPolicy";
    }
    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/savePolicy")
    public String savePolicy(@ModelAttribute("policy") Policy policy) {
        policyService.save(policy);
        return "redirect:/";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editPokemon
    @RequestMapping(method = RequestMethod.GET, value = "/editPolicy")
    public ModelAndView editPolicy(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPolicy");
        Policy policy = policyService.get(id);
        mav.addObject("policy", policy);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value ="/deletePolicy")
    public String deletePolicyForm(@RequestParam long id) {
        policyService.delete(id);
        return "redirect:/policymanage";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicy")
    public ModelAndView search(@RequestParam String keyword) {
        List<Policy> result = policyService.search(keyword);
        ModelAndView mav = new ModelAndView("searchPolicy");
        mav.addObject("result", result);

        return mav;
    }
}
