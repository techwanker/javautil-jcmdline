set pagesize 0
set long 9000
set feedback off
set echo off
set heading off
set lines 100
set trimspool on
spool schema_ddl.sql

select
   dbms_metadata.GET_DDL(u.object_type,u.object_name,u.owner)
from
   all_objects u
where u.object_type = 'TABLE' 
      and u.owner = 'INTERFAST'
order by u.object_name;
