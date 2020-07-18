set -x
for file in `find . -name pom.xml` 
do
        echo 'file is ' $file
	pushd `dirname $file`
		pwd
		mvn eclipse:clean eclipse:eclipse
	popd
done
