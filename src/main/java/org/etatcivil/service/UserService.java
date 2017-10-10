package org.etatcivil.service;

import org.etatcivil.dao.ItemsDao;
import org.etatcivil.dao.OrdersDao;
import org.etatcivil.dao.UserDao;
import org.etatcivil.dto.UserDto;
import org.etatcivil.mapper.UserMapper;
import org.etatcivil.mapper.UserMapperImpl;
import org.etatcivil.model.Item;
import org.etatcivil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
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

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserService() {
        this.userMapper = new UserMapperImpl();
    }

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

    public boolean createUser(UserDto userDto) {
        boolean result = false;
        Long isUserExist = checkAuthenfication(userDto.getFirstname(), userDto.getName());

        if (isUserExist == 0) {
            try {
                userDao.persist(userMapper.userDtoToUser(userDto));
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
