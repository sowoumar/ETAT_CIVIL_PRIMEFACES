package org.etatcivil.dao.Impl;


import org.etatcivil.dao.UserDao;
import org.etatcivil.dto.UserDto;
import org.etatcivil.mapper.UserMapper;
import org.etatcivil.mapper.UserMapperImpl;
import org.etatcivil.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class UserDaoServiceImpl extends EntityDaoServiceImpl<User> implements UserDao {


    private UserMapper userMapper;

    @PostConstruct
    public void init() {
        this.userMapper = new UserMapperImpl();

        findUserByLoginAndPassword("oumar","sow");
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> results = new ArrayList<>();
        results = super.findAll();

        return results;
    }

    @Override
    public Long findUserByLoginAndPassword(String login, String password) {
        UserDto userDto = new UserDto();
        Long count =0L;
        try {


            Long result = (Long) getEntityManager().createNamedQuery("person.findByLoginAndPassword")
                    .setParameter("firstname", login).setParameter("name", password).getSingleResult();
            count = result;
        } catch (Exception e) {

            if (e.getMessage().equals("No entity found for query")){

            }
            System.out.println(e);
        }


        return count;

    }
}

