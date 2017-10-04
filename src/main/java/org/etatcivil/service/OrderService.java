package org.etatcivil.service;

import org.etatcivil.model.Order;
import org.etatcivil.dao.OrdersDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderService extends EntityService<Order> implements OrdersDao {

}
