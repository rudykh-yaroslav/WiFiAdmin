CREATE TABLE public.user
(
    id       bigint PRIMARY KEY,
    login    varchar NOT NULL,
    password varchar NOT NULL,
    token    varchar
);

CREATE TABLE public.role
(
    id   bigint PRIMARY KEY,
    name varchar NOT NULL
);

CREATE TABLE public.user_roles
(
    id      serial PRIMARY KEY,
    user_id bigint REFERENCES public.user (id),
    role_id bigint REFERENCES public.role (id)
);

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    CACHE 10;

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    CACHE 10;
