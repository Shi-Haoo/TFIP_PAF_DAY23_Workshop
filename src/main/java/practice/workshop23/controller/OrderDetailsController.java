package practice.workshop23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practice.workshop23.model.OrderDetails;
import practice.workshop23.service.OrderDetailsSvc;

@Controller
@RequestMapping(path="/order")
public class OrderDetailsController {
    
    @Autowired
    OrderDetailsSvc svc;
    
    @GetMapping
    public String getIndexPg(){

        return "index";

    }

    @GetMapping(path="/total")
    public String retrieveOrderIdFromUrl(@RequestParam String id){
        return "redirect:/order/total/"+id;
    }

    @GetMapping(path="/total/{orderId}")
    public String getOrderDetailsById(@PathVariable String orderId, Model model){

        OrderDetails od = svc.getDetailByOrderId(Integer.parseInt(orderId));
        
        if(od == null){
            model.addAttribute("display", false);
            model.addAttribute("error", true);
            return "result";
        }
        System.out.println(od.toString());
        model.addAttribute("display", true);
        model.addAttribute("error", false);
        model.addAttribute("order", od);

        return "result";

    }

}
