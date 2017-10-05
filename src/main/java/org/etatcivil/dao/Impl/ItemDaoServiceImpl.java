package org.etatcivil.dao.Impl;


import org.apache.log4j.Logger;
import org.etatcivil.dao.ItemsDao;
import org.etatcivil.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class ItemDaoServiceImpl extends EntityDaoServiceImpl<Item> implements ItemsDao {


    @Override
    public List<Item> findAll() {
        List<Item> results = new ArrayList<>();
        try {
            results = super.findAll();
        } catch (Exception e) {
            Logger.getLogger(ItemDaoServiceImpl.class);
        }
        return results;
    }
}

