package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;

import java.util.List;

/**
 * 处理品牌数据的业务接口
 */
public interface IBrandService {
    /**
     * 添加品牌
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     * 根据id删除品牌
     */
    void delete(Long id);

    /**
     * 查询品牌列表
     */
    List<BrandListItemVO> list();

}
