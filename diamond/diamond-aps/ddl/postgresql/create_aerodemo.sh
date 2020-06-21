
psql dbname=aps19 -a -f aerodemo_tables.sql 2>&1 | tee aerodemo_tables.log
psql dbname=aps19 -v ON_ERROR_STOP=1 -a -f aerodemo_seq.sql 2>&1 | tee aerodemo_seq.log
psql dbname=aps19  -a -f aerodemo_view.sql 2>&1 | tee aerodemo_view.log
psql dbname=aps19 -v ON_ERROR_STOP=1 -a -f aerodemo_copy.sql 2>&1 | tee aerodemo_copy.log
