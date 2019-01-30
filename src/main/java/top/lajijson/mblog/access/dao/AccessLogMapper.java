package top.lajijson.mblog.access.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.access.entity.AccessLog;

@Component
public interface AccessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccessLog record);

    int insertSelective(AccessLog record);

    AccessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccessLog record);

    int updateByPrimaryKey(AccessLog record);
}