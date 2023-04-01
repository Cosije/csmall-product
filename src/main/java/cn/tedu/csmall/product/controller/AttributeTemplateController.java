package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "2.属性模板管理模块")
@Validated
@RestController
@RequestMapping("/attributeTemplate")
public class AttributeTemplateController {
    @Autowired
    IAttributeTemplateService attributeTemplateService;

    // http://localhost:9080/attributeTemplate/add-new?name=001&pinyin=001&keywords=001&sort=001
    @ApiOperation("添加属性模板")
    @ApiImplicitParam(name = "id",value = "属性模板id", required = true,dataType = "long")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(@Validated AttributeTemplateAddNewDTO attributeTemplateAddNewDTO) {
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateAddNewDTO);
        attributeTemplateService.addNew(attributeTemplateAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/attributeTemplate/delete?id=13
    @ApiOperation("删除属性模板")
    @ApiImplicitParam(name = "id",value = "属性模板id", required = true,dataType = "long")
    @ApiOperationSupport(order = 200)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id){
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("查询属性模板列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<AttributeTemplateListItemVO>> list(){
        log.debug("开始处理【查询属性列表】的请求");
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }

}
