file=/tmp/18.src
rm $file
for f in `find .  -name "*.java" | grep -v model`
do 
	echo $f
	cat $f >>  $file
done
sed -i "/import/d" $file
sed -i "/package/d" $file
sed -i "/^ *\*$/d"    $file
sed -i ":/\:d"  $file
sed -i ":\w*\*.*/d" $file
sed -i ":^\w*//:d" $file
set -i ":^$/d" $file
#sed -i "/ *}*/d" $file
# todo remove comments
# todo remove blank settters and getters
