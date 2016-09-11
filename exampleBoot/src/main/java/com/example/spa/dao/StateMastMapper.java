package com.example.spa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.spa.entity.StateMastDto;

/**
 * 県名 Mapper class
 */
@Mapper
public interface StateMastMapper {

    // 県名リスト
    List<StateMastDto> stateAll();

}
