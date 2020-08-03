#######################
Vending Sales Reporting
#######################

Project Description
===================

This project showcases javautil.org functionality in a simple real world example.

This is a simple application the provides real functionality for sales reporting and rebate 
processing.

The objective is to dive into a wide variety of technologies rather than go deep into any 
given technology.

With a working app exploring additional features of this technology is easy.

Software Description
--------------------

Distributors of various products report their sales as specified by the data processor, custdata.com.  This
software reads the data currently being reported and

* Loads the data into ETL (Extract Transform and Load) tables
* Runs a variety of tests to ensure the self consistency of the data and compliance with reporting rules.
* Posts the data
* Extracts data into various reporting formats
* Analyses Data
* Creates spreadsheets for users
* Validates customer mailing addresses and standardizes them
* Computes rebates
* Provides Vending operator spreadsheets
* Creates ACH files for submitting to a bank to issue rebates to customers

Tech Steps
----------
Install the required software
Configure for build
Build


History
------

Processing Steps

Features
========

* Load standard reporting files into ETL (Extract Transform and Load) tables in a relational database

* Process Condition Identification against the loads for inconsistencies such as
  * TODO
* Post the load information
* Extract load files into

  * CDS reporting format
  * CSV
  * JSON
  * XML
  * Python Objects

    * List ouf Lists
    * List of Tuples
    * List of Dictionary
  * Excel Spreadsheets
* Data Analysis

  * Top Customers
  * Customer Call Reporting
  * ARIMA
* Custom Spreadsheets
* JSON RPC Server and Client
* Address Validation, Standardization and Correction
* Geo Location
* VCF


Audit
*****
Identify product miscategorization.  Product GTINS may be "guessed" from the product description,
this is error prone.

ACH rebate payments
*******************
Rather than mail out checks, ACH transactions can be made, Pepsico-Frito can review and forward to  
its bank and rebate payments can be sent out electronically for about $0.01 per transaction.

This is faster, less expensive and less error prone than mailing out checks and more convenient for
the distributors.

Anomolies
*********
Report outliers on data reporting.

This is performed by the *javautil.org* *Condition Identification* package, written by
Jim Schmidt for use by Trinity Technical Services customers to identify potential problems
with data loading into the data warehouse.

Jim Schmidt demonstrated this while building an entire rebate program for a Custom Data Solutions
client and it was used to replace the paper reporting system, saving a huge amount of time and increasing
the identification of suspect data using metrics derived from historical data.  This was completely 
designed and written by Jim Schmidt prior to joining CDS.

Product Assignment
******************


Distributors
------------

Address Standardization
***********************
Correct and standardize all mailing addresses and report undeliverable USPS addresses for vending operators.

Geo Coding
**********
Return latitude and longitude for all valid mailing addresses.

Product Identification
**********************


Customer Facing Reports
***********************

Apps
----
Phone app for 

kd'x
Gather Product Statistics
-------------------------

* Total sales prior 12 months
* Percent of total sales by product 
* Operator maximum percentage
* First sale date
* Trend line slope
* Seasonality

Operator Product Statistics
---------------------------

* Pct of sales for product by operator
* Ratio of percent of sales for this operator to median percentage
* Total dollars sales by product previous twelve months

Opportunities
-------------


Operator Call Report
--------------------
* Product mix to standard mix
* Suggested products to carry




Answers to Questions you should have asked
==========================================

We do the work of finding data that is interesting and provide email notices 
that these reports exist.  Anyone subscribing to that event can get an email summary
notification and click directly to the report, only having to login.  We can support
gmail or facebook authentication so the user doesn't need another username and password.

It couldn't be easier.

Answers phone friendy format or downloadable in a variety of formats. 

Examples
&&&&&&&&

* Which operators are not selling recently introduced products

* Which operators have a sub-optimal mix of the top selling items by category

* Product declining sales for a vending operator

* Dropped products for a vending operator

* Parasitic promotion effect (Items not on promotion having declining sales during a promotion
as slot contention has had a parasitic effect.


Sales Analysis
==============

Missing Product
---------------

Objective
*********

List customers and the products they are should be selling but are not.

Approach
********

* Rank Products
* 

Customers
*********
As we are dealing with CDS reporting format and the scope of creation of customers in posting 
is beyond the scope of this section I will create a customer with a simple database view.

code::

        create or replace view
        customer_vw as
        select distinct ship_to_cust_id
        from etl_sale;

Effective Date
**************
In order for these queries to work without recreating the database we assume
an *effective date* which is the date of the last reported sale.

code::
        create or replace view effective_date as
        select max(invoice_dt) report_date from etl_sale;

Total Sales
***********

Total $ amount of sales for the preceeding 12 months based on last invoice date.

code::

        create or replace view tot_sales_12 as
        select sum(extended_net_amt) tot_extended_net_amt
        from etl_sale,
             effective_date
        where invoice_dt  > effective_date.report_date - interval '1 year';

Customer & Product Sales Last 12 months
***************************************

code::

        create or replace view customer_product_last_12_months as
        select  etl_sale.ship_to_cust_id, 
                case_gtin,
                sum(extended_net_amt) sum_extended_net_amt
        from    etl_sale,
                effective_date
        where   invoice_dt  > effective_date.report_date - interval '1 year'
        group by ship_to_cust_id,
                case_gtin
        order by sum(extended_net_amt) desc;



Product Rank
************
There are many ways to rank product.

Units, gross revenue, profit, turns...

This is based simply on gross revenue

code::

    create or replace view product_rank_12_vw as
    select etl_sale.case_gtin, sum(etl_sale.extended_net_amt) sum_ext,
           sum(etl_sale.extended_net_amt) * 100 / tot_sales_12.tot_extended_net_amt
    from etl_sale,
         tot_sales_12
         effective_date
    where invoice_dt  > effective_date.report_date - interval '1 year'
                    group by case_gtin
                    order by sum(extended_net_amt) desc
            ;
    
    
Product Not Sold
================ 
What products are customers not selling?

code::

    create or replace view product_undersold_by_customer_vw as
    select customers.ship_to_cust_id,
           top_products.case_gtin
    from customers,
         top_products
    where not exists
      ( select 'x' from etl_sale, top_products
        where
            etl_sale.ship_to_cust_id = customers.ship_to_cust_id  and
            etl_sale.case_gtin = top_products.case_gtin
      )
    order by customers.ship_to_cust_id,
             case_gtin;
   
Potential Revenue
-----------------

Now let us consider the amount that could be sold if these customers were to sell
your standard ratio of product.

We do that by multiplying the ratio to the dollar total for the customer.

In the best case scenario, the vending operator will add a slot for the product, replacing
with a product you don't distribute to him.  There is a distinct possibility that the sale
will be slightly parasitic and a lower volume product you do distribute will be replaced.

 

Audit
=====

Pacific Data Services will audit the data and rebate calculations for your distributors.

Findings
--------

Item Accuracy
*************
We will compare the items assigned by Custdata to the actual items sold by the distributors.

This affect sales history and rebate calculations

Addresses
*********
Report incorrect addresses and undeliverable addresses.

Rebate
******
Calculate the actual rebate for the top 50 rebate amounts issued versus what Custdata
computed.



Processing
==========

Initialize
----------

Data Load
---------

The data files are parsed and the data is loaded into a relational database
with one table per record type, sufficient information is retained that
an identical output file can be created for an input file.

This allows the data file to accessed using SQL and provides atomic operations.

A file is completely loaded or is rejected and not loaded at all.

Being completely loaded does not mean that the file is satisfactory.

Relational Databases supported are

* Oracle
* postgress
* sqlite

Data Format
&&&&&&&&&&&

Exception Identification
------------------------

The exception identification is performed by *javautil.org* program, condition identification.


This code was developed by Trinity Technical Services (My company) for 
importing data from other systems into Diamond Distribution but is extremely
generic.  

There are several versions of this code, the one employed at Custom Data 
Services at the time of my departure was based on rules stored in the database.

While that version and subsequent improved versions could be used, I recommend
the latest version that stores all the rules in a flat file.

Prior to use of the exception identification system Custom Data Solutions 
ran stacks of reports that were hand examined.  It was a slow and inflexible process.

The new system allowed for acceptance of conditions and partial posting while 
suspect records were corrected.  

Examples of Conditions
**********************
- Sales with no associated customer
- Products not on product master
- Suspicious quantity
- Suspicious price

Rule Examples
&&&&&&&&&&&&&

.. code-block:: sql

    -   rule_name:  NO_CUSTOMER_TOTAL
        table_name: ETL_FILE
        msg:      No customer total record
        sql_text: >
                select etl_file_id
                from etl_file
                where etl_file_id = %(ETL_FILE_ID)s
                and not exists (
                   select 'x'
                   from etl_customer_tot
                   where etl_file_id = %(ETL_FILE_ID)s
                )
        narrative: >
                There is no customer total record
        severity: 3
        format_str: "No customer total record in %s"
        java_format: "No customer total record for etl_file_id %s"
    
    -   rule_name:  CUSTOMERS_BUT_NO_TOTAL
        table_name: ETL_FILE
        msg:      Customers / No customer total
        sql_text: >
                select etl_file_id
                from etl_file
                where etl_file_id = %(ETL_FILE_ID)s
                and not exists (
                   select 'x'
                   from etl_customer_tot
                   where etl_file_id = %(ETL_FILE_ID)s
                ) and exists (
                   select 'x'
                   from etl_customer
                   where etl_file_id = %(ETL_FILE_ID)s
                )     
        narrative: >
                There is no customer total record but customers were reported
                It is impossible to determine the effective date of the 
                customer information without this record
        severity: 3
        format_str: "No customer total record in %s"
        java_format: "No customer total record for etl_file_id %s"
    
    -   rule_name: NO_SALES_FOR_CUSTOMER
        table_name: ETL_CUSTOMER
        msg:      No sales for customer
        sql_text: >
                select ec.etl_customer_id, ship_to_cust_id, ec.cust_nm, etl_file_id
                from etl_customer ec
                where ec.etl_file_id = %(ETL_FILE_ID)s and not exists (
                   select 'x'
                   from etl_sale
                   where etl_sale.etl_file_id = %(ETL_FILE_ID)s and
                         ec.ship_to_cust_id = etl_sale.ship_to_cust_id
                )
        severity: 1
        format_str: >
                etl_customer_id %s ship_to_cust_id %s name: %s has no sales in load %s
        java_format: >
                etl_customer_id %s ship_to_cust_id %s name: %s has no sales in load %s
    
    -   rule_name: INVALID_CUSTOMER_TOTAL
        table_name: ETL_FILE,
        msg:      Customer Total Record Incorrect
        sql_text: >
                select etl_file_id
                from   etl_customer_tot
                where  etl_file_id = %(ETL_FILE_ID)s
                and customer_count is null or
                    customer_count != (select count(*)
                                     from etl_customer
                                     where etl_file_id = %(ETL_FILE_ID)s)
        severity: 7
        format_str: "Customer total is incorrect for etl_file %s "
        java_format: "Customer total is incorrect for etl_file %s "
    
    
    -   rule_name: SALE_NO_CUST
        table_name:     ETL_SALE
        msg:         Sales record with no customer in load
        sql_text: >
                select etl_sale_id, ship_to_cust_id, etl_file_Id
                from   etl_sale
                where  etl_file_id = %(ETL_FILE_ID)s and
                not exists (select 'x' from etl_customer
                            where etl_customer.ship_to_cust_id = etl_sale.ship_to_cust_id)
        narrative: >
                The customer specified in a sales record does not have
                a corresponding customer record in this load.
    
                A separate test is made to ensure that the customer has
                been previously transmitted by this distributor.
        severity: 3
        format_str: >
             "etl_sale_id %s has ship_to_cust_id %s in load %s sales record but there is no such customer"
        java_format: >
             "etl_sale_id %s has ship_to_cust_id %s in load %s sales record but there is no such customer"
        corrective_action: >
           None required, if the customer was never reported a separate test will mark this load invalid
    
    -   rule_name: UNIDENTIFIED_PRODUCT_IN_SALE
        table_name: ETL_SALE
        msg:     Sales record with no identifiable product in load
        sql_text: >
                select etl_sale_id, mfr_product_id, case_gtin
                from   etl_sale
                where not exists (select product_id
                          from product
                          where product.case_gtin = etl_sale.case_gtin
                                or product.mfr_product_id = etl_sale.mfr_product_id)
                and etl_file_id = %(ETL_FILE_ID)s
                order by etl_sale_id
        narrative: >
                    This sales does not identify an authoritative product
        severity: 6
        format_str: "etl_sale_id: %s, mfr_product_id: %s case_gtin: %s"
        java_format: "etl_sale_id: %s, mfr_product_id: %s case_gtin: %s"
        corrective_action:
                    Update the product master or correct the sales master


Pre-post
--------
The prepost process

Posting
-------

Address Validation
------------------



Processing Steps
----------------

Data is uploaded to the data processing service.

The file loads are analyzed at CDS using an old version of my javautil conditionidentification package.

The data is loading into prepost tables.

The data is posted

A snapshot of the data is made once a day for online web reporting in the form of spreadsheets.

Rebate programs are designed and the sales are tracked and the rebates calculated.

Rebate checks are mailed out.




Distributors
------------

Product Offering
----------------
So I can offer

* Data Reporting
* Web Site for Data
* Sales Analytics*
* Address Validation and Correction
* ACH processing for rebates
* Availability to Vending operators
* A version that runs on Frito/Pepsico laptops so they can work offline while traveling
* High level management financial analysis

Benefits
********

* Availability of site to operators for tracking rebate progress

* Internationalization works outside the U.S.

* Lower cost

  * Using open source database allows for many database servers at minimal incremental cost
  * Using Asian resources is far less expensive


How to get started
******************

I simply need 

* the data that is currently reported by the distributors 
* product master list

No cost, no additional work, just send me the data and let me do my magic.

Technologies
============

Application
-----------
* Java
        * JDBC
        * Hibernate
* Build Tools
        * Maven
* Postgres
        * SQL
* Testing 
        * Unit Testing - SureFire
        * Integration Testing
* Spring
  * JSON RPC
  * Dependency Injection
  * Spring Boot
* YAML
* Sphinx
* javautil

Deployment
----------
Amazon Web Services with high availability and security, unlimited scalability and robust administration.

Service Contracts monthly.



Pacific Data Services - Sales Reporting
=======================================

Introduction
------------

Pepsi-Frito uses Custom Data solutions to record and report vending sales.  I am extremely
familiar with this operation as I taught Custom Data Solutions the technology for 25 years
and functioned as their first Chief Information Officer 

I redesigned the entire process in the two years I was an employee.

More in :doc:`Contributions`

Benefits
--------

* Audit the data and rebate calculations. :doc:`Audit`

* Get answers without asking questions :doc:`Answers`

* Custom Reporting

* Online analytical processing

* Startup is negligible
  
  * Just need copies of the files the distributors already report :doc:`cds_record_layout`

  * A product master file

  * No computing resources, no long term contracts 


Once installed:

#. Reporting data is loaded into staging tables

#. Verification of compliance with requirements and self consistency of data is ensured

#. Data is posted to history tables

#. Customer addresses are validated

#. Exceptional conditions are identified and reported

#. Rebate Calculations are made and reported

#. Rebate amounts are computed and an ACH file for transmission to a bank for payment is created

#. Spreadsheets for sales analysis are created

Functioning Real World Usage
----------------------------

Any distributor currently writing files in the CDS reporting format can easily load files 
into a local database in order to analyze the data.

We have provided many analyses that report data worthy of further inspection.

This approach is our "answers to questions you should have asked".


Audit
=====

Pacific Data Services will audit the data and rebate calculations for your distributors.

Findings
--------

Item Accuracy
*************
We will compare the items assigned by Custdata to the actual items sold by the distributors.

This affect sales history and rebate calculations

Addresses
*********
Report incorrect addresses and undeliverable addresses.

Rebate
******
Calculate the actual rebate for the top 50 rebate amounts issued versus what Custdata
computed.

Report augmentation
-------------------

Answers to Questions you should have asked
******************************************
Rather than spend time on the Custdata website creating spreadsheets and trying to spot
interesting and unusual data we will create *Alert Reports* and notify you that 
there is research warranted.

Examples
&&&&&&&&

* Newly introduced items not being bought by distributor

* Top selling items by category not being bought by distributor

* Top selling items by category not being bought by a vending operator

* Product declining sales for a vending operator

* Dropped products for a vending operator

* Parasitic promotion effect (Items not on promotion having declining sales during a promotion
as slot contention has had a parasitic effect.




Sales
=====


Required Data
-------------
Distributors already report their data to custdata.com.

They have to do nothing but send us the same data files, no additional work.

Benefits
--------

Manufacturers
*************

Benefits
&&&&&&&&

* Far lower costs
* Faster and Cheaper Custom Reports Generation

* Improved Data Quality
* Far Lower Costs
* Data Identified for them

  Currently the manufactures have to click through the Custdata website and create a spreadsheet and see if there is
  interesting data.

  We can analyze the data and inform them of interesting conditions, for example

 New Reports
 &&&&&&&&&&&

  * New Vending Operators
  * Vendors with Declining Sales
  * Vendors not carrying products

New Capabilities
&&&&&&&&&&&&&&&&

* Address Correction
* 


Distributors
************

* Ability to create an operator facing website


Vending Operators
*****************

* Find new  products to be offered




Background
==========
.. toctree::
   :maxdepth: 2
   :caption: Contents:

     
   Analyze      
   Answers
   Audit
   Benefits
   Contributions
   ProductOffering
   ProjectDescription
   Technologies
   cds_record_layout


Record Layouts
==============
This details the reporting format as last posted by custdata.com
on their website.  This is available at 
::

    http://web.archive.org/web/*/custdata.com

Inventory
---------

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
DISTRIBUTOR_ID                 DIGITS        0     10 {:0>10s}
MFR_ID                         DIGITS       10     10 {:0>10s}
MFR_PRODUCT_ID                 DIGITS       20      8 {:0>8s}
COMMENTS                       TEXT         28     96 {:<96s}
CASES                          INTEGER     124      6 {0:06d}
BOXES                          INTEGER     130      6 {0:06d}
UNITS                          INTEGER     136      6 {0:06d}
CASE_GTIN                      DIGITS      142     14 {:0<14s}
FILLER                         LITERAL     156     12 {:<12s}
RECORD_TYPE                    LITERAL     168      2 {:<2s}
============================== ======== ====== ====== ========

Customer
--------

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
FILLER_00_05                   LITERAL       0      6 {:>6}
CLASS_OF_TRADE                 TEXT          6      4 {:<4s}
SHIP_TO_CUST_ID                TEXT         10     10 {:0>10s}
CUST_NM                        TEXT         20     30 {:<30s}
ADDR_1                         TEXT         50     30 {:<30s}
ADDR_2                         TEXT         80     30 {:<30s}
CITY                           TEXT        110     25 {:<25s}
STATE                          TEXT        135      2 {:<2s}
POSTAL_CD                      DIGITS      137      9 {:0>9s}
TEL_NBR                        DIGITS      146     10 {:0>10s}
NATIONAL_ACCT_ID               TEXT        156     10 {:0>10s}
SPECIAL_FLG                    TEXT        166      1 {:>1s}
FILLER_1                       LITERAL     167      1 {:>1s}
RECORD_TYPE                    LITERAL     168      2 {:>2s}
============================== ======== ====== ====== ========

Inventory Total
---------------

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
HEADER                         LITERAL       0     10 {:>1s}
FILLER36                       LITERAL      10     36 {:>36}
INVENTORY_DT                   DATE         46      8 %Y%m%d
FILE_CREATION_DT               DATE         54      8 %Y%m%d
RECORD_CNT_REPORTED            INTEGER      62      9 {0:09d}
FILLER97                       LITERAL      71     97 {:>97}
RECORD_TYPE                    LITERAL     168      2 {:>2}
============================== ======== ====== ====== ========

Customer Total
--------------

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
HEADER                         LITERAL       0     10 {:>10s}
FILLER_127                     LITERAL      10    127 {:>127s}
CUSTOMER_COUNT                 INTEGER     137      9 {0:09d}
FILLER_22                      LITERAL     146     22 {:>22s}
RECORD_TYPE                    LITERAL     168      2 {:>2s}
============================== ======== ====== ====== ========

Sales
-----

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
DISTRIB_ID                     TEXT          0     10 {:0>10s}
MFR_ID                         TEXT         10     10 {:0>10s}
MFR_PRODUCT_ID                 TEXT         20      8 {:0>8s}
SHIP_TO_CUST_ID                TEXT         28     10 {:0>10s}
INVOICE_CD                     TEXT         38     10 {:0>10s}
INVOICE_DT                     DATE         48      8 %Y%m%d
SHIP_DT                        DATE         56      8 %Y%m%d
FILLER                         LITERAL      64      9 {:<9s}
EXTENDED_NET_AMT               INTEGER      73      9 {0:09d}
DISTRIB_PRODUCT_REF            TEXT         82     12 {:<12s}
PRODUCT_DESCR                  TEXT         94     30 {:<30s}
CASES_SHIPPED                  INTEGER     124      6 {0:06d}
BOXES_SHIPPED                  INTEGER     130      6 {0:06d}
UNITS_SHIPPED                  INTEGER     136      6 {0:06d}
CASE_GTIN                      TEXT        142     14 {:0>14s}
FILLER_12                      LITERAL     156     12 {:>12s}
RECORD_TYPE                    LITERAL     168      2 {:<2s}
============================== ======== ====== ====== ========

Sales Total
-----------

============================== ======== ====== ====== ========
field_name                     type     offset length format
============================== ======== ====== ====== ========
HEADER                         LITERAL       0     10 {:>10s}
FILLER_28                      LITERAL      10     28 {:>28s}
SALES_START_DT                 DATE         38      8 %Y%m%d
SALES_END_DT                   DATE         46      8 %Y%m%d
FILE_CREATE_DT                 DATE         54      8 %Y%m%d
SALES_REC_CNT                  INTEGER      62      9 {:0>9d}
SUM_EXT_NET_AMT                INTEGER      71     11 {:0>11d}
FILLER_86                      LITERAL      82     86 {:>86s}
RECORD_TYPE                    LITERAL     168      2 {:<2s}
============================== ======== ====== ====== ========

Contributions
=============

Jim Schmidt and his company Trinity Technical Services introduced and mentored
Custom Data Solutions on every technology they used since 1990.

In 1990 Chuck Schmidt, the owner and president of Custom Data Solutions was
developing software in assembly language on alphamicro computers.

Unix/Linux
----------

I introduced Chuck to Unix, starting with Interactive Unix, a Kodak supported
version of AT&T Unix System 5 in 1991.  

Thereafter Trinity became a reseller of MIPS computers and then 
Digital Equipment.

Oracle
------

Jim introduced Chuck to Oracle and provided training and technical assistance 
from 1992 to 2007. Trinity staff trained Custom Data Staff on Oracle Forms,
Oracle Reports and the Database.

C
-

Java
----

Became Employee
---------------
In 2007 I made an agreement with Custom Data Solutions to become
the CIO with the understanding that he could work remotely.  

So I sold everything I owned, two houses, two boats, two jet-skis, two ATVs
and the rest of my possessions.

When my youngest son went off to college, I drove him to Purdue and
went to Michigan to fix a few problems for a couple of months, that 
turned out to be over a year.  

During that time period

- Migrated 10 vending databases to a single database
- Upgraded from Oracle 7 to Oracle 11
- Installed Oracle Enterprise manager and taught how to use it
- Created a development and a test database. Formerly all testing was done in production.



Technical Standards
-------------------
- Estabished the use of build tools, Ant and Maven
- Instituted source version control, CVS and Subversion
- Unit Testing
- Integration Testing
- Designed and build a document management service
- Migrated off Digital Unix to Linux
- Introduced virtualization, vmware, openvz and virtualbox
- 

Products
--------

Check 21
********

Document Management
*******************

Workbook Parser
***************

Dexterous
*********



Redesign
--------

CDS had a prospective client that needed rebate process

Data Load
*********
I replaced the java program that loaded the data into a stored procedure
that loaded into staging tables.

Exception Processing
********************
I employed the javautil Exception Processing system to identify load problems.

Unknown to me at the time, Custom Data Solutions identified problems with reports.
The report modification was cumbersome, execution was slow, printing was slow 
and wasteful.

By generating metrics of minimum and maximum and standard deviations from 
the mean the identification of outlier input data was greatly improved.

Maintenance System
******************
The maintenance and control system was all written in Apex, whereas CDS was
using Oracle Forms.  My staff trained CDS on developing in Apex.

Posting
*******

*****************

Workbooks
*********

Others
------
- Servlets
- Javascripts
- Excel workbooks
- Detachable tablespaces
- Materialized Views
- Virtual Private Databases

Javautil
--------
javautil.org was Jim Schmidt's domain
javautil.com still is


History of Jim Schmidt and Custom Data Solutions
================================================

Creation
--------

Custom Data Solutions was initially called CDS for Chuck and Dee Schmidt.

Chuck is my older brother and Dee is his wife.

Chuck left his job at Michigan National Bank to offer data processing services, initially using a TRS-80 to print mailing labels.

He subsequently bought an Alpha Micro http://www.s100computers.com/Hardware%20Folder/Alpha%20Micro/History/History.htm and wrote some business applications.

On a visit to Detroit I explained to him the benefits of Unix and got him started, installing Interactive Unix from Kodak on a PC from 133 floppy disks in 1990.

Between 1983 and 1990 I worked as Vice President of International Banking Systems for RepublicBank Dallas, as a principal at a Distribution Requirements Planning Company and then at Computer Associates where I single handedly designed and wrote the ACH settlement software system in six weeks.

In 1990 I started Trinity Technical Services with two partners and ended up buying them both out.

My first contract was the selection of an ERP system for a distributor in Texas.  The chosen vendor was CIM-JIT and it was my first exposure to Oracle. I soon
became more proficient in the CIM-JIT software than the vendor and flew around 
country to modify to delivered software to comply with commitments to customers.

In the process I became quite proficient in fixing performance problems.

Convinced that Oracle was the finest relational database, I convinced Chuck to
come down to my Dallas office for a quick introduction.

He immediately saw the benefits of SQL over procedural file manipulation and 
also became an Oracle Partner.


CDS somehow happened to land a contract to handle rebates for Leaf Gum.

Technologies
------------

Unix
****

Oracle
******

Oracle Forms
&&&&&&&&&&&&

Oracle Reports
&&&&&&&&&&&&&&

PL/SQL
&&&&&&

C
*

Java
****

JSP
***

Graphics
********

Javascript 
**********

Spreadsheets
************

Digital Unix
************



Linux
*****

Build tools
***********
Build scripts were shell scripts.

I introduced standardized build tools, first ant and then Maven

Unit Tests
**********
I introduced junit for unit testing code and cobertura for code coverage analysis.

Integration Tests
*****************

Chuck Retires
-------------

Database Consolidation
&&&&&&&&&&&&&&&&&&&&&&

Each client had a separate database version 7 of Oracle.  
I consolidated 10 databases into one, eliminated database links.

Customer Matching and Address Validation
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

There was a daemon that ran that attempted to match customers on addresses.

I utilized javautils service to call the USPS API to actually standardize the
addresses for exact matches and identify undeliverable addresses


Geo Encoding
&&&&&&&&&&&&

Exception Processing
&&&&&&&&&&&&&&&&&&&&

Spring
&&&&&&

Hibernate
&&&&&&&&&






Help
****
Make files
C
Pro*C
Forms

****
V




Business Model
==============


Relationship
************

Custom Data Services was created by my brother Chuck.  I consulted to them for over 25 years and
taught him everything he knew from linux to relational databases, website creation, c and java.

In 2007 I accepted the position of CIO when my brother sold the company.  I gave up my consulting practice
on the promise that I could work remotely after my son went to college.

After I completely revised all of the infrastructure, which was horrible in more ways than can be credibly described
including the fact that they were seven years out of date on Oracle and had 14 instances running on three different 
machines, I upgraded to Oracle 10 and migrated everything to one instance and finally into one schema.

After I sold my house and all my possessions and moved to Costa Rica, they fired me.



While CIO
---------
* Document Management
* Migrated off of Digital Unix
* Changed backup procedures 
* Introduced Software Version Control
* Created development and test databases
* Trained a cafeteria worker and a pizza delivery person to program
* Coded up the most complex spreadsheets for Frito
* Introduced virtualization vmware, openvz, virtualbox
* Upgraded to Oracle 10
* Introduced Oracle Enterprise Manager
* Materialized Views
* Detachable Tablespaces
* Virtual Private Databases
* Spring inversion of control, hibernate, aspects
* Unit Testing
* Check 21 solution
* Wikis for documentation procedures
* xml 
* dexterous
* workbook parser 

Terminated
---------- 


They claimed ownership of javautil despite the facts
* javautil.org was owned by Jim Schmidt
* javautil.com was owned by Jim Schmidt

The code base dated back to 1999.

CDS sued Jim Schmidt and claimed ownership of the code, but I would have had to have their current employees testify that
the code they were using was in production at my customer sites before I joined CDS.

A settlement was reached, I allowed them to continue to use the code as it was at them time  while I retained all rights.


History of Jim Schmidt and Custom Data Solutions
================================================

Creation
--------

Custom Data Solutions was initially called CDS for Chuck and Dee Schmidt.

Chuck is my older brother and Dee is his wife.

Chuck left his job at Michigan National Bank to offer data processing services, initially using a TRS-80 to print mailing labels.

He subsequently bought an Alpha Micro http://www.s100computers.com/Hardware%20Folder/Alpha%20Micro/History/History.htm and wrote some business applications.

On a visit to Detroit I explained to him the benefits of Unix and got him started, installing Interactive Unix from Kodak on a PC from 133 floppy disks in 1990.

Between 1983 and 1990 I worked as Vice President of International Banking Systems for RepublicBank Dallas, as a principal at a Distribution Requirements Planning Company and then at Computer Associates where I single handedly designed and wrote the ACH settlement software system in six weeks.

In 1990 I started Trinity Technical Services with two partners and ended up buying them both out.

My first contract was the selection of an ERP system for a distributor in Texas.  The chosen vendor was CIM-JIT and it was my first exposure to Oracle. I soon
became more proficient in the CIM-JIT software than the vendor and flew around 
country to modify to delivered software to comply with commitments to customers.

In the process I became quite proficient in fixing performance problems.

Convinced that Oracle was the finest relational database, I convinced Chuck to
come down to my Dallas office for a quick introduction.

He immediately saw the benefits of SQL over procedural file manipulation and 
also became an Oracle Partner.


CDS somehow happened to land a contract to handle rebates for Leaf Gum.

Technologies
------------

Unix
****

Oracle
******

Oracle Forms
&&&&&&&&&&&&

Oracle Reports
&&&&&&&&&&&&&&

PL/SQL
&&&&&

C
*

Java
****

JSP
***

Graphics
********

Javascript 
**********

Spreadsheets
************

Digital Unix
************



Linux
*****

Build tools
***********

Unit Tests
**********

Integration Tests
*****************

Chuck Retires
-------------

Database Consolidation
&&&&&&&&&&&&&&&&&&&&&&

Customer Matching
&&&&&&&&&&&&&&&&&

Address Validation
&&&&&&&&&&&&&&&&&&

Geo Encoding
&&&&&&&&&&&&

Exception Processing
&&&&&&&&&&&&&&&&&&&&

Spring
&&&&&&

Hibernate
&&&&&&&&&






Help
****
Make files
C
Pro*C
Forms

****
V




Business Model
==============

Custom Data Solutions
---------------------

http://custdata.com



Processing Steps
----------------

Data is uploaded to the data processing service.

The file loads are analyzed at CDS using an old version of my javautil conditionidentification package.

The data is loading into prepost tables.

The data is posted

A snapshot of the data is made once a day for online web reporting in the form of spreadsheets.

Rebate programs are designed and the sales are tracked and the rebates calculated.

Rebate checks are mailed out.





)
