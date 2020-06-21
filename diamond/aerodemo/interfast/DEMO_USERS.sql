--------------------------------------------------------
--  DDL for Table DEMO_USERS
--------------------------------------------------------

  CREATE TABLE "DEMO_USERS" 
   (	"USER_ID" NUMBER, 
	"USER_NAME" VARCHAR2(100), 
	"PASSWORD" VARCHAR2(4000), 
	"CREATED_ON" DATE, 
	"QUOTA" NUMBER, 
	"PRODUCTS" CHAR(1), 
	"EXPIRES_ON" DATE, 
	"ADMIN_USER" CHAR(1)
   ) ;
