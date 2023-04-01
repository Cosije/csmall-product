package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Sku;
import org.springframework.stereotype.Repository;


/**
 * 处理SKU数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface SkuMapper {

    /**
     * 插入SKU数据
     *
     * @param sku SKU数据
     * @return 受影响的行数
     */
    int insert(Sku sku);
}
