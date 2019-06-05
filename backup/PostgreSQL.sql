-- 发布系统的 PostgreSQL 数据库脚本
-- Yang XinXin
-- @2012-02-28


--------------------------------------创建：登录角色、数据库 和 hibernate序列--------------------------------------
-- 1，创建：登录角色
-- DROP ROLE "Pub";
CREATE ROLE "Pub" LOGIN ENCRYPTED PASSWORD 'md5839e3978a87c670a23975e9c3db89632'	-- 密码：Pub
   VALID UNTIL 'infinity';

-- 2，创建：数据库: "Pub"
-- DROP DATABASE "Pub";
-- For Windows:
CREATE DATABASE "Pub"
  WITH OWNER = "Pub"
       ENCODING = 'UTF8'
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;

-- For Linux:
CREATE DATABASE "Pub"
  WITH OWNER = "Pub"
       ENCODING = 'UTF8'
       LC_COLLATE = 'zh_CN.UTF-8'
       LC_CTYPE = 'zh_CN.UTF-8'
       CONNECTION LIMIT = -1;


-- 3，创建：序列（PostgreSQL 默认不支持 hibernate 自增长，会报错：hibernate_sequence 不存在。）
-- DROP SEQUENCE hibernate_sequence;
CREATE SEQUENCE hibernate_sequence
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1;

-- 更改所有者
ALTER TABLE hibernate_sequence OWNER TO "Pub";


--------------------------------------插入数据--------------------------------------
-- 1，T_User
INSERT INTO "T_User" ("Username", "UserPassword", "UserRole", "UserEmail") 
VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', '1', 'admin@0471zk.com');


-- 2，T_Category
INSERT INTO "T_Category" ("CategoryType", "CategoryName", "CategoryOrder") VALUES 
('house', '家居建材', '1'),
('food', '餐饮美食', '2'),
('fun', '休闲娱乐', '3'),
('travel', '出行旅游', '4'),
('celebration', '庆典礼仪', '5'),
('education', '教育培训', '6'),
('medical', '寻医问诊', '7'),
('gift', '烟酒礼品', '8');


