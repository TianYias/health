package com.tian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tian.dao.SetmealDao;
import com.tian.entity.PageResult;
import com.tian.pojo.Setmeal;
import com.tian.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealDao setmealDao;

    private void SetCheckGroupAndSetMeal(Integer SetmealId,Integer[] checkGroupIds) {
        for (Integer checkGroupId : checkGroupIds) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("setmeal_id",SetmealId);
            map.put("checkgroup_id",checkGroupId);
            setmealDao.SetCheckGroupAndSetMeal(map);
        }
    }

    @Override
    public void add(Setmeal setmeal, Integer[] checkGroupIds) {
        setmealDao.add(setmeal);
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            SetCheckGroupAndSetMeal(setmeal.getId(),checkGroupIds);
        }
    }

    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> page = setmealDao.findPage(queryString);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
