-- 1.版本对比

CREATE TABLE tb_hero(
                        `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
                        `VERSION` VARCHAR(10) NULL COMMENT '版本',
                        `HERO_ID` VARCHAR(20) NULL COMMENT '英雄版本id',
                        `HERO_NAME` VARCHAR(20) NULL COMMENT '英雄名称',
                        `ENGLISH_NAME` VARCHAR(20) NULL COMMENT '英文名',
                        `PIC_URL` VARCHAR(255) NULL COMMENT '英雄头像图片路径',
                        `HERO_PASSIVE_SKILLS` VARCHAR(200) NULL COMMENT '英雄被动技能',
                        `HERO_SKILLS_Q` VARCHAR(200) NULL COMMENT '英雄技能 Q',
                        `HERO_SKILLS_W` VARCHAR(200) NULL COMMENT '英雄技能 W',
                        `HERO_SKILLS_E` VARCHAR(200) NULL COMMENT '英雄技能 E',
                        `HERO_SKILLS_R` VARCHAR(200) NULL COMMENT '英雄技能 R',
                        PRIMARY KEY (ID)
)ENGINE INNODB COMMENT='版本英雄表';

CREATE TABLE tb_version_info(
                                `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
                                `VERSION` VARCHAR(10) NULL COMMENT '版本',
                                `HERO_ID` VARCHAR(20) NULL COMMENT '英雄版本id',
                                `EQUIPMENT_ID` VARCHAR(20) NULL COMMENT '装备版本id',
                                `RANK_LEVEL` VARCHAR(20) NULL COMMENT '段位-枚举',
                                `STRENGTH` VARCHAR(10) NULL COMMENT '强度-枚举',
                                `HERO_POSITITON` VARCHAR(20) NULL COMMENT '分路-枚举',
                                `WIN_RATE` VARCHAR(20) NULL COMMENT '胜率',
                                `APPEARANCE_RATE` VARCHAR(20) COMMENT '登场率',
                                `BAN_RATE` VARCHAR(20) NULL COMMENT '禁用率',
                                `ADVANTEGE_AGAINST` VARCHAR(20) NULL COMMENT '优势对抗',
                                `INFERIORITY_AGAINST` VARCHAR(20) NULL COMMENT '劣势对抗',
                                PRIMARY KEY (ID)
)ENGINE INNODB COMMENT='版本信息表';

CREATE TABLE tb_equipment(
                             `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
                             `VERSION` VARCHAR(10) NULL COMMENT '版本',
                             `EQUIPMENT_ID` VARCHAR(20) NULL COMMENT '装备版本id',
                             `EQUIPMENT_NAME` VARCHAR(20) NULL COMMENT '装备名称',
                             `ENGLISH_NAME` VARCHAR(20) NULL COMMENT '装备英文名',
                             `PIC_URL` VARCHAR(255) NULL COMMENT '装备图片路径',
                             `EQUIPMENT_INTRODUCTION` VARCHAR(255) NULL COMMENT '装备介绍',
                             PRIMARY KEY (ID)
)ENGINE INNODB COMMENT='版本装备表';