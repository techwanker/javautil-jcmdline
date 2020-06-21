create view ic_item_equiv_mast_vw
as 
   select iim1.item_cd,
          iim2.item_cd as item_cd_equiv
   from ic_item_mast iim1,
        ic_item_mast iim2,
        ic_item_mast_equiv iime
   where 
        iime.item_nbr = iim1.item_nbr and
        iime.item_nbr_equiv = iim2.item_nbr;
