package org.etatcivil.service;

import org.etatcivil.dao.ItemsDao;
import org.etatcivil.dao.OrdersDao;
import org.etatcivil.dao.UserDao;
import org.etatcivil.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private OrdersDao orderService;

    @Autowired
    private ItemsDao itemService;

    @Autowired
    private UserDao userDao;



    public List<Item> findAll() {
        List<Item> results = new ArrayList<>();
        try {
            results = itemService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public Long checkAuthenfication(String username, String password) {
        return userDao.findUserByLoginAndPassword(username, password);

    }

    public OrdersDao getOrderService() {
        return orderService;
    }

    public void setOrderService(OrdersDao orderService) {
        this.orderService = orderService;
    }

    public ItemsDao getItemService() {
        return itemService;
    }

    public void setItemService(ItemsDao itemService) {
        this.itemService = itemService;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
