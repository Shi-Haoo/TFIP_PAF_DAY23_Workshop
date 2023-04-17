package practice.workshop23.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import practice.workshop23.model.OrderDetails;

import static practice.workshop23.repository.DBQueries.*;

@Repository
public class OrderDetailsRepository {
    
    @Autowired
    JdbcTemplate template;

    public OrderDetails getDetailByOrderId(int orderId){
        
        List<OrderDetails> orderDeets = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(RETRIEVE_ORDER_DETAILS_BY_ORDER_ID, orderId);
        System.out.println("SQL result set: " + rs);

        while(rs.next()){

            /* 
            Q: why is my list forever not empty aka orderDeets.isEmpty() always false??
            
            Ans: 
            When we search for order_id that does not exist in record, sql will return null values
            for all the fields including order_id. So while(rs.next()) is true even when order_id 
            cannot be found in record. => List will never be empty unless we add an if(rs.getInt("order_id") != 0).
            order_id will be returned as 0 if it is null. So this help to prevent rs which contains non existent order_id
            from being added to list. 
            Without if condition, list will not be empty and thymeleaf will throw an error because 
            it cannot parse null values*/

            if(rs.getInt("order_id") != 0)
            orderDeets.add(OrderDetails.createFromSQLResults(rs));
    
            } 
        
            
        if(orderDeets.isEmpty()){

            System.out.println(">>>>>>>>> list is empty");
             return null;
         }
        

        return orderDeets.get(0);
    }
}
