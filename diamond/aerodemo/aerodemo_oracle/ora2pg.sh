set -x
ora2pg --conf  oracle_to_postgres.ora2pg.confi --debug --out postgres.table.sql --type TABLE
#ora2pg --conf common_diamond_aps_item_nbr.conf --debug --out aerospace_aps_data.sql --type COPY
#ora2pg --conf common_diamond.conf --debug --out diamond_tables.sql --type TABLE
#ora2pg --conf common_diamond.conf --debug --out diamond_copy.sql --type COPY


