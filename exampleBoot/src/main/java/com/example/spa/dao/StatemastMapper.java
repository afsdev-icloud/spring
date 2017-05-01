package com.example.spa.dao;

import com.example.spa.entity.Statemast;
import com.example.spa.entity.StatemastExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatemastMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    int deleteByExample(StatemastExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    int insert(Statemast record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    int insertSelective(Statemast record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    List<Statemast> selectByExample(StatemastExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Statemast record, @Param("example") StatemastExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stateMast
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Statemast record, @Param("example") StatemastExample example);
}
