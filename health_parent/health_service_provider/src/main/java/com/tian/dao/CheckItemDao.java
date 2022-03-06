package com.tian.dao;

import com.github.pagehelper.Page;
import com.tian.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {

    /**
     * 添加检查项
     * @param checkItem 检查项数据
     */
    void add(CheckItem checkItem);

    /**
     * 按条件查询检查项
     * @param queryString 查询条件
     * @return 查询到的检查项
     */
    Page<CheckItem> selectByCondition(String queryString);

    /**
     * 根据检查项id查询与检查组关联的有几条
     * @param id 检查项id
     * @return 检查项与检查组关联的条数
     */
    Integer findCountById(Integer id);

    /**
     * 根据id删除检查项
     * @param id 检查项id
     */
    void deleteById(Integer id);

    /**
     * 修改检查项
     * @param checkItem 检查项数据
     */
    void edit(CheckItem checkItem);

    /**
     * 查询所有检查项
     * @return
     */
    List<CheckItem> findAll();
}
