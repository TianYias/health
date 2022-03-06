package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {

    /**
     * 添加检查组
     * @param checkGroup
     * @param checkItemIds
     */
    void add(CheckGroup checkGroup, Integer[] checkItemIds);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    void delete(Integer id);

    List<CheckGroup> findAll();
}
