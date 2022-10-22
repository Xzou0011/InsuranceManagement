package com.im.controller;

import com.im.model.PolicyHolderRecord;
import com.im.service.PolicyHolderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

    @RequestMapping(method = RequestMethod.GET, value ="/newPolicyHolderRecord")
    public String newPolicyHolderRecordForm(Map<String, Object> model) {
        PolicyHolderRecord listPolicyHolderRecord = new PolicyHolderRecord();
        model.put("policyHolderRecord", listPolicyHolderRecord);
        return "newPolicyHolderRecord";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savePolicyHolderRecord")
    public String savePolicyHolderRecord(@ModelAttribute("policyHolderRecord") PolicyHolderRecord policyHolderRecord) {
        policyHolderRecordService.save(policyHolderRecord);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editPolicyHolderRecord")
    public ModelAndView editPolicyHolderRecord(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPolicyHolderRecord");
        PolicyHolderRecord policyHolderRecord = policyHolderRecordService.get(id);
        mav.addObject("policyHolderRecord", policyHolderRecord);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/deletePolicyHolderRecord")
    public String deletePolicyHolderRecordForm(@RequestParam long id) {
        policyHolderRecordService.delete(id);
        return "redirect:/policeholderrecordmanage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicyHolderRecord")
    public ModelAndView search(@RequestParam String policyId,  String customerId,  String appliedDate) {
        List<PolicyHolderRecord> result = policyHolderRecordService.search(policyId, customerId, appliedDate);
        ModelAndView mav = new ModelAndView("searchPolicyHolderRecord");
        mav.addObject("result", result);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicyHolderRecordDetail")
    public ModelAndView searchResultDetail(@RequestParam String policyId, String customerId, String appliedDate) {
        List<PolicyHolderRecord> result = policyHolderRecordService.search(policyId, customerId, appliedDate);
        ModelAndView mav = new ModelAndView("searchPolicyHolderRecordDetail");
        mav.addObject("result", result);
        return mav;
    }
}
