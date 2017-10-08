package org.etatcivil.web.bean;

import org.etatcivil.service.UserService;
import org.etatcivil.web.controller.UserLoginBean;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@Component
@ViewScoped
public class UserLoginController implements Serializable {

    @Autowired
    private UserService userService;

    private UserLoginBean userLoginBean = new UserLoginBean();

    public Long checkAuthenfication(String username, String password) {
        return userService.checkAuthenfication(username, password);
    }

    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String navigation = "";

        Long result = checkAuthenfication(userLoginBean.getUsername(), userLoginBean.getPassword());
        if (result == 1) {
            navigation = "menu";
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue", userLoginBean.getUsername());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Login ou Mot de passe incorrect");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);

        return navigation;
    }

    public UserLoginBean getUserLoginBean() {
        return userLoginBean;
    }

    public void setUserLoginBean(UserLoginBean userLoginBean) {
        this.userLoginBean = userLoginBean;
    }

    public UserService getUserService() {

        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}