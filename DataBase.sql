PGDMP         !                {            userv2    15.2    15.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16606    userv2    DATABASE     �   CREATE DATABASE userv2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE userv2;
                postgres    false            �            1259    16614    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16607    usuario    TABLE     G  CREATE TABLE public.usuario (
    id bigint NOT NULL,
    apellido character varying(255),
    correo character varying(255),
    direccion character varying(255),
    fecha_de_nacimiento character varying(255),
    mobile_phone character varying(255),
    nombre character varying(255),
    password character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �          0    16607    usuario 
   TABLE DATA           w   COPY public.usuario (id, apellido, correo, direccion, fecha_de_nacimiento, mobile_phone, nombre, password) FROM stdin;
    public          postgres    false    214   Z	       �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);
          public          postgres    false    215            f           2606    16613    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    214            �   �   x�E�Mo�0 ��s�83�R;nV�����l�]*4P(`:J�~jfL����$?���N����J{Y׀Ph��r�*��]�a� �͍�..��6L�q:{�4a�ǔiKW�ՁDkݍQS����p�
�T�tE�B��h7��+�^�*۪;�\���e����N�۴�׋���=Q����|�-3��Dmߦ�Tee�7;4|��8�:ߞ�8@vP�     