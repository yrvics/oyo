CREATE TABLE `sys_download`
(
    `id`              bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`           varchar(50) DEFAULT NULL COMMENT '下载任务标题',
    `type`            tinyint(1)   DEFAULT NULL COMMENT '类型',
    `url`             varchar(255) DEFAULT NULL COMMENT '文件路径',
    `request_url`     varchar(255) DEFAULT NULL COMMENT '请求接口路径',
    `request_method`  tinyint(1)   DEFAULT NULL COMMENT '请求方式',
    `creator_id`      bigint(32)   DEFAULT NULL COMMENT '创建者id',
    `creator_name`    varchar(50) DEFAULT NULL COMMENT '创建者名称',
    `download_status` tinyint(1)   DEFAULT NULL COMMENT '下载状态',
    `expire_status`   tinyint(1)   DEFAULT NULL COMMENT '过期状态',
    `param_json`      json COMMENT '请求参数json',
    `request_json`    json COMMENT '请求条件json',
    `remark`          varchar(255) COMMENT '备注',
    `end_time`        datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '下载结束时间',
    `ctime`           datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `utime`           datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `module_id`       bigint(32) NOT NULL COMMENT '模块id',
    `bu_id`           bigint(32) NOT NULL COMMENT 'buId',
    `tenant_id`       bigint(32)   NOT NULL COMMENT '租户Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统下载中心表';


CREATE TABLE `currency`
(
    `id`              bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `title`           varchar(255) DEFAULT NULL COMMENT '货币名称',
    `sign`            varchar(255) DEFAULT NULL COMMENT '货币符号',
    `country_id`      bigint(32)   DEFAULT NULL COMMENT '国家id',
    `code`            varchar(255) DEFAULT NULL COMMENT '货币编码',
    `transform_value` int(10)      DEFAULT '0' COMMENT '转换值',
    `min_digit`       int(10)      DEFAULT '1' COMMENT '金额最小位数',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='货币信息';



CREATE TABLE `sys_lang`
(
    `id`   bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `code` varchar(32)  DEFAULT NULL COMMENT '编码',
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='语言';

CREATE TABLE `region_country`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`         varchar(255) DEFAULT NULL COMMENT '编号',
    `phone_number` int(11)      DEFAULT NULL COMMENT '手机区号',
    `name`         varchar(255) DEFAULT NULL COMMENT '中文名',
    `en`           varchar(255) DEFAULT NULL COMMENT '英文名',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 192
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='世界国家地区表';



CREATE TABLE `excel_template`
(
    `id`            bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `template_code` varchar(64)   DEFAULT '' COMMENT '模板编号',
    `template_name` varchar(64)   DEFAULT '' COMMENT '模板名称',
    `remark`        varchar(2550) DEFAULT '' COMMENT '备注',
    `remark_second` varchar(2550) DEFAULT '',
    `remark_third`  varchar(2550) DEFAULT '',
    `ctime`         datetime      DEFAULT CURRENT_TIMESTAMP,
    `utime`         datetime      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `bu_id`         bigint(32)    DEFAULT NULL,
    `tenant_id`     bigint(32)    DEFAULT '0' COMMENT '租户Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8mb4 COMMENT ='Excel模板表';


CREATE TABLE `excel_template_colume`
(
    `id`            bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `template_id`   bigint(32)  DEFAULT NULL COMMENT '模板id',
    `colume_code`   varchar(64) DEFAULT '' COMMENT '列字段',
    `colume_lang`   json        DEFAULT NULL COMMENT '列多语言名json数组 [{"langId":"1","langCode":"zh","columeValue":"名字"},{}]',
    `is_drop_down`  bit(1)      DEFAULT b'0' COMMENT '是否下拉',
    `is_fixed_data` bit(1)      DEFAULT b'0' COMMENT '是否固定数据',
    `dropdown_id`   bigint(32)  DEFAULT NULL COMMENT '下拉框id',
    `ctime`         datetime    DEFAULT CURRENT_TIMESTAMP,
    `utime`         datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `bu_id`         bigint(32)  DEFAULT NULL,
    `tenant_id`     bigint(32)  DEFAULT '0' COMMENT '租户Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2396
  DEFAULT CHARSET = utf8mb4 COMMENT ='Excel模板列配置表';

CREATE TABLE `excel_dropdown`
(
    `id`            bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `dropdown_code` varchar(64) DEFAULT '' COMMENT '下拉框码值',
    `dropdown_name` varchar(64) DEFAULT '' COMMENT '下拉框名称',
    `ctime`         datetime    DEFAULT CURRENT_TIMESTAMP,
    `utime`         datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `bu_id`         bigint(32)  DEFAULT NULL,
    `tenant_id`     bigint(32)  DEFAULT '0' COMMENT '租户Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8mb4 COMMENT ='下拉单元格表';


CREATE TABLE `excel_dropdown_data`
(
    `id`                  bigint(32) unsigned NOT NULL AUTO_INCREMENT,
    `dropdown_id`         bigint(32)  DEFAULT NULL COMMENT '下拉id',
    `dropdown_key`        varchar(64) DEFAULT '' COMMENT '下拉字段key',
    `dropdown_value_lang` json        DEFAULT NULL COMMENT '下拉多语言value json数组 [{"langId":"1","langCode":"zh","dropdown_value":"云南"},{}]',
    `ctime`               datetime    DEFAULT CURRENT_TIMESTAMP,
    `utime`               datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `bu_id`               bigint(32)  DEFAULT NULL,
    `tenant_id`           bigint(32)  DEFAULT '0' COMMENT '租户Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8mb4 COMMENT ='下拉数据表';



CREATE TABLE `dictionary_type`
(
    `id`               bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `name_third_lang`  varchar(255)                 DEFAULT NULL COMMENT '字典类型第三语言名称',
    `name_second_lang` varchar(255)                 DEFAULT NULL COMMENT '字典类型第二语言名称',
    `remark`           varchar(255)                 DEFAULT NULL COMMENT '字典类型备注',
    `code`             varchar(255)        NOT NULL COMMENT '字典类型编号',
    `type`             tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '0-列表；1-树状',
    `is_radio`         bit(1)              NOT NULL DEFAULT b'1' COMMENT '是否单选：0-否；1-是',
    `name`             varchar(255)                 DEFAULT NULL COMMENT '字典类型名称',
    `bu_id`            bigint(32) unsigned NOT NULL COMMENT '所属公司id',
    `tenant_id`        bigint(32) unsigned NOT NULL COMMENT '租户id',
    `ctime`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `utime`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 289
  DEFAULT CHARSET = utf8mb4 COMMENT ='数据字典类型表';

CREATE TABLE `dictionary`
(
    `id`               int(11) unsigned    NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `type_id`          bigint(32) unsigned NOT NULL COMMENT '字典类型id',
    `parent_id`        bigint(32) unsigned          DEFAULT NULL COMMENT '字典上级id',
    `value`            varchar(255)        NOT NULL COMMENT '字典值',
    `name`             varchar(255)                 DEFAULT NULL COMMENT '字典名称',
    `name_second_lang` varchar(255)                 DEFAULT NULL COMMENT '字典第二语言名称',
    `name_third_lang`  varchar(255)                 DEFAULT NULL COMMENT '字典第三语言名称',
    `bu_id`            bigint(32) unsigned NOT NULL COMMENT '所属公司id',
    `tenant_id`        bigint(32) unsigned NOT NULL COMMENT '租户id',
    `ctime`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `utime`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_type_id` (`type_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1188
  DEFAULT CHARSET = utf8mb4 COMMENT ='数据字典表';
