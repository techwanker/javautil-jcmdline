export_schema() {
        if [ $# -lt 2 ] ; then
            echo usage $0 schema_name database_name >&2
            echo was $0 $*
            echo number of arguments $#
            exit 1
        fi 
        schema_name=$1
        database_name=$2
        basename=${schema_name}.postgres
	sql_file=${schema_name}.postgres.sql
        pg_restore_file=${schema_name}.pg_restore
	set -x -e
	pg_dump --schema ${schema_name} ${database_name} > ${sql_file}
        pg_dump -F c --schema ${schema_name} ${database_name} > ${pg_restore_file}

#	sleep 3
#	gzip $zipped $sql_file
#
#	if [ -f $zipped ] && [ -f $sql_file ] ; then
#    		rm $sql_file
#	fi
#	ls -ltr *
}

export_schema aerodemo aps19
