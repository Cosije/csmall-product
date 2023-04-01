package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SkuSpecification;
import org.springframework.stereotype.Repository;


/**
 * 处理SKU数据数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface SkuSpecificationMapper {

    /**
     * 插入SKU数据数据
     *
     * @param skuSpecification SKU数据数据
     * @return 受影响的行数
     */
    int insert(SkuSpecification skuSpecification);


}
