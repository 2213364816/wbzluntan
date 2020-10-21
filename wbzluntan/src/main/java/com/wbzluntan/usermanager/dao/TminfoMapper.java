package com.wbzluntan.usermanager.dao;

import com.wbzluntan.usermanager.entity.Tminfo;
import com.wbzluntan.usermanager.entity.TminfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TminfoMapper {
    long countByExample(TminfoExample example);

    int deleteByExample(TminfoExample example);

    int insert(Tminfo record);

    int insertSelective(Tminfo record);

    List<Tminfo> selectByExample(TminfoExample example);

    int updateByExampleSelective(@Param("record") Tminfo record, @Param("example") TminfoExample example);

    int updateByExample(@Param("record") Tminfo record, @Param("example") TminfoExample example);
}