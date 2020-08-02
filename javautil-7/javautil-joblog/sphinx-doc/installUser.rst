Create the pluggable container
==============================

cd ~/javautil-6/oracle/ddl sqlplus / as sysdba @
create\_sales\_reporting\_pdb

modify tnsnames
===============

Create and configure user
=========================

sqlplus system/tutorial@sales\_reporting @ create\_user
