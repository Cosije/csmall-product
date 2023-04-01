package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理相册业务的实现类
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryServiceImpl(){
        System.out.println("创建业务实现类对象：CategoryServiceImpl");
    }

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO){
        log.debug("开始处理【添加类别】的业务，参数：{}", categoryAddNewDTO);
        String name = categoryAddNewDTO.getName();
        int count = categoryMapper.countByName(name);
        if (count != 0){
            String message = "添加类别失败，尝试添加的类别名称已被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO,category);
        log.debug("即将插入类别数据：{}", category);
        categoryMapper.insert(category);

    }

    @Override
    public void delete(Long id){
        log.debug("开始处理【删除类别】的业务，参数：{}",id);
        CategoryStandardVO queryResult = categoryMapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除类别失败，尝试访问数据不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        log.debug("即将删除类别数据...");
        categoryMapper.deleteById(id);
        log.debug("删除类别完成！");
    }
}
