package com.ks.mspring9.controller.web.admin;

import com.ks.mspring9.controller.BaseController;
import com.ks.mspring9.vo.UsersVO;
import jakarta.validation.Valid;
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
@RequestMapping("/web/admin/dashboard")
@CrossOrigin
public class AdminDashboardController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminDashboardController.class);
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

   @GetMapping("/formvalidate")
    public String showForm(Model model) {
       UsersVO usersVO = new UsersVO();
       model.addAttribute("record", usersVO);
     //  model.addAttribute("errors", bindingResult.getAllErrors());
       return "/my/htmlform";
   }

    @PostMapping("/formvalidatesubmit")
    public String addRecord(@Valid @ModelAttribute UsersVO usersVO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Add record to model with errors (for re-displaying the form)
            model.addAttribute("record", usersVO);
            model.addAttribute("errors", bindingResult.getAllErrors());
            LOGGER.info(String.valueOf(bindingResult));
            return "/my/htmlform"; // Re-render the form with validation errors
        }

    //    recordService.save(record);
        return "redirect:formvalidatelist"; // Redirect to list after successful addition
    }

    @GetMapping("/formvalidatelist")
    public String getHtmlFormList(Model model) {
        List<String> listStr = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        model.addAttribute("listVar", listStr);
        return "/my/htmlformlist";
    }
}
