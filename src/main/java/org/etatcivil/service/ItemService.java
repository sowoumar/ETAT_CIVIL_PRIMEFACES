package org.etatcivil.service;


import org.apache.log4j.Logger;
import org.etatcivil.dao.ItemsDao;
import org.etatcivil.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class ItemService extends EntityService<Item> implements ItemsDao {


    @Override
    public List<Item> findAll() {
        List<Item> results = new ArrayList<>();
        try {
            results = super.findAll();
        } catch (Exception e) {
            Logger.getLogger(ItemService.class);
        }
        return results;
    }
}

