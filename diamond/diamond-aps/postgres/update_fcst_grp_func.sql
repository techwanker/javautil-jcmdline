--create function update_fcst_grp(oldname varchar, newname varchar) 
--returns varchar  as
--language 'plpgsql'
--begin
   --insert into fcst_grp  (fcst_grp, fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty)
   --select newname,fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty
   --from fcst_grp where fcst_grp = oldname;
--end; 

create or replace function update_fcst_grp(oldname varchar, newname varchar) 
returns varchar  as $$
begin
   insert into fcst_grp  (fcst_grp, fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty)
   select newname,fcst_grp_descr, ut_user_nbr, last_mod_dt, oo_prty, wo_prty, ss_prty, fc_prty
   from fcst_grp where fcst_grp = oldname;
   return 'success';
end; 
$$
language 'plpgsql'
