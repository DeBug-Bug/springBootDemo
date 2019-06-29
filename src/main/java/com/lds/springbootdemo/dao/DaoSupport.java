package com.lds.springbootdemo.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springbootdemo
 * @description:
 * @author:
 * @createData:
 * @updateAuthor:
 * @updateData:
 * @updateContent:
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */
/*
注解了@Repository的类上如果数据库操作中抛出了异常，就能对其进行处理，
转而抛出的是翻译后的spring专属数据库异常，方便我们对异常进行排查处理）。
 */
@Repository
/*
加入 @Transactional 注解，使用默认配置，抛出异常之后，事务会自动回滚，数据不会插入到数据库。
 */
@Transactional
public class DaoSupport implements Dao {

    /**
     * @Autowired默认按类型装配（这个注解是属于spring的），
     * 默认情况下必须要求依赖对象必须存在，如果要允许null值，
     * 可以设置它的required属性为false，如：@Autowired(required=false) ，
     * 如果我们想使用名称装配可以结合@Qualifier注解进行使用 @Autowired()@Qualifier("baseDao")
     * @Resource（这个注解属于J2EE的），默认按照名称进行装配，名称可以通过name属性进行指定，
     * 如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找，
     * 如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。
     * 但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchSave(String str, List objs)throws Exception{
        return sqlSessionTemplate.insert(str, objs);
    }

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public void batchUpdate(String str, List objs)throws Exception{
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        try{
            if(objs!=null){
                for(int i=0,size=objs.size();i<size;i++){
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }finally{
            sqlSession.close();
        }
    }
    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str, obj);
    }
    /**
     * 批量删除
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchDelete(String str, List objs )throws Exception{
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 查找返回一个对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object selectForOne(String str, Object obj){
        return sqlSessionTemplate.selectOne(str, obj);
    }
    /**
     * 查找返回多个对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object selectForList(String str, Object obj){
        return sqlSessionTemplate.selectList(str, obj);
    }
}
