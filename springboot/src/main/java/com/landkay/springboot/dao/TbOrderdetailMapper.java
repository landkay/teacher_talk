package com.landkay.springboot.dao;

import com.landkay.springboot.model.TbOrderdetail;

public interface TbOrderdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbOrderdetail record);

    int insertSelective(TbOrderdetail record);

    TbOrderdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbOrderdetail record);

    int updateByPrimaryKey(TbOrderdetail record);
}