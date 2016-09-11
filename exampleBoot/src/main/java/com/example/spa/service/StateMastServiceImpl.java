package com.example.spa.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spa.dao.StateMastMapper;
import com.example.spa.entity.StateMastDto;

@Service
@Transactional(readOnly = true)
public class StateMastServiceImpl implements StateMastService {

    private static final Logger logger = LoggerFactory.getLogger(StateMastServiceImpl.class);

    @Autowired
    private StateMastMapper stateMapper;

    /**
     * 県名リストを取得する
     */
	public Map<String, String> getStateItems() {

        Map<String, String> items = new LinkedHashMap<String, String>();

        List<StateMastDto> stateMast = stateMapper.stateAll();

        for (StateMastDto state : stateMast) {
        	items.put(state.getStateCd(), state.getStateName());
        }

        logger.info("* getStateItems: " + items.toString());

	    return items;
	}

}
