insert into aps_plan_grp (plan_grp_nbr, item_nbr)  
select -1 * item_nbr, item_nbr  
from  (  
         select item_nbr from ic_item_mast  
         except  
         select item_nbr from aps_plan_grp  
      ) item_nbr_no_grp;
