DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) NOT NULL COMMENT '类别',
  `name` varchar(64) NOT NULL COMMENT '字典名',
  `value` varchar(64) NOT NULL COMMENT '字典值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
