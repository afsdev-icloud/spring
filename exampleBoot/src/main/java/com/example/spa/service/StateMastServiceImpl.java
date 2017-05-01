package com.example.spa.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spa.dao.StatemastMapper;
import com.example.spa.entity.Statemast;
import com.example.spa.entity.StatemastExample;

@Service
@Transactional(readOnly = true)
public class StateMastServiceImpl implements StateMastService {

    private static final Logger logger = LoggerFactory.getLogger(StateMastServiceImpl.class);

    @Autowired
    private StatemastMapper statemastMapper;

    /**
     * 県名リストを取得する
     */
    public Map<String, String> getStateItems() {

        Map<String, String> items = new LinkedHashMap<String, String>();

        StatemastExample example = new StatemastExample();
        example.setOrderByClause("stateCd");

        List<Statemast> list = statemastMapper.selectByExample(example);

        for (Statemast state : list) {
            items.put(state.getStateCd(), state.getStateName());
        }

        logger.info("* getStateItems: " + items.toString());

           return items;
    }

}
