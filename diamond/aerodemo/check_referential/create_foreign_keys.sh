psql "dbname=aps19 options=--search_path=aerodemo" -e -f foreign_keys.sql 2>&1 | grep -v "already exists" | grep -v 'does not exist' > errors
vim errors
