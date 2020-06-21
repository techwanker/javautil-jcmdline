create table dd_table_column_metadata 
(
 table_catalog            varchar(32), 
 table_schema             varchar(32),
 table_name               varchar(64),
 table_type               varchar(16),
 column_name              varchar(64),
 column_index              int,    -- ordinal_position          int,
 column_default            varchar(64),
 is_nullable_flg           varchar(1) ,  -- nullable
 data_type                 varchar(32),
 column_size               int,   -- character_maximum_length  int,
 column_display_size       int,   -- character_maximum_length  int,
 precision                 int,
 scale                     int,
 comments                  text,
 label                     varchar(32),
 heading                   varchar(32),
 excelFormat               varchar(32),
 java_Format               varchar(32), 
 data_type_name            varchar(32), 
 workbook_formula          varchar(128)
);

/*
	private String                 aggregateFunction;
	private String                 attributeName;
	private String                 columnTypeName;
	private Integer                columnType;
	private boolean                externalFlag;
	private String                 groupName;
	private HorizontalAlignment    horizontalAlignment;
	private boolean                injectedGroupField = false;
	private SimpleDateFormat       inputDateFormat;
	private String                 inputDateFormatString;
	// 
	private Boolean                definitelyNullable;
	private Boolean                unKnownNullable;,
*/
