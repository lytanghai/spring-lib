## Project Service Gateway
** **

## Technologies
- <span style="color:#fab111">Java 11</span>
- <span style="color:#fab111">Spring Boot v2.7.18</span>
- <span style="color:#fab111">Gradle</span>
- <span style="color:#fab111">Postgresql</span>
- <span style="color:#fab111">Swagger</span>

Prerequisites

1. Create Table on Postgresql
```
CREATE TABLE IF NOT EXISTS public.url_discovery
(
    id character varying(200) COLLATE pg_catalog."default" NOT NULL DEFAULT nextval('url_discovery_id_seq'::regclass),
    url character varying(255) COLLATE pg_catalog."default" NOT NULL,
    service_name character varying(50) COLLATE pg_catalog."default",
    type character varying(10) COLLATE pg_catalog."default" NOT NULL,
    request_header character varying(255) COLLATE pg_catalog."default",
    request_payload character varying(255) COLLATE pg_catalog."default",
    method character varying(10) COLLATE pg_catalog."default" NOT NULL,
    is_available boolean NOT NULL,
    status character varying(10) COLLATE pg_catalog."default" NOT NULL,
    created_at date NOT NULL,
    last_updated_at date,
    CONSTRAINT url_gateway_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.url_discovery
    OWNER to postgres;
```
2. Create a sequence
```
CREATE SEQUENCE public.url_discovery_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9999999
    OWNED BY url_discovery.id;

ALTER SEQUENCE public.url_discovery_id_seq
    OWNER TO postgres;
```

** **Version 1.01** 

*Last Updated: 20/June/2024 4:38 PM
- [x] init repository
- [x] create discovery path [create url_discovery]