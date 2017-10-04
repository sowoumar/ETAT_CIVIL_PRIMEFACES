package org.etatcivil.service;


import org.etatcivil.dao.UserDao;
import org.etatcivil.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class UserService extends EntityService<User> implements UserDao {
    @Override
    public List<User> findAll() throws Exception {
        List<User> results = new ArrayList<>();
        results = super.findAll();
        return results;
    }
}

