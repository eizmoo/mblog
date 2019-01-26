package top.lajijson.mblog.access.dao;

import top.lajijson.mblog.access.entity.ReadLog;

public interface ReadLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReadLog record);

    int insertSelective(ReadLog record);

    ReadLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReadLog record);

    int updateByPrimaryKey(ReadLog record);
}