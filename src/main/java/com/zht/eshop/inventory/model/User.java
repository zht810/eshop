package com.zht.eshop.inventory.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//标记表名(此注解为必须，下面的字段注解可选)
@TableName("user")
public class User {
    //标记数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 测试用户姓名
     */
    @TableField("name")
    private String name;
    /**
     * 测试用户年龄
     */
    @TableField("age")
    private Integer age;


}
