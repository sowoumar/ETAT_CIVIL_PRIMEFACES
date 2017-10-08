package org.etatcivil.web.bean;

import org.etatcivil.dto.UserDto;
import org.etatcivil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;


@Component
@ViewScoped
public class UserController implements Serializable {

    @Autowired
    private UserService userService;

    private UserDto userDto = new UserDto();
    private FacesMessage message;

    public UserService getUserService() {

        return userService;
    }

    public void save(ActionEvent event) {

        boolean result = userService.createUser(userDto);
        if (result) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "L'utisateur", userDto.getFirstname() + " " + userDto.getName() + " " + " " + " a été créé avec succès");
        }else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "L'utisateur", userDto.getFirstname() + " " + userDto.getName() + " " + " " + " existe déjà!!!");

        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}