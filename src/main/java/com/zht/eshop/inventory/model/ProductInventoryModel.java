package com.zht.eshop.inventory.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//标记表名(此注解为必须，下面的字段注解可选)
@TableName("productInventory")
public class ProductInventoryModel {
    /**
     * 商品id
     */
    @TableId(value = "productId", type = IdType.INPUT)
    private Integer productId;
    /**
     * 库存数量
     */
    @TableField("inventoryCnt")
    private Long inventoryCnt;
}
