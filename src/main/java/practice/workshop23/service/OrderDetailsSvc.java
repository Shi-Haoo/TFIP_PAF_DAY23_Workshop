package practice.workshop23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.workshop23.model.OrderDetails;
import practice.workshop23.repository.OrderDetailsRepository;

@Service
public class OrderDetailsSvc {
    
    @Autowired
    OrderDetailsRepository repo;

    public OrderDetails getDetailByOrderId(int orderId){
        
       return repo.getDetailByOrderId(orderId);

    }
}
