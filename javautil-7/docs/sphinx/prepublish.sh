set -x
for file in `find . -name "ALL.m4"`
do
    dir=`dirname $file`
    pushd $dir
    m4 ALL.md > ALL.rst
    popd
done
