package com.im.controller;

import com.im.model.PolicyHolderRecord;
import com.im.service.PolicyHolderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PolicyHolderRecordController {

    @Autowired
    private PolicyHolderRecordService policyHolderRecordService;

    //  When the path is routed to '/pokemanage' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value = "/policeholderrecordmanage")
    public ModelAndView home() {
        List<PolicyHolderRecord> listPolicyHolderRecord = policyHolderRecordService.listAll();
        for (PolicyHolderRecord PolicyHolderRecord : listPolicyHolderRecord) {
            System.out.println(PolicyHolderRecord.toString());
        }
        ModelAndView mav = new ModelAndView("policeholderrecordmanage");
        mav.addObject("listPolicyHolderRecord", listPolicyHolderRecord);
        return mav;
    }

    //  When the path is routed to '/new' below method to be called and view returned is newPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/newPolicyHolderRecord")
    public String newPolicyHolderRecordForm(Map<String, Object> model) {
        PolicyHolderRecord listPolicyHolderRecord = new PolicyHolderRecord();
        model.put("policyHolderRecord", listPolicyHolderRecord);
        return "newPolicyHolderRecord";
    }
    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/savePolicyHolderRecord")
    public String savePolicyHolderRecord(@ModelAttribute("policyHolderRecord") PolicyHolderRecord policyHolderRecord) {
        policyHolderRecordService.save(policyHolderRecord);
        return "redirect:/";
    }

    //  When the path is routed to '/edit' below method to be called and view returned is editPokemon
    @RequestMapping(method = RequestMethod.GET, value = "/editPolicyHolderRecord")
    public ModelAndView editPolicyHolderRecord(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPolicyHolderRecord");
        PolicyHolderRecord policyHolderRecord = policyHolderRecordService.get(id);
        mav.addObject("policyHolderRecord", policyHolderRecord);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value ="/deletePolicyHolderRecord")
    public String deletePolicyHolderRecordForm(@RequestParam long id) {
        policyHolderRecordService.delete(id);
        return "redirect:/policeholderrecordmanage";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchPokemon
//    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicyHolderRecord")
//    public ModelAndView search(@RequestParam String keyword) {
//        List<PolicyHolderRecord> result = policyHolderRecordService.search(keyword);
//        ModelAndView mav = new ModelAndView("searchPolicyHolderRecord");
//        mav.addObject("result", result);
//        return mav;
//    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(       Date.class,
//                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy:mm:ss"), true, 10));
//    }


    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicyHolderRecord")
    public ModelAndView search(@RequestParam String policyId, String customerId, String appliedDate) {
        List<PolicyHolderRecord> result = policyHolderRecordService.search(policyId, customerId, appliedDate);
        ModelAndView mav = new ModelAndView("searchPolicyHolderRecord");
        mav.addObject("result", result);
        return mav;
    }
}
