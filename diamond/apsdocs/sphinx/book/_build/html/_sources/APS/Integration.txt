Integration
===========

Data Loading
------------

Diamond APS provides IDL (Interface Data Load) tables

These tables provide a consistent source of data from
which the planning tables are populated for batch processing.

Interfaces are available execution mode, not addressed
in this document.

Scrubbing
*********

After the tables are loaded the javautil.org ConditionIdentifications
tests are run to identify whether the data is fit to load.

There are no referential constraints and few data checks 
in the IDL tables to allow unsatisfactory data to be loaded
and analyzed as the rigorous data requirements of planning might 
make it impossible to load.

Rules
*****
Your Diamond Consultant will assist you in defining and 
loading the rules.

These rule data is generally programatically generated
and a few passes of planning are made in order to 
explain the ramifications.

Consulting
----------

Rules Data
----------

Customer Substitutes

Global Substitutes

Replenishment Policies

Planning Groups

Supply Pools

Supply Sub Pools

Sourcing Rules

Customer Item Manufacturer Rules

Logic Review
------------
Goals
