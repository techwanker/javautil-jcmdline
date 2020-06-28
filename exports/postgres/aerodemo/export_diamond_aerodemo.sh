export_unzipped=aerodemo.postgres.sql
zipped=${export_unzipped}.gz
set -x -e
if [ -f $zipped ] ; then
   rm $zipped
fi
set -x
pg_dump --schema aerodemo aps19 > ${export_unzipped}
ls -ltr
sleep 3
gzip $zipped $export_unzipped

if [ -f $zipped ] && [ -f $export_unzipped ] ; then
    rm $export_unzipped
fi
ls -ltr *

