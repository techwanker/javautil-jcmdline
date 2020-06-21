current_dir=`basename pwd`
project=$current_dir
echo project is $project
if [ ! $project = $current_dir ] ; then
   echo project $project is not current_dir $current_dir  >&2
fi 
 
#git init
cp ~/templates/.gitignore .gigignore
git config --global user.email "james.joseph.schmidt@gmail.com"
git remote add origin ssh://git@github.com/techwanker/$project
git remote set-url origin ssh://git@github.com/techwanker/$project
git remote -v
git add -A .
git commit
exit
git push -u origin master
if [ ! $? -eq 0 ] ; then
   echo commit failed, does $project exist? >&2
fi
