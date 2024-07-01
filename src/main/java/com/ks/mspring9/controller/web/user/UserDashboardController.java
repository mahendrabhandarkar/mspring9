package com.ks.mspring9.controller.web.user;

import com.ks.mspring9.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use Ctrl + Shift + O -- For Removing Unwanted links
 */

@Controller
@RequestMapping("/web/user/dashboard")
@CrossOrigin
public class UserDashboardController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDashboardController.class);
   @GetMapping("/show")
   public ModelAndView getDashboard(ModelAndView modelAndView) {
       modelAndView.addObject("name", "Mahendra");
       modelAndView.setViewName("/my/login");
       return modelAndView;
   }
   @PostMapping("/submit")
   @ResponseBody
   public Map<String, String> submitRecord(@Validated(String.class) @ModelAttribute String str, BindingResult bindingResult) {
       Map<String, String> validationResult = new HashMap<>();
       if(bindingResult.hasErrors()) {
           validationResult.put("success", "false");
           validationResult.put("bankCode", bindingResult.hasFieldErrors("bankCode") ? bindingResult.getFieldError("bankCode").getDefaultMessage() : null);
           return validationResult;
       }
       try {
           validationResult.put("success", "true");
           validationResult.put("txnId", "1");
       }catch(Exception e) {
           validationResult.put("success" , "exception");
           validationResult.put("txnId", "NA");
           e.printStackTrace();
       }
       return validationResult;
   }
   @GetMapping("/show1")
   public ModelAndViewContainer getDashboard1() {
       return new ModelAndViewContainer();
   }

   @GetMapping("/show2")
   @ResponseBody
   public ResponseEntity<String> getDashboard2() {
       URI location = URI.create("http://localhost:8081");
       HttpHeaders responseHeaders = new HttpHeaders();
       responseHeaders.setLocation(location);
       responseHeaders.set("MyResponseHeader", "MyValue");
       return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
   }

   @GetMapping("/list")
    public String getDashboard3(Model model) {
       List<String> listStr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
       model.addAttribute("listVar", listStr);
       return "/my/list";
   }
}
