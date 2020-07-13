definition="src/test/resources/workbook/DataLoadWorkbookMeta2.yaml";
jarfile=target/vending-sales-reporting-demo-jar-with-dependencies.jar
java -cp $jarfile  org.javautil.poi.workbook.WorkbookWriter  \
    --dataSource integration_postgres_sr \
    --definition $definition \
     --outfile target/load.xls \
        etl_file_id=12
