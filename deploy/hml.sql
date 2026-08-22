-- hml.b_in_storage definition

CREATE TABLE `b_in_storage` (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `out_storage_id` varchar(40) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `name` varchar(255) DEFAULT NULL COMMENT 'ITEM号',
  `bunch_count` decimal(10,2) DEFAULT NULL COMMENT '组件个数(记录最终的100×10的结果，1000)',
  `color` varchar(255) DEFAULT NULL COMMENT '镀金颜色',
  `bake` varchar(40) DEFAULT NULL COMMENT '烤厅',
  `in_count` varchar(255) DEFAULT NULL COMMENT '入库数量（写文字 100×10）',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `incoming_type` varchar(40) DEFAULT NULL COMMENT '来料类别',
  `bad_reason` varchar(255) DEFAULT '' COMMENT '不良原因',
  `incoming_reason` varchar(255) DEFAULT NULL COMMENT '返镀原因',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- hml.b_order definition

CREATE TABLE `b_order` (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `customer_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `image` varchar(255) DEFAULT '' COMMENT '订单图片',
  `po_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'po号',
  `item` varchar(255) DEFAULT NULL COMMENT 'item号',
  `part` varchar(255) DEFAULT NULL,
  `color` varchar(40) DEFAULT NULL COMMENT '镀金颜色',
  `bake` varchar(40) DEFAULT NULL COMMENT '烤厅',
  `count` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `part_sum_count` decimal(10,2) DEFAULT NULL COMMENT '组件总数',
  `product_no` varchar(255) DEFAULT NULL COMMENT '产品号',
  `delivery_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- hml.b_out_storage definition

CREATE TABLE `b_out_storage` (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `in_storage_id` varchar(40) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `bunch_count` decimal(10,2) DEFAULT NULL COMMENT '组件数量',
  `out_count` varchar(255) DEFAULT NULL COMMENT '出库数量',
  `out_type` varchar(10) DEFAULT NULL COMMENT '出库类型（1正常出库/2来料异常/3工作损耗）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- hml.r_role_authority definition

CREATE TABLE `r_role_authority` (
  `role_id` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `authority_id` varchar(40) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.r_user_role definition

CREATE TABLE `r_user_role` (
  `user_id` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `role_id` varchar(40) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.s_authority definition

CREATE TABLE `s_authority` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `type` int(11) DEFAULT NULL COMMENT '1-接口，2-菜单，3-按钮',
  `code` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '编码',
  `user` int(11) DEFAULT NULL COMMENT '1-本公司权限，2-客户权限',
  `is_enable` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.s_company definition

CREATE TABLE `s_company` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '编号',
  `is_enable` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.s_dict definition

CREATE TABLE `s_dict` (
  `id` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- hml.s_role definition

CREATE TABLE `s_role` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `company_id` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.s_user definition

CREATE TABLE `s_user` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `company_id` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  `account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '账户',
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '工号',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `is_lock` tinyint(1) DEFAULT NULL COMMENT '是否锁定',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- hml.b_order_group definition

CREATE TABLE `b_order_group` (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号（自动生成）',
  `customer_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `image` varchar(255) DEFAULT '' COMMENT '图片',
  `po_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'po号',
  `count` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `product_no` varchar(255) DEFAULT NULL COMMENT '产品号',
  `price` decimal(10,3) DEFAULT NULL COMMENT '单价',
  `sum` decimal(10,2) DEFAULT NULL COMMENT '总价（单价×数量自动计算）',
  `serial_no` varchar(255) DEFAULT NULL COMMENT '序号（手动输入）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 订单表增加所属订单组
ALTER TABLE `b_order` ADD COLUMN `order_group_id` varchar(40) DEFAULT NULL COMMENT '所属订单组id';


-- 订单组权限（菜单 + 接口），编码规则与现有 s_authority 保持一致
INSERT INTO `s_authority` (`id`, `name`, `type`, `code`, `user`, `is_enable`) VALUES
('ordergroup-menu-0000000000000001', '订单组管理', 2, 'M-7', 1, 1),
('ordergroup-api-00000000000000001', '订单组接口', 1, 'I-9', 1, 1);
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;s