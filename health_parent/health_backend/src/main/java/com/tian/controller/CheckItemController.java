package com.tian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tian.constant.MessageConstant;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPageBean;
import com.tian.entity.Result;
import com.tian.pojo.CheckItem;
import com.tian.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 检查项
 */

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference//在服务中心查找服务
    private CheckItemService checkItemService;

    //新增检查项
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            //新增检查项失败
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        //新增检查项成功
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    //检查项分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return checkItemService.findPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
    }

    //根据id删除检查项
    @RequestMapping("/delete")
    public Result deleteById(Integer id) {
        try {
            if (checkItemService.findCountById(id) > 0) {
                throw new RuntimeException("当前检查项被引用，不能删除");
            }
            checkItemService.deleteById(id);
        } catch (Exception e) {
            //删除检查项失败
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        //删除检查项成功
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.edit(checkItem);
        } catch (Exception e) {
            //编辑检查项失败
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        //编辑检查项成功
        return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        List<CheckItem> checkItemList;
        try {
            checkItemList = checkItemService.findAll();
        } catch (Exception e) {
            //编辑检查项失败
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
        //编辑检查项成功
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItemList);
    }
}
