for f in `find . -name pom.xml` 
do
   dirname=`dirname $f`
   echo dirname $dirname
   pushd $dirname
   mvn clean
   popd
done
