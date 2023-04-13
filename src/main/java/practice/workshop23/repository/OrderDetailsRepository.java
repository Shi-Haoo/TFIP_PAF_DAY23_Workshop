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
                // if(isAllNullValues(rs))
                // return null;

                orderDeets.add(OrderDetails.createFromSQLResults(rs));
    
            } 
        
            //why is my list forever not empty??
        if(orderDeets.isEmpty()){

            System.out.println(">>>>>>>>> list is empty");
             return null;
         }
        

        return orderDeets.get(0);
    }

    // public Boolean isAllNullValues(SqlRowSet rs){

    //     boolean allNull = true;

        
    //         for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
    //             if (rs.getObject(i) != null) {
    //                 allNull = false;
    //                 break;
    //             }
    //         }
            
        
    //     if (allNull) {
    //         System.out.println("All values in the result set are null");
    //     } 

    //     return allNull;
    // }


}
