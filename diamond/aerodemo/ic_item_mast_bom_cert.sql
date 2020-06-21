drop table aerodemo.ic_item_mast_bom_cert;

create table  aerodemo.ic_item_mast_bom_cert as  select * from interfast.ic_item_mast
where item_nbr in  (
    select item_nbr 
    from aerodemo.ic_bom_cert ic2 
    where not exists ( 
       select 'x' 
    from aerodemo.ic_item_mast iim 
       where iim.item_nbr = ic2.item_nbr
    )
    union
    select item_nbr_parent 
    from aerodemo.ic_bom_cert ic2 
    where not exists ( 
       select 'x' 
       from aerodemo.ic_item_mast iim 
       where iim.item_nbr = ic2.item_nbr_parent
    )
)
/
