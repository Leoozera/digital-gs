
    create table gs_tb_aviso (
       id number(10,0) generated as identity,
        data timestamp(6) not null,
        dependente_id number(10,0) not null,
        usuario_id number(10,0) not null,
        vacina_id number(10,0) not null,
        primary key (id)
    );

    create table gs_tb_dependente (
       id number(10,0) generated as identity,
        data_nascimento timestamp(6) not null,
        nome varchar2(100 char) not null,
        usuario_id number(10,0),
        primary key (id)
    );

    create table gs_tb_usuario (
       id number(10,0) generated as identity,
        email varchar2(255 char),
        nome varchar2(100 char),
        senha varchar2(255 char),
        situacao varchar2(255 char),
        telefone varchar2(15 char),
        primary key (id)
    );

    create table gs_tb_vacina (
       id number(10,0) generated as identity,
        intervalo number(10,0) check (intervalo>=0),
        nome varchar2(50 char),
        primeiro_mes number(10,0) not null check (primeiro_mes>=0),
        tipo varchar2(255 char),
        primary key (id)
    );

    alter table gs_tb_usuario 
       add constraint UK_2305eo1bttl5r6esm2o80qwq unique (email);

    alter table gs_tb_aviso 
       add constraint FKqdbwfs0y4sjwkhmoqunasusm8 
       foreign key (dependente_id) 
       references gs_tb_dependente;

    alter table gs_tb_aviso 
       add constraint FK5q71sq1pk1t4vp2gqq4cb4qvf 
       foreign key (usuario_id) 
       references gs_tb_usuario;

    alter table gs_tb_aviso 
       add constraint FKryv4swqk0twdhkcvuuvqvvhpb 
       foreign key (vacina_id) 
       references gs_tb_vacina;

    alter table gs_tb_dependente 
       add constraint FKatusposswhakg1t5lwix9rpni 
       foreign key (usuario_id) 
       references gs_tb_usuario;

    create table gs_tb_aviso (
       id number(10,0) generated as identity,
        data timestamp(6) not null,
        dependente_id number(10,0) not null,
        usuario_id number(10,0) not null,
        vacina_id number(10,0) not null,
        primary key (id)
    );

    create table gs_tb_dependente (
       id number(10,0) generated as identity,
        data_nascimento timestamp(6) not null,
        nome varchar2(100 char) not null,
        usuario_id number(10,0),
        primary key (id)
    );

    create table gs_tb_usuario (
       id number(10,0) generated as identity,
        email varchar2(255 char),
        nome varchar2(100 char),
        senha varchar2(255 char),
        situacao varchar2(255 char),
        telefone varchar2(15 char),
        primary key (id)
    );

    create table gs_tb_vacina (
       id number(10,0) generated as identity,
        intervalo number(10,0) check (intervalo>=0),
        nome varchar2(50 char),
        primeiro_mes number(10,0) not null check (primeiro_mes>=0),
        tipo varchar2(255 char),
        primary key (id)
    );

    alter table gs_tb_usuario 
       add constraint UK_2305eo1bttl5r6esm2o80qwq unique (email);

    alter table gs_tb_aviso 
       add constraint FKqdbwfs0y4sjwkhmoqunasusm8 
       foreign key (dependente_id) 
       references gs_tb_dependente;

    alter table gs_tb_aviso 
       add constraint FK5q71sq1pk1t4vp2gqq4cb4qvf 
       foreign key (usuario_id) 
       references gs_tb_usuario;

    alter table gs_tb_aviso 
       add constraint FKryv4swqk0twdhkcvuuvqvvhpb 
       foreign key (vacina_id) 
       references gs_tb_vacina;

    alter table gs_tb_dependente 
       add constraint FKatusposswhakg1t5lwix9rpni 
       foreign key (usuario_id) 
       references gs_tb_usuario;

    create table GS_TB_AVISO (
       id number(10,0) generated as identity,
        data timestamp(6) not null,
        dependente_id number(10,0) not null,
        usuario_id number(10,0) not null,
        vacina_id number(10,0) not null,
        primary key (id)
    );

    create table GS_TB_DEPENDENTE (
       id number(10,0) generated as identity,
        dataNascimento timestamp(6) not null,
        nome varchar2(100 char) not null,
        usuario_id number(10,0),
        primary key (id)
    );

    create table GS_TB_USUARIO (
       id number(10,0) generated as identity,
        email varchar2(255 char),
        nome varchar2(100 char),
        senha varchar2(255 char),
        situacao varchar2(255 char),
        telefone varchar2(15 char),
        primary key (id)
    );

    create table GS_TB_VACINA (
       id number(10,0) generated as identity,
        intervalo number(10,0) check (intervalo>=0),
        nome varchar2(50 char),
        primeiroMes number(10,0) not null check (primeiroMes>=0),
        tipo varchar2(255 char),
        primary key (id)
    );

    alter table GS_TB_USUARIO 
       add constraint UK_74rvpacmhc5hnpt2d3tlgpyyk unique (email);

    alter table GS_TB_AVISO 
       add constraint FKnx1oqbdf67khv3u2vgcctsrg0 
       foreign key (dependente_id) 
       references GS_TB_DEPENDENTE;

    alter table GS_TB_AVISO 
       add constraint FKnohv99huo55w6qxe76g176y18 
       foreign key (usuario_id) 
       references GS_TB_USUARIO;

    alter table GS_TB_AVISO 
       add constraint FK7ds78qne135a3wdqveak6iip8 
       foreign key (vacina_id) 
       references GS_TB_VACINA;

    alter table GS_TB_DEPENDENTE 
       add constraint FKi7eb1vrirm9mcspodwulq4io7 
       foreign key (usuario_id) 
       references GS_TB_USUARIO;
