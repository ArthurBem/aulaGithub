package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();


    public Order(){

    }


    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public Date getMoment() {
        return moment;
    }


    public void setMoment(Date moment) {
        this.moment = moment;
    }


    public OrderStatus getStatus() {
        return status;
    }


    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public Double total(){
        double sum = 0.0;
        for (OrderItem it : orderItems) {
			sum += it.subTotal();
		}
		return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order Status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append( client + "\n");
        sb.append("Order Items: ");
        for(OrderItem orderItem : orderItems){
            sb.append(orderItem + "\n");
        }
        sb.append("Total Price: ");
        sb.append(String.format("%.2f",total()));
        return sb.toString();
    }
    
}
