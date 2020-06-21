pushd diamond/exports
time psql aps19  -c "create database aps20"
time pg_restore --dbname=aps20 aerodemo.pg_restore
popd 
pushd javautil-7/javautil-pom
time mvn clean install -dskipTests=true
popd
cd diamond/diamond-aps
time mvn clean install


 
