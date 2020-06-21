set -x
unzipped_export=aerodemo.postgres.sql
zipped_export=${unzipped_export}.zip
unzip $zipped_export
ls -l $zipped_export 
ls -l $unzipped_export
sleep 3
if [ ! -f $unzipped_export ] ; then
 echo $unzipped_export does not exist, exiting
fi
psql --file $unzipped_export --echo-all
sleep 3
ls -l $zipped_export 
ls -l $unzipped_export
if [ -f $zipped_export ] && [ -f $unzipped_export ] ; then
   rm $unzipped_export
fi
ls -l $zipped_export 
ls -l $unzipped_export

