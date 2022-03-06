package com.tian.dao;

import com.github.pagehelper.Page;
import com.tian.pojo.Setmeal;

import java.util.HashMap;

public interface SetmealDao {
    void add(Setmeal setmeal);

    void SetCheckGroupAndSetMeal(HashMap<String, Integer> map);

    Page<Setmeal> findPage(String queryString);
}
