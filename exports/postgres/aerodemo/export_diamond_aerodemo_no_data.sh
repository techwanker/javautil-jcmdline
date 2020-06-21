export_unzipped=aerodemo_no_data.postgres.sql
zipped=${export_unzipped}.gz
set -x -e
if [ -f $zipped ] ; then
   rm $zipped
fi
pg_dump -Cs --schema aerodemo aps19 > ${export_unzipped}
sed -e "/ALTER.*OWNER/d" -e "/Name: .*/d" -e "/-- */d"  \
	-e "s/START WITH [0-9]*/START WITH 1/" \
	-e "/^ *$/d"  \
	-e "s/without time zone/with time zone/"  \
	$export_unzipped >  aerodemo_no_data_no_owner.sql
sleep 3
exit
gzip $zipped $export_unzipped

if [ -f $zipped ] && [ -f $export_unzipped ] ; then
    rm $export_unzipped
fi
ls -ltr *

