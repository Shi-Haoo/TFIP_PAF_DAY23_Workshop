package practice.workshop23.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OrderDetails {
    
    private int orderId;
    private DateTime orderDate;
    private Integer customerId;
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalDiscountedPrice;
    private Double totalCostPrice;
    
    public OrderDetails() {
    }

    public OrderDetails(int orderId, DateTime orderDate, Integer customerId, Double totalPrice, Double totalDiscount,
            Double totalDiscountedPrice, Double totalCostPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.totalCostPrice = totalCostPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(Double totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }

    public Double getTotalCostPrice() {
        return totalCostPrice;
    }

    public void setTotalCostPrice(Double totalCostPrice) {
        this.totalCostPrice = totalCostPrice;
    }



    @Override
    public String toString() {
        return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
                + ", totalPrice=" + totalPrice + ", totalDiscount=" + totalDiscount + ", totalDiscountedPrice="
                + totalDiscountedPrice + ", totalCostPrice=" + totalCostPrice + "]";
    }



    public static OrderDetails createFromSQLResults(SqlRowSet rs){

        OrderDetails od = new OrderDetails();

        od.setOrderId(rs.getInt("order_id"));

        if(rs.getString("order_date") != null){
            od.setOrderDate(convertToDateTime(rs.getString("order_date")));
        }
        
        od.setCustomerId(rs.getInt("customer_id"));
        od.setTotalPrice(rs.getDouble("total_price"));
        od.setTotalDiscount(rs.getDouble("discount"));
        od.setTotalDiscountedPrice(rs.getDouble("discounted_price"));
        od.setTotalCostPrice(rs.getDouble("cost_price"));

        return od;

    }


    public static DateTime convertToDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dateConverted = formatter.parseDateTime(date);
        return dateConverted;
    }

    

    



    

}
