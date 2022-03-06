package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPageBean;
import com.tian.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {

    /**
     * 添加检查项
     * @param checkItem 检查项数据
     */
    void add(CheckItem checkItem);

    /**
     * 检查项分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页记录条数
     * @param queryString 查询条件
     * @return 分页结果封装对象
     */
    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    /**
     * 删除检查项
     * @param id 检查项id
     */
    void deleteById(Integer id);

    /**
     * 根据检查项id查询与检查组关联的有几条
     * @param id 检查项id
     * @return 检查项与检查组关联的条数
     */
    Integer findCountById(Integer id);

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
