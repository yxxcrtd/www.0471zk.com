/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2012-8-23 06:23:12                           */
/*==============================================================*/


drop index "T_Category_PK";

drop table "T_Category";

drop index "T_Dict_PK";

drop table "T_Dict";

drop index "T_Link_PK";

drop table "T_Link";

drop index "T_Info_PK";

drop table "T_Product";

drop index "T_Tuan_PK";

drop table "T_Tuan";

drop index "T_User_PK";

drop table "T_User";

/*==============================================================*/
/* Table: "T_Category"                                          */
/*==============================================================*/
create table "T_Category" (
   "CategoryId"         SERIAL               not null,
   "CategoryType"       VARCHAR(15)          not null,
   "CategoryName"       VARCHAR(50)          not null,
   "CategoryParentId"   INT2                 null,
   "CategoryParentPath" VARCHAR(20)          not null default '/',
   "CategoryNumber"     INT2                 not null default 0,
   "CategoryOrder"      INT2                 not null default 0,
   constraint PK_T_CATEGORY primary key ("CategoryId")
);

/*==============================================================*/
/* Index: "T_Category_PK"                                       */
/*==============================================================*/
create unique index "T_Category_PK" on "T_Category" (
"CategoryId"
);

/*==============================================================*/
/* Table: "T_Dict"                                              */
/*==============================================================*/
create table "T_Dict" (
   "DictId"             SERIAL               not null,
   "DictKey"            VARCHAR(15)          not null,
   "DictValue"          VARCHAR(20)          not null,
   constraint PK_T_DICT primary key ("DictId")
);

/*==============================================================*/
/* Index: "T_Dict_PK"                                           */
/*==============================================================*/
create unique index "T_Dict_PK" on "T_Dict" (
"DictId"
);

/*==============================================================*/
/* Table: "T_Link"                                              */
/*==============================================================*/
create table "T_Link" (
   "LinkId"             SERIAL               not null,
   "LinkName"           VARCHAR(15)          not null,
   "LinkUrl"            VARCHAR(50)          not null,
   "LinkModified"       TIMESTAMP            not null,
   constraint PK_T_LINK primary key ("LinkId")
);

/*==============================================================*/
/* Index: "T_Link_PK"                                           */
/*==============================================================*/
create unique index "T_Link_PK" on "T_Link" (
"LinkId"
);

/*==============================================================*/
/* Table: "T_Product"                                           */
/*==============================================================*/
create table "T_Product" (
   "ProductId"          SERIAL               not null,
   "ProductName"        VARCHAR(50)          not null,
   "ProductPrice"       DECIMAL(9,2)         not null,
   "ProductOffPrice"    DECIMAL(9,2)         not null,
   "ProductDiscount"    DECIMAL(2,1)         not null,
   "ProductEconomize"   DECIMAL(9,2)         not null,
   "ProductMemberPrice" DECIMAL(9,2)         not null,
   "ProductEndTime"     DATE                 not null,
   "ProductPicture"     VARCHAR(22)          not null,
   "ProductVoucher"     VARCHAR(22)          not null,
   "ProductInstruction" VARCHAR(165)         null,
   "ProductIntroduce"   VARCHAR(300)         null,
   "ProductAddress"     VARCHAR(50)          not null,
   "ProductHit"         INT2                 not null default 0,
   "ProductStatus"      INT2                 not null default 0,
   "ProductType"        VARCHAR(15)          not null,
   "ProductCount"       INT2                 not null,
   "ProductCreateDate"  TIMESTAMP            not null,
   "ProductCategory"    INT2                 not null,
   constraint PK_T_PRODUCT primary key ("ProductId")
);

/*==============================================================*/
/* Index: "T_Info_PK"                                           */
/*==============================================================*/
create unique index "T_Info_PK" on "T_Product" (
"ProductId"
);

/*==============================================================*/
/* Table: "T_Tuan"                                              */
/*==============================================================*/
create table "T_Tuan" (
   "TuanId"             SERIAL               not null,
   "TuanPicture"        VARCHAR(22)          not null,
   "TuanName"           VARCHAR(50)          not null,
   "TuanPrice"          DECIMAL(9,2)         not null,
   "TuanOffPrice"       DECIMAL(9,2)         not null,
   "TuanDiscount"       DECIMAL(2,1)         not null,
   "TuanUrl"            VARCHAR(50)          not null,
   "TuanOperateTime"    TIMESTAMP            not null,
   constraint PK_T_TUAN primary key ("TuanId")
);

/*==============================================================*/
/* Index: "T_Tuan_PK"                                           */
/*==============================================================*/
create unique index "T_Tuan_PK" on "T_Tuan" (
"TuanId"
);

/*==============================================================*/
/* Table: "T_User"                                              */
/*==============================================================*/
create table "T_User" (
   "UserId"             SERIAL               not null,
   "Username"           VARCHAR(20)          not null,
   "UserPassword"       CHAR(32)             not null,
   "UserRole"           INT2                 not null,
   "UserEmail"          VARCHAR(20)          null,
   "UserPhone"          CHAR(11)             null,
   constraint PK_T_USER primary key ("UserId")
);

/*==============================================================*/
/* Index: "T_User_PK"                                           */
/*==============================================================*/
create unique index "T_User_PK" on "T_User" (
"UserId"
);

