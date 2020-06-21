# Workbook Renderer

# To create a workbook using a databse as a source

    java -jar javautil-poi.jar --datasource datasourceName \
       --definition definition.yaml  --out workbook.xls
       
Where:

* datasourceName is an entry in ~/connections_java.yaml
* definition.yaml defines the workbook per below
* workbook.xls is the name of the file to write

# Definition

## Workbook
- name the name of the workbook definition
- description a short description of the workbook, used in web pages to 
  show the workbooos
- narrative a full description of the purpose and contents of the output
- bind definition bind names and their types for sql statements
- columns column metadata for rendering output, supplementing 
  information from ResultSetMetaData
   
## Sheets

- name The sheet name
- sql the SQL to execute to create the dataset

## TODO document

- crosstab
- style
- Multiple Regions
- footers
- dataset features
   
## Example   
.. code:: yaml

    name:  Dataload Workbook
    description: Workbook for Dataload
    narrative:
    bindDefinitions:
        etl_file_id:
           bindTypeName: long
    columns:
        extended_net_amt:
           excelFormat: "#,###.00;[RED]-#,###.00"
           dataTypeName: NUMERIC
           heading: "Invoice $"
        ship_dt:
           dataTypeName: DATE
        invoice_dt:
           dataTypeName: DATE
           excelFormat:  YYYY-MM-DD
    worksheets:
        Sales:   
           name: Sales
           sql: >
               select * 
               from etl_sale
               where etl_file_id =:etl_file_id
        Customers:   
           name: Customers
           sql: >
               select * 
               from etl_customer 
               where etl_file_id =:etl_file_id
        Inventory:   
           name: Inventory
           sql: >
               select * 
               from etl_inventory
               where etl_file_id =:etl_file_id
        
     