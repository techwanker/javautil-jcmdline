pg_dump integration_postgres --schema-only --schema aerodemo > aeredemo_schema.sql
pg_dump integration_postgres --column-inserts --data-only --schema aerodemo > aeredemo_data.sql

