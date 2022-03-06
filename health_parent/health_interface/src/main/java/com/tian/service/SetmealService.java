package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.Result;
import com.tian.pojo.Setmeal;

import java.util.List;

public interface SetmealService {
    void add(Setmeal setmeal, Integer[] checkGroupIds);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);
}
