package com.tian.dao;

import com.github.pagehelper.Page;
import com.tian.entity.PageResult;
import com.tian.pojo.CheckGroup;

import java.util.List;
import java.util.Map;


public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    Page<CheckGroup> findPage(String queryString);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup);

    void deleteCheckGroupAndCheckItemById(Integer id);

    void delete(Integer id);

    List<CheckGroup> findAll();

    void setCheckGroupAndCheckItem(Map<String, Integer> map);
}
