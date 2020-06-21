ApsTechnicalReferenceBook
=========================
try using aps inventoryForecasting

Database Privileges
-------------------

Synchronous Requests
--------------------

Asynchronous Requests
---------------------

Properties and Command Line Arguments
-------------------------------------

leadTimePaddingFactor
^^^^^^^^^^^^^^^^^^^^^

Double lp -
PropertyHelper.getMandatoryDoubleSystemProperty(“leadTimePaddingFactor”);
double totalLeadTime - lp \* this.itemMaster.getLeadTmDy().floatValue();
endLeadTime - DateHelper.toSqlDate(DateHelper.addDays(today,
java.lang.Math.round((float)totalLeadTime))); comp -
this.getNeedByDate().compareTo(endLeadTime);

Cache Manager
-------------

DBMS_PIPE
----------

grant execute on dbms_pipe to diamond;

Planning Group
--------------

Equivalent Items
----------------
Two items are equivalent if they have the same form, fit and function and can be certified
to the other.  

This is in the case of engineered parts.


Customer Substitutes
--------------------
Customer substitutes are used when one part may be used in place of another.

The parts may have identical specifications or just be satisfactory.

For example a police department may need "D" Cell batteries for their flashlights.

In lieu of customer substitutes a pseudo part can be created.

Global Substitutes
------------------

iimes - (IcItemMastEquivS) cache.get(IcItemMastEquivS.class.getName());
iicss - (ApsCustItemSubstS)
cache.get(ApsCustItemSubstS.class.getName()); aigs -
(ApsItemGlobalSubstS) cache.get(ApsItemGlobalSubstS.class .getName());
