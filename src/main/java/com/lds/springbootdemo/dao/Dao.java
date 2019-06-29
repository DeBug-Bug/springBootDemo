package com.lds.springbootdemo.dao;

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


public interface Dao {
    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception;

    /**
     * 查找返回一个对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object selectForOne(String str, Object obj) throws Exception;
    /**
     * 查找返回多个对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object selectForList(String str, Object obj) throws Exception;

}
