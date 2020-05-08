package enjoy.springbootatomikos.service.impl;

import enjoy.springbootatomikos.dao.orders.OrdersMapper;
import enjoy.springbootatomikos.dao.users.UsersMapper;
import enjoy.springbootatomikos.model.Orders;
import enjoy.springbootatomikos.model.Users;
import enjoy.springbootatomikos.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl  implements IOrderService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    @Transactional
    public void addOrder(Orders orders, Users users) {
        usersMapper.insertSelective(users);
        int i = 10/0;
        ordersMapper.insertSelective(orders);
    }
}