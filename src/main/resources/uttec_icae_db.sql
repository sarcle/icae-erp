Hibernate: 
    alter table t_empleado 
        drop 
        foreign key FK_gxajs14pqqn2rwlg32qcce32q
Hibernate: 
    alter table t_empleado 
        drop 
        foreign key FK_4qy3rqya9i30h0atg5aarvtgt
Hibernate: 
    alter table t_recibo_nomina 
        drop 
        foreign key FK_an0svun3n0epcwcdhua2862rb
Hibernate: 
    alter table t_usuario 
        drop 
        foreign key FK_7kixkljcwul3ldt7ktdrblryh
Hibernate: 
    drop table if exists t_config_portal
Hibernate: 
    drop table if exists t_empleado
Hibernate: 
    drop table if exists t_empresa
Hibernate: 
    drop table if exists t_recibo_nomina
Hibernate: 
    drop table if exists t_rol
Hibernate: 
    drop table if exists t_usuario
Hibernate: 
    create table t_config_icae (
        id integer not null auto_increment,
        logo_url varchar(255),
        path_recibos varchar(255),
        app_title varchar(255),
        primary key (id)
    )
Hibernate: 
    create table t_empleado (
        id_empleado bigint not null auto_increment,
        email varchar(255),
        nombre varchar(255),
        rfc varchar(255),
        id_empresa bigint not null,
        id_usuario bigint not null,
        primary key (id_empleado)
    )
        create table t_factura (
        id_factura bigint not null auto_increment,
        id_cliente bigint not null,
        subtotal double ,
        iva double,
        total double,
        fecha date,
        primary key (id_factura)
    )
       create table t_factura_detalle (
        id_factura bigint not null ,
        id_producto bigint not null,
        cantidad double,
        precio_venta double,
        importe double,
        primary key (id_factura)
    )
    create table t_producto (
        id_producto bigint not null auto_increment,
        clave varchar(255),
        descripcion varchar(255),
        presentacion varchar(255),
        no_existencias int,
        cant_max double,
        cant_min double,
        precio double,
        primary key (id_producto)
    )
    create table t_empleado_nomina (
    
        id_empleado_nomina bigint not null auto_increment,
        curp varchar(50),
        tipo_nomina varchar(20),
    	dias_pagados double,
        nombre varchar(40),
        apellido_paterno varchar(40),
        apellido_materno varchar(40),
        rfc varchar(20),
        sueldo double,
        primary key (id_empleado_nomina)
        
    )
    create table t_cliente (
        id_cliente bigint not null auto_increment,
        clave varchar(255),
        rfc varchar(20),
        nombre varchar(255),
        apellido_paterno varchar(255),
        apellido_materno varchar(255),
        calle varchar(255),
        colonia varchar(200),
        codigo_postal int,
        municipio varchar (250),
        estado varchar (250),
        pais varchar (100),
        no_exterior varchar(50),
        no_interior varchar(50),
        email varchar (200),
        primary key (id_cliente)
    )
Hibernate: 
    create table t_empresa (
        id_empresa bigint not null auto_increment,
        nombre varchar(255),
        rfc varchar(255),
        primary key (id_empresa)
    )
Hibernate: 
    create table t_recibo_nomina (
        id_recibo bigint not null auto_increment,
        fecha_emision date,
        fecha_final_pago date,
        fecha_inicial_pago date,
        fecha_pago date,
        fecha_timbrado datetime,
        path_recibos varchar(255),
        pdf_filename varchar(255),
        uuid varchar(255),
        xml_filename varchar(255),
        id_empleado bigint not null,
        filename_for_download varchar(255),
        primary key (id_recibo)
    )
Hibernate: 
    create table t_rol (
        id_rol bigint not null auto_increment,
        descripcion varchar(255),
        rol varchar(255),
        primary key (id_rol)
    )
Hibernate: 
    create table t_usuario (
        id_usuario bigint not null auto_increment,
        enabled bit,
        password varchar(255),
        reset_password bit,
        username varchar(255),
        id_rol bigint not null,
        primary key (id_usuario)
    )
Hibernate: 
    alter table t_empleado 
        add constraint UK_4qy3rqya9i30h0atg5aarvtgt  unique (id_usuario)
Hibernate: 
    alter table t_empleado 
        add constraint UK_bgwdpp86illtsb97x2d3flaq3  unique (rfc)
Hibernate: 
    alter table t_usuario 
        add constraint UK_5m5cckkj6ynrkudxo491th2u9  unique (username)
Hibernate: 
    alter table t_empleado 
        add constraint FK_gxajs14pqqn2rwlg32qcce32q 
        foreign key (id_empresa) 
        references t_empresa (id_empresa)
Hibernate: 
    alter table t_empleado 
        add constraint FK_4qy3rqya9i30h0atg5aarvtgt 
        foreign key (id_usuario) 
        references t_usuario (id_usuario)
Hibernate: 
    alter table t_recibo_nomina 
        add constraint FK_an0svun3n0epcwcdhua2862rb 
        foreign key (id_empleado) 
        references t_empleado (id_empleado)
Hibernate: 
    alter table t_usuario 
        add constraint FK_7kixkljcwul3ldt7ktdrblryh 
        foreign key (id_rol) 
        references t_rol (id_rol)