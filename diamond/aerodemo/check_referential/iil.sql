set echo on

select count(*) from ic_item_loc;
select count(*) from ic_item_loc_box;
select count(*)  from ic_item_loc_box where ic_item_loc_nbr not in (select ic_item_loc_nbr from ic_item_loc);

delete  from ic_item_loc_box where ic_item_loc_nbr not in (select ic_item_loc_nbr from ic_item_loc);

select count(*) from ic_item_loc;
select count(*) from ic_item_loc_box;
select count(*)  from ic_item_loc_box where ic_item_loc_nbr not in (select ic_item_loc_nbr from ic_item_loc);
