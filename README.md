
In Controller:

@GetMapping(path="/total")
    public String retrieveOrderIdFromUrl(@RequestParam String id){
        return "redirect:/order/total/"+id;
    }

Need this extra @GetMapping to redirect to @GetMapping(path="/total/{orderId})

We cant omit the extra @GetMapping and head straight to @GetMapping(path="/total/{orderId}) because when we make a GET request (i.e from html form), the orderId will be a query string in the url. So the url will be ../order/total?id=1 if we input order id as 1 in form. So we cant retrieve it using @PathVariable which is what the question asked for. 
(i.e /order/id/{orderId}). So we need this extra @GetMapping to retrieve id using @RequestParam and then redirect with the retrieved order id return 
(i.e "redirect:/order/total/"+id;)



