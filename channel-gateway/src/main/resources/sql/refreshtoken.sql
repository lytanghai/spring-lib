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

 Date: 19/06/2024 23:15:13
*/


-- ----------------------------
-- Table structure for refreshtoken
-- ----------------------------
DROP TABLE IF EXISTS "public"."refreshtoken";
CREATE TABLE "public"."refreshtoken" (
  "id" int2 NOT NULL DEFAULT nextval('refreshtoken_id_seq'::regclass),
  "user_id" int4 NOT NULL,
  "token" text COLLATE "pg_catalog"."default" NOT NULL,
  "expiry_date" date NOT NULL
)
;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."roles";
CREATE TABLE "public"."roles" (
  "id" int4 NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_roles";
CREATE TABLE "public"."user_roles" (
  "user_id" int4 NOT NULL,
  "role_id" int4 NOT NULL
)
;

-- ----------------------------
-- Primary Key structure for table refreshtoken
-- ----------------------------
ALTER TABLE "public"."refreshtoken" ADD CONSTRAINT "refreshtoken_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE "public"."roles" ADD CONSTRAINT "roles_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_roles
-- ----------------------------
ALTER TABLE "public"."user_roles" ADD CONSTRAINT "user_roles_pkey" PRIMARY KEY ("user_id", "role_id");
