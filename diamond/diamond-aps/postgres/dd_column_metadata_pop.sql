insert into dd_column_metadata 
(
 table_catalog,
 table_schema,
 table_name,
 column_name,
 column_index,
 column_default,
 is_nullable_flg,
 data_type,
 column_size,
 column_display_size,
 precision,
 scale
) select
 table_catalog,
 table_schema,
 table_name,
 column_name,
 ordinal_position,
 column_default,
 case 
   when is_nullable = 'No' then 'N'
   else 'Y'
   end,
 data_type,
 character_maximum_length,
 character_maximum_length,
 numeric_precision,
 numeric_scale
from information_schema.columns
where table_schema = 'aerodemo';
