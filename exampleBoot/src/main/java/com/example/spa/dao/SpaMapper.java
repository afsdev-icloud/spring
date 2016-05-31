package com.example.spa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.spa.entity.SpaDataDto;

/**
 * 温泉情報 Mapper class
 */
@Mapper
public interface SpaMapper {

	// 登録
    void insert(SpaDataDto spaData);

    // 削除
    void delete(SpaDataDto spaData);

    // 検索
    SpaDataDto select(SpaDataDto spaData);

    // 一覧検索
    List<SpaDataDto> search(String spaGroup);

}
