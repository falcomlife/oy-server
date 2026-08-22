-- 2026-08 需求变更增量脚本：在已有数据库上执行
-- 1. 订单表（b_order）：增加产品号，删除单价/合计（单价移到订单上）
ALTER TABLE `b_order` ADD COLUMN `product_no` varchar(255) DEFAULT NULL COMMENT '产品号';
ALTER TABLE `b_order` DROP COLUMN `price`;
ALTER TABLE `b_order` DROP COLUMN `sum`;

-- 2. 订单组表（b_order_group）：增加产品号、单价、总价、序号
ALTER TABLE `b_order_group` ADD COLUMN `product_no` varchar(255) DEFAULT NULL COMMENT '产品号';
ALTER TABLE `b_order_group` ADD COLUMN `price` decimal(10,3) DEFAULT NULL COMMENT '单价';
ALTER TABLE `b_order_group` ADD COLUMN `sum` decimal(10,2) DEFAULT NULL COMMENT '总价（单价×数量自动计算）';
ALTER TABLE `b_order_group` ADD COLUMN `serial_no` varchar(255) DEFAULT NULL COMMENT '序号（手动输入）';
