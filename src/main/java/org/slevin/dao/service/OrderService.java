package org.slevin.dao.service;

import java.util.List;

import javax.persistence.Query;

import org.slevin.common.Item;
import org.slevin.common.Order;
import org.slevin.dao.OrdersDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderService extends EntityService<Order> implements OrdersDao {

}
