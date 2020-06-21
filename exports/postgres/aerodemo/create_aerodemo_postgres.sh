database=aerodemo
set -x -e
dropdb $database 
createdb $database
psql $database <<:EOF:
\q
:EOF:

