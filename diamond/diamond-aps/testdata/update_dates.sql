update fc_fcst f19
set cycle = 2020 
where cycle = 2019
and not exists
(select 'x' from fc_fcst f20 
where f20.fc_item_mast_nbr = f19.fc_item_mast_nbr
and   f20.intvl = f19.intvl
and   f20.cycle = 2020
);


