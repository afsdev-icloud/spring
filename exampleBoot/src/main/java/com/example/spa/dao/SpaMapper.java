package com.example.spa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.spa.entity.SpaDataDto;

/**
 * 温泉情報 Mapper class
 */
@Mapper
public interface SpaMapper {

	// 登録
    void insert(SpaDataDto spaData);

    // 削除
    void delete(@Param("spaGroup") String spaGroup, @Param("spaName") String spaName);

    // 検索
    SpaDataDto select(@Param("spaGroup") String spaGroup, @Param("spaName") String spaName);

    // 確認
    Integer countByKey(@Param("spaGroup") String spaGroup, @Param("spaName") String spaName);

    // 一覧検索
    List<SpaDataDto> searchByState(String stateCd);

    // 一覧検索
    List<SpaDataDto> searchByStateGroup(@Param("stateCd") String stateCd, @Param("spaGroup") String spaGroup);

}
