#!/bin/bash
if [ $# -lt 2 ] ; then
   if [ -z $host -o -z $user ] ; then 
       echo usage `pwd`/$0  host user >&2
       exit 1
   fi
fi

host=$0
user=$1

sudo updatedb

if [ ! -f $orajar ] ; then
        echo "ojdbc8.jar [$orajar] ? $C"
        read orajar
fi

set -x -e 
orajar=~/artifacts/oracle/ojdbc8.jar
ssh ${user}@${host} "mkdir -p ~/artifacts/oracle"
scp $orajar ${user}@${host}:~/artifacts/oracle

