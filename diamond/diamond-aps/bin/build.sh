set -x


rm -rf src/main/java/com/pacificdataservices/diamond/models
mvn hibernate3:hbm2java
rsync -tav --delete target/generated-sources/com/pacificdataservices/diamond/models/ src/main/java/com/pacificdataservices/diamond/models
mvn clean



mvn install


