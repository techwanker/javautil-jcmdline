Lead Time By Vendor
===================

Overview
--------

Vendors may have drastically different lead times.

Acquiring
---------

Data for lead times should be derived from the latest vendor quotes that is:

Note that item_nbr, the item surrogate key is not used, allowing you to 
get vendor quotes for items that have not been set up;

.. code:: sql

    create view ic_item_vnd_lead_time as
    select  item_cd_qte,
        vq_qte_dt,
        vq_qte_eff_dt,
        max(vq_qte_exp_dt) max_qte_exp_dt,
        (max(vq_qte_exp_dt) - vq_qte_eff_dt) / 7 lead_tm_wks
    from vq_qte_vw
    group by org_nbr_vnd,
        item_cd_qte,
        vq_qte_eff_dt,
        vq_qte_dt;


YAML
----

.. code:: 

ic_item_vnd_lead_tm:
   sql: > 
         create view ic_item_vnd_lead_time as
         select item_cd_qte,
              vq_qte_dt,
              vq_qte_eff_dt,
              max(vq_qte_exp_dt) max_qte_exp_dt,
              (max(vq_qte_exp_dt) - vq_qte_eff_dt) / 7 lead_tm_wks
          from vq_qte_vw
          group by org_nbr_vnd,
             item_cd_qte,
             vq_qte_eff_dt,
             vq_qte_dt;
    description: Create ic_item_vnd_lead_tm
    narrative: > 
       TODO describe consequence of using the quote expiration date, vq_qte_exp_dt 
       rather than the quote of quotation or the effectivedate of quotation. 
    
Assumptions
-----------

The most recent vendor quote for lead times will be used.

If multiple vendor quotes exist for the same quote date, the maximum
lead time will be used.

Full historical vendor quotes are useful to see trends in cost and lead
time.



Issues
------

Vendor on-time performance.

TODO flesh out


