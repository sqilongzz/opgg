package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_equipment")
public class Equipment {
    private Long id;
    private String version;
    private String equipmentId;
    private String equipmentName;
    private String englishName;
    private String picUrl;
    private String equipmentIntroduction;
}
