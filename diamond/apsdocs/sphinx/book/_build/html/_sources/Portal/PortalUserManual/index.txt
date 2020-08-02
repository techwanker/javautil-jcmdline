Portal User Manual
==================

.. toctree::
   :maxdepth: 2
   :caption: Contents:

.. image:: images/ActionReports.png

Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`

Action Reports
--------------

These reports showed up because you have to take some action,

Information Reports
--------------------

Information you may wish to view.


Item and Planning Group Selection
---------------------------------

Planning and filter section allows filtering on:

* Demand Shortages 

* Part # Mask	

* Part Category	

* Within Lead Time?	

* Vendor Code	

* Planning Horizon

* End Date	

* Buyer Name	

* Customer Code	

* Forecast Group	

* Manufacturer Code	

* Item Status	

* Number of Records


Planning Group Detail
---------------------

Item Masters in the Planning Group

* Demand?	
* Supply?	
* Item cd	
* Description	
* Stock Unit of Measure
* Lead Time (Days)

Technical
---------

This is a **Springboot** application.  All dependencies are in one jar file and integration testing has been completed
prior to creation of the jar file.

It is started by 

.. code:: bash

        cd ${DIAMOND_ROOT}/aps-web/target
        java -jar diamond*.jar


URLS
====

localhost:8080&partCd=an960-10				

