# 

#!# create test databases

	createdb aps19
        pushd diamond/exports
        pg_restore --dbname=aps19 aps19.pg_dump
	popd

	pushd javautil-7/exports/postgres/vending_sales
        createdb sales_reporting
        pg_restore --dbname=sales_reporting sales_reporting.pg_dump
	popd

#!# Need connection information

    cat >> ~/connections_java.yaml  <<:EOF:
"integration_postgres":
    driver_class: "org.postgresql.Driver"
    url: "jdbc:postgresql://localhost/sales_reporting"
    username: "${USER}"
    password: ""
:EOF:


#!# build javautil

#! With the database and skipping tests should not be necessary

    pushd javautil-7/javautil-pom
    mvn clean install -DskipTests=true
    popd
  
#!# Build and test diamond-aps

    pushd diamond-aps
    mvn clean install

