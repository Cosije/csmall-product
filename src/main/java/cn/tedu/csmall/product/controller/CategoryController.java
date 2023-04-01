package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    public CategoryController(){
        System.out.println("创建控制器类对象：ICategoryService");
    }
//http://localhost:9080/category/add-new?name=TestName003&sort=33
    @RequestMapping("/add-new")
    public JsonResult addNew(@RequestBody CategoryAddNewDTO categoryAddNewDTO){
        log.debug("开始处理【添加类别】的请求，参数：{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/category/delete?id=74
    @RequestMapping("/delete")
    public JsonResult delete(@RequestBody Long id){
        log.debug("开始处理【删除类别】的请求，参数：{}", id);
        categoryService.delete(id);
        return JsonResult.ok();
    }
}
