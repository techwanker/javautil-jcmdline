--#<
set echo on
--#>
create sequence logger_settings_id_seq;

create table logger_settings (    
    logger_settings_id number(9),
    logger_token            varchar(64),
    process_name         varchar(128),
    classname            varchar(255),
    thread_name          varchar(128),
    module_name          varchar(64),
    status_msg           varchar(256),
    trace_level          number(2),
    directory_name       varchar(128),
    logfile_name         varchar(64),
    abort_stack_trace     clob,
    log_level            number(1),
    msg_lvl              number(1),
    constraint logger_settings_pk primary key (logger_settings_id)
   ); 

   create sequence logger_hdr_id_seq;

create table logger_hdr
(
	logger_hdr_id  number(9)    primary key,
        logger_set_nm  varchar(32)  unique not null,
        default_lvl    number(1)    not null
);

create sequence logger_dtl_id_seq;

create table logger_dtl
(
        logger_dtl_id number(9)   primary key,
	logger_hdr_id number(9)   references logger_hdr,
        logger_nm     varchar(132),
        log_lvl       number(1) not null,
        constraint logger_dtl_uniq unique (logger_hdr_id, logger_nm)
);




