drop table dd_table_column_metadata;

\i dd_table_column_metadata.sql

\i dd_table_column_metadata_pop.sql

drop table dd_column_metadata_distinct;

create table
dd_column_metadata_distinct 
as
select distinct 
 column_name,
 column_default,
 is_nullable_flg,
 data_type,
 column_size,
 column_display_size,
 precision,
 scale
from dd_table_column_metadata;


select * from dd_column_metadata_distinct 
where column_name in 
(
   select column_name 
   from dd_column_metadata_distinct
   where column_name != 'ut_user_nbr' 
   group by column_name
   having count(*) > 1
)
order by column_name;

/* 
select table_name, 
 column_name,  
 data_type,
 column_size,
 precision,
 scale
from dd_table_column_metadata
where table_type != 'VIEW' and
      column_name in 
(
   select column_name 
   from dd_column_metadata_distinct
   where column_name not in ('ut_user_nbr')
   group by column_name
--		,
 --           data_type,
--	    column_size,
 --	    column_size,
  --          precision,
   --         scale
   having count(*) > 1
)
order by column_name, table_name;

*/

select count(*) from dd_table_column_metadata;

select table_name, 
 column_name,  
 data_type,
 column_size,
 precision,
 scale
from dd_table_column_metadata
where table_type != 'VIEW' and
      column_name in 
(
   select column_name 
   from dd_table_column_metadata
   where column_name not in ('ut_user_nbr')
   group by column_name,
            data_type,
	    column_size,
            precision,
            scale
   having count(*) > 1
)
order by column_name, table_name;
