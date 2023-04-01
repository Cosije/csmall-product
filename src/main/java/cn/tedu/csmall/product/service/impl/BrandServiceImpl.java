package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理品牌业务的实现类
 */
@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    BrandMapper brandMapper;

    public BrandServiceImpl(){
        System.out.println("创建业务实现类对象：BrandServiceImpl");
    }

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO){
        log.debug("开始处理【添加品牌】的业务，参数：{}", brandAddNewDTO);
        String name = brandAddNewDTO.getName();
        int count = brandMapper.countByName(name);
        if (count != 0){
            String message = "添加品牌失败，尝试添加的品牌名称已被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO,brand);
        log.debug("即将插入品牌数据：{}", brand);
        brandMapper.insert(brand);

    }

    @Override
    public void delete(Long id){
        log.debug("开始处理【删除品牌】的业务，参数：{}",id);
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除品牌失败，尝试访问数据不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        log.debug("即将删除品牌数据...");
        brandMapper.deleteById(id);
        log.debug("删除品牌完成！");
    }

    @Override
    public List<BrandListItemVO> list(){
        log.debug("开始处理【查询品牌列表】的业务");
        return brandMapper.list();
    }
}
