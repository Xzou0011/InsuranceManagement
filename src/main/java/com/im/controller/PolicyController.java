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
    @RequestMapping(method = RequestMethod.GET, value ="/newPolicy")
    public String newPolicyForm(Map<String, Object> model) {
        Policy listPolicy = new Policy();
        model.put("policy", listPolicy);
        return "newPolicy";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/savePolicy")
    public String savePolicy(@ModelAttribute("policy") Policy policy) {
        policyService.save(policy);
        return "redirect:/";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/editPolicy")
    public ModelAndView editPolicy(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPolicy");
        Policy policy = policyService.get(id);
        mav.addObject("policy", policy);
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET, value ="/deletePolicy")
    public String deletePolicyForm(@RequestParam long id) {
        policyService.delete(id);
        return "redirect:/policymanage";
    }
    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicy")
    public ModelAndView search(@RequestParam String keyword) {
        List<Policy> result = policyService.search(keyword);
        ModelAndView mav = new ModelAndView("searchPolicy");
        mav.addObject("result", result);

        return mav;
    }
}
