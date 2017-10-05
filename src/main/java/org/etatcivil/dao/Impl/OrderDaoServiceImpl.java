package org.etatcivil.dao.Impl;

import org.etatcivil.model.Order;
import org.etatcivil.dao.OrdersDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderDaoServiceImpl extends EntityDaoServiceImpl<Order> implements OrdersDao {

}
