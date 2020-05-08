package enjoy.springbootatomikos.controller;

import enjoy.springbootatomikos.model.Orders;
import enjoy.springbootatomikos.model.Users;
import enjoy.springbootatomikos.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class UOContnroller {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/test")
    public String testLoad(){
        Users users = new Users();
        users.setUsername("enjoy");
        users.setPasswd("123");
        users.setId(1);


        Orders orders = new Orders();
        orders.setAccount(12);
        orders.setName("娃娃");
        orders.setUserId(1);
        iOrderService.addOrder(orders,users);
        return "1";
    }
}
