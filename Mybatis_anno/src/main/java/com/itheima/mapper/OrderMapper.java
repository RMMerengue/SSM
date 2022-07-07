package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
//    @Select("select *,o.id oid from orders o, users where o.uid=u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "name", property = "user.name"),
//            @Result(column = "pwd", property = "user.pwd")
//    })
//    public List<Order> findAll();

    @Select("select *,o.id oid from orders o, users where o.uid=u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",//要封装的属性名臣
                    column = "uid",//根据哪个字段去查询user表的数据
                    javaType = User.class,//要封装的实体类型
                    //select属性 代表查询那个接口的方法获得数据
                    one = @One(select = "com.itheima.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();
}
