package com.example.spa.service;

import java.util.Map;

public interface StateMastService {

    /**
     * 県名リストを取得する
     *
     * @return 県名リスト
     */
	public Map<String, String> getStateItems();

}
