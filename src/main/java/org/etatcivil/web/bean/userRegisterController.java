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
public class userRegisterController implements Serializable {

    @Autowired
    private UserService userService;

    private UserLoginBean userLoginBean = new UserLoginBean();

    public Long checkAuthenfication(String username, String password) {
        return userService.checkAuthenfication(username, password);
    }

    public String create() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String navigation = "";

        Long result = checkAuthenfication(userLoginBean.getUserDto().getFirstname(), userLoginBean.getUserDto().getName());
        if (result == 0) {
            userService.createUser(userLoginBean.getUserDto());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", userLoginBean.getUsername());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Le login et le mot de passe sont dèja utilisé", "Impossible de créér cet utilisateur");
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