package org.etatcivil.service;

import org.etatcivil.dao.ItemsDao;
import org.etatcivil.dao.OrdersDao;
import org.etatcivil.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component(value = "monServicePersonne")
@ViewScoped
public class MonServicePersonne implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    OrdersDao orderService;

    @Autowired
    ItemsDao itemService;

    public List<Item> findAll() {
        List<Item> results = new ArrayList<>();
        try {
            results = itemService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
