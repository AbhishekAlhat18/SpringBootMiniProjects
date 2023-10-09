package com.abhishek.mvc.ValidationDemo.Controller;

import com.abhishek.mvc.ValidationDemo.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer",new Customer());
        theModel.addAttribute("Lisa",new Customer("Lisa","Doe",3,"XYZ12"));

        String country = "United States";
        theModel.addAttribute("country",country);
        List<String> countryList = new ArrayList<>();
        countryList.add("Brazil");
        countryList.add("Russia");
        countryList.add("India");
        countryList.add("China");
        countryList.add("South Africa");
        theModel.addAttribute("items",countryList);

        return "customerForm";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute ("customer") Customer theCustomer,
                              BindingResult theBindingResult,Model theModel){
        //System.out.println("customer Name: |" +theCustomer.getLastName()+ "|");
        System.out.println("customer Name: |" +theCustomer.getLastName()+ "|");

        theModel.addAttribute("Lisa",new Customer("Lisa","Doe",3,"XYZ12"));
        Customer lisa = (Customer)theModel.getAttribute("Lisa");
        System.out.println("First Name of object Lisa: |" +lisa.getLastName()+ "|");
        System.out.println("Postal Code of object Lisa: |" +lisa.getPostalCode()+ "|");
        if (theBindingResult.hasErrors()){
            return "customerForm";

        }else{
            return "customerConfirmation";
        }

    }
}
