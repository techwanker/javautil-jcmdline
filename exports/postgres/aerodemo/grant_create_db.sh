set -x
user=$USER
echh 
target_dir=~postgres/sudocmd
sudo mkdir -p ~postgres/sudocmd
target_file=grantuser.sh
sudo cat >  $target_file <<:EOF:
alter user $USER createdb;
\q
:EOF:
sudo echo $target_file
chmod 700 $target_dir/$target_file
sudo cp $target_file $target_dir 
sudo su postgres -c "psql --file $target_dir/$target_file --echo-queries"



