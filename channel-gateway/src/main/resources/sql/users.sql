/*
 Navicat Premium Data Transfer

 Source Server         : postgresql
 Source Server Type    : PostgreSQL
 Source Server Version : 120015
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120015
 File Encoding         : 65001

 Date: 19/06/2024 23:14:39
*/


-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "username" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(150) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(150) COLLATE "pg_catalog"."default" NOT NULL,
  "id" int2 NOT NULL DEFAULT nextval('users_id_seq1'::regclass)
)
;

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");
