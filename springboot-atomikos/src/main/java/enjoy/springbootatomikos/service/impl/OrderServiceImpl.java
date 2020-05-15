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

    /**
     * 重点:
     * (1)当不使用atomikos的时候@Transactional默认使用的带@Primary的事物管理器，
     *    此处使用的是test1TransactionManager, 此时只有数据源1是有事物控制的,
     *    也可以通过@Transactional(transactionManager = "test2TransactionManager")
     *    来指定使用数据源2的事务管理，此时只有数据源2是有事物控制的。
     * (2)使用atomikos的时候，直接使用@Transactional即可
     */
    @Override
    @Transactional
    public void addOrder(Orders orders, Users users) {
        usersMapper.insertSelective(users);
        int i = 10/0;
        ordersMapper.insertSelective(orders);
    }
}