package mate.academy.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import mate.academy.cinema.dao.OrderDao;
import mate.academy.cinema.dao.ShoppingCartDao;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartDao shoppingCartDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartDao shoppingCartDao,
                            ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartDao = shoppingCartDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(List<Ticket> tickets, User user) {
        List<Ticket> newTicketsList = List.copyOf(tickets);
        Order newOrder = new Order();
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setUser(user);
        newOrder.setTickets(newTicketsList);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(newOrder);

    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
