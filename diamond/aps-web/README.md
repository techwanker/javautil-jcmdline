# Advanced Planning Web Services


## start services

    java -jar target/diamond...

## URLS

### planQuery


   http://localhost:8086/planQuery




   

   
#html
PlanResultController
http://localhost:8086/plan?partCd=10

# JSon
**   http://localhost:8086/icItemStat?itemNbr=43175

PlanDataController
**   http://localhost:8086/projectedPosition?group=10
**   http://localhost:8086/planData?group=10
List of Values Controller
http://localhost:8086/listOfValues?queryName=fcst_grp
   
This answer is late, but I was having the same issue. I found something that works.
In eclipse Project Explorer, right click the project name -> select "Run As" -> "Maven Build..."
In the goals, enter spring-boot:run then click Run button.

I have the STS plug-in (i.e. SpringSource Tool Suite), so on some projects I will get a "Spring Boot App" option under Run As. But, it doesn't always show up for some reason. I use the above workaround for those.
Here is a reference that explains how to run Spring boot apps:
Spring boot tutorial