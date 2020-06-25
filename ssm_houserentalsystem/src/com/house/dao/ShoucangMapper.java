package com.house.dao;

import com.house.entity.Shoucang;
import com.house.entity.ShoucangExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoucangMapper {
    long countByExample(ShoucangExample example);

    int deleteByExample(ShoucangExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shoucang record);

    int insertSelective(Shoucang record);

    List<Shoucang> selectByExample(ShoucangExample example);

    Shoucang selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shoucang record, @Param("example") ShoucangExample example);

    int updateByExample(@Param("record") Shoucang record, @Param("example") ShoucangExample example);

    int updateByPrimaryKeySelective(Shoucang record);

    int updateByPrimaryKey(Shoucang record);
}