package enjoy.springbootatomikos.service;


import enjoy.springbootatomikos.model.Orders;
import enjoy.springbootatomikos.model.Users;

public interface IOrderService {
     void addOrder(Orders orders, Users users);
}