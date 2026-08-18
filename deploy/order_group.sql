-- 订单组功能增量脚本：在已有数据库上执行
-- 1. 订单组表
CREATE TABLE `b_order_group` (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '编号（自动生成）',
  `customer_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `image` varchar(255) DEFAULT '' COMMENT '图片',
  `po_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'po号',
  `count` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2. 订单表增加所属订单组
ALTER TABLE `b_order` ADD COLUMN `order_group_id` varchar(40) DEFAULT NULL COMMENT '所属订单组id';

-- 3. 订单组权限（菜单 + 接口）
INSERT INTO `s_authority` (`id`, `name`, `type`, `code`, `user`, `is_enable`) VALUES
('ordergroup-menu-0000000000000001', '订单组管理', 2, 'M-7', 1, 1),
('ordergroup-api-00000000000000001', '订单组接口', 1, 'I-9', 1, 1);

-- 4. 给角色授权（将 <role_id> 替换为需要开放订单组页面的角色id，可多行）
-- INSERT INTO `r_role_authority` (`role_id`, `authority_id`) VALUES
-- ('<role_id>', 'ordergroup-menu-0000000000000001'),
-- ('<role_id>', 'ordergroup-api-00000000000000001');
