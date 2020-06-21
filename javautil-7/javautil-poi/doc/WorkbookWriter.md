# WorkbookWriter

## Introduction

Creates excel workbooks from a yaml definition file

## Example
```
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
       excelFormat:  YYYY-MM-DD
    invoice_dt:
       dataTypeName: DATE
       excelFormat:  YYYY-MM-DD
    cases:
       excelFormat: "#,###;[RED]-#,###"    
    boxes:
       excelFormat: "#,###;[RED]-#,###"    
    units:  
       excelFormat: "#,###;[RED]-#,###"    
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
```

This will produce a workbook with three sheets:

* Sales
* Customers
* Inventory

# TODO
 

1. Write a main method that supports

Check that all bind variables specified in
sql are defined in the bindDefinitions

check that all bind definitions are passed to the
the WorkbookWriter constructor

Write WorkbookWriterArguments and add a main
method that calls 


After the annotated arguments the bind values should be specified, 

Example

   java -jar jarfile.jar WorkbookWriter \
      --definition DataloadWorkbook.yaml \
	  --datasourceName sales-reporting
	  --outfile /tmp/workbook.xls \
	  etl_file_id=1

Dates should always be 'YYYY-MM-DD' format as
input

2. Write a webpage to prompt

3. Add support for list of values for restricted
bind variables
