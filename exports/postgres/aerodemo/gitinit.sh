set -x
 
#git init
cp ~/templates/.gitignore .gigignore
git config --global user.email "james.joseph.schmidt@gmail.com"
git remote add origin ssh://git@github.com/techwanker/postgres-diamond-demo
git remote -v
git add -A .
git commit
git push -u origin master
