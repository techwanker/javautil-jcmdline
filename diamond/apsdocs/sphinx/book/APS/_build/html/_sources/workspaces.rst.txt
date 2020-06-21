Workspaces
==========

diamond-interfast
-----------------
2015 
maven

2017-07-02 git init

workspace-diamond10
-------------------


workspace-diamond10.17
----------------------
Current development based on workspace-diamond10 
That was the version deployed at clothing manufacture
After applying src/main/resources/ddl/diamond_mod
to diamond schema it now works on clothing and aerospace.

Not sure about orders in pick and how that works

workspace-diamond10-2017
------------------------
workspace-diamond12
-------------------
packages renamed from diamond10 to dbexperts
Also has IDL so probably started from diamond10

uses AppCtlS type

probably not worth looking at

as run_planning.sh

workspace-diamond13
-------------------

EJB3PlanningDataPersistence.java 

Reads all the tmp item stuff 

workspace-diamond14
-------------------
has 
  diamond-core
  diamond-forecasting
  diamond-planning
  diamond-pom
  
  uses com.diamond10
  uses com.dbexperts packages
  uses EJB3PlanningDataPersistence to populate planning
  data probably should be merged into workspac-diamond10.17
  
  has discrete tests
  
workspace-diamond17
-------------------
Has the latest version of javautil in it
Has hibernate persistence classes

skeletons of code for doing planning

has discrete filters for eligibility tests

workspace-diamond-2013
----------------------
From 2013
uses com.dbexperts structure
ejb3 planning data persistence
has HibernateSessionFactory and DAO.java

workspace-diamond-2016
----------------------
pretty much like diamond14

workspace-diamond-dickies
-------------------------
Wow! looks like what I just created 
com.diamond10 structure but HAS NO .java

workspace-diamond-erp
---------------------

workspace-diamond10-vaadin-crud-ejb3
------------------------------------
reverse engineered dickies into ejb3

