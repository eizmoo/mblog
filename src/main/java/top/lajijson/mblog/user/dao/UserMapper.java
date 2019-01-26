package top.lajijson.mblog.user.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.user.entity.User;

import java.util.Map;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int queryCountByAccount(Map<String, Object> param);
}