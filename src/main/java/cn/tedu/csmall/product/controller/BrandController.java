package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "3.品牌管理模块")
@Validated
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    IBrandService brandService;

    public BrandController(){
        System.out.println("创建控制器类对象：BrandController");
    }
//http://localhost:8080/brand/add-new?name=TestName001&pinyin=TestName001&sort=77
    @ApiOperation("添加品牌")
    @ApiImplicitParam(name = "id",value = "品牌id", required = true,dataType = "long")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(@Validated BrandAddNewDTO brandAddNewDTO){
        log.debug("开始处理【添加品牌】的请求，参数：{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:8080/brand/delete?id=24
    @ApiOperation("删除品牌")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id){
        log.debug("开始处理【删除品牌】的请求，参数：{}", id);
        brandService.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<BrandListItemVO>> list(){
        log.debug("开始处理【查询相册列表】的请求");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }
}
