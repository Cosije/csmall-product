package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;

/**
 * 处理相册数据的业务接口
 */
public interface ICategoryService {
    /**
     * 添加类别
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    /**
     * 根据id删除类别
     */
    void delete(Long id);

}
