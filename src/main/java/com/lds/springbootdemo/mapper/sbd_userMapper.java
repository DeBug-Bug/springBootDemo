package com.lds.springbootdemo.mapper;

import com.lds.springbootdemo.domain.sbd_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface sbd_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sbd_user record);

    int insertSelective(sbd_user record);

    sbd_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sbd_user record);

    int updateByPrimaryKey(sbd_user record);
    /**
     * 根据账号返回实体
     * @param account
     * @return
     */
    //sql语句直接写在方法的上面
    //@Select("select * from sbd_user where account=#{account}")
    sbd_user selectByAccount(String account);
}