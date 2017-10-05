package org.etatcivil.dao;

import org.etatcivil.dto.UserDto;
import org.etatcivil.model.User;


public interface UserDao extends EntityDao<User> {

    Long findUserByLoginAndPassword(String login, String password);

}
