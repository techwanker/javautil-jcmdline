
From the client machine push to the amazon instance
===================================================

::

    set -x 
    if [ -z "$amazon" ]; then
       echo "Need to set amazon to hostname"
    exit 1
    fi  
    echo amazon is $amazon
    scp  -r ../amazon-redhat ec2-user@$amazon:~/amazon-redhat
    scp  -r ../artifacts ec2-user@$amazon:~/artfifacts
    set +x 
    ssh  ec2-user@$amazon mkdir -p Downloads/oracle19/ojdbc8-full
    scp   ~/Downloads/oracle19/ojdbc8-full/* ec2-user@$amazon:Downloads/oracle19/ojdbc8-full
    scp   ../doit.sh ec2-user@$amazon:doit.sh


Install operating system requirements
=====================================

::

    sudo yum -y install git bc binutils elfutils-libelf elfutils-libelf-devel \
    fontconfig-devel glibc glibc-devel \
    java \
    ksh libaio libaio-devel \
    libgcc libnsl librdmacm-devel libstdc++ libstdc++-devel libX11 \
    libXau libxcb libXi libXrender libXrender-devel libXtst make net-tools \
    nfs-utils python3 python3-configshell python3-rtslib  \
    python3-six smartmontools sysstat targetcli wget zip 


postgres
========

::

    set -x 
    sudo amazon-linux-extras install postgresql10 vim epel -y
    sudo yum install -y postgresql-server postgresql-devel
    sudo /usr/bin/postgresql-setup --initdb

nasty hack for permissions, read the docs in sphinxdoc
------------------------------------------------------

sudo sed -i -e "s/ident/trust/" /var/lib/pgsql/data/pg\_hba.conf sudo
sed -i -e "s/peer/trust/" /var/lib/pgsql/data/pg\_hba.conf

enable and start
----------------

sudo systemctl enable postgresql sudo systemctl start postgresql

create the user and database
----------------------------

sudo su - postgres -c 'createuser ec2-user' sudo su - postgres -c
"createdb --owner ec2-user sales\_reporting"

psql -h localhost sales\_reporting

install maven
=============

set -x set -e maven\_ver='apache-maven-3.6.2'

file=\ :math:`{maven_ver}.zip    download_file=~/Downloads/`\ {file}

if [ ! -d ~/Downloads ] ; then echo creating Downloads mkdir ~/Downloads
fi

::

    **get the file if we do not have it **

if [ ! -f ${download\_file} ] ; then echo file getting
:math:`{download_file}         curl http://ftp.cixug.es/apache/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.zip  > `\ {download\_file}
else echo using ${download\_file} fi *create /opt if it does not exist*
if [ ! -d /opt ] ; then sudo mkdir /opt fi

if [ ! -d /opt/${maven\_ver} ] ; then \* file has not been unzipped do
it \* cd /opt ls -l ~/Downloads # just show tfile an size sudo unzip
${download\_file} fi

# add to path if not already specified set +e
mvn\_path=\ ``grep ${maven_ver} ~/.bashrc`` set -e if [ -z $mvn\_path] ;
then # not specified so add to .bashrc echo adding maven path echo
"PATH=/opt/:math:`{maven_ver}/bin:\$PATH" >> ~/.bashrc    else         echo not adding `\ mvn\_path
fi . ~/.bashrc echo path is now $PATH mvn --version

Oracle Install
==============

```
sudo yum -y install git bc binutils elfutils-libelf elfutils-libelf-devel \
  fontconfig-devel glibc glibc-devel ksh libaio libaio-devel \
  libgcc libnsl librdmacm-devel libstdc++ libstdc++-devel libX11 \
  libXau libxcb libXi libXrender libXrender-devel libXtst make \
  net-tools \
  nfs-utils python3 python3-configshell python3-rtslib \
  python3-six smartmontools sysstat targetcli unzip wget 
```

TODO should include actual .sh file

Oracle 19c Installation
=======================

Install os packages
===================

::

    sudo yum -y install git bc binutils elfutils-libelf elfutils-libelf-devel \
        fontconfig-devel glibc glibc-devel \
        java \
        ksh libaio libaio-devel \
        libgcc libnsl librdmacm-devel libstdc++ libstdc++-devel libX11 \
        libXau libxcb libXi libXrender libXrender-devel libXtst make net-tools \
        nfs-utils python3 python3-configshell python3-rtslib  \
        smartmontools sysstat targetcli wget zip 


    echo *****************************
    echo about to install oracle
    echo *****************************
    sleep 1
    *https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/checking-server-hardware-and-memory-configuration.html#GUID-DC04ABB6-1822-444A-AB1B-8C306079439C
    set -x
    set -e
    grep MemTotal /proc/meminfo
    grep SwapTotal /proc/meminfo
    df -h /tmp
    free
    uname -m
    df -h /dev/shm

preinstall
==========

get the package
---------------

::

    cd ~/Downloads/oracle19
     #**These files are required but are not available in redhat 8, so we take them from centos**
    wget http://mirror.centos.org/centos/7/os/x86_64/Packages/compat-libstdc++-33-3.2.3-72.el7.x86_64.rpm
    wget http://mirror.centos.org/centos/7/os/x86_64/Packages/compat-libcap1-1.10-7.el7.x86_64.rpm
    curl -o oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm \
        https://yum.oracle.com/repo/OracleLinux/OL7/latest/x86_64/getPackage/oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm

install it
----------

::

    sudo yum -y localinstall compat-libstdc++-33-3.2.3-72.el7.x86_64.rpm
    sudo yum -y localinstall compat-libcap1-1.10-7.el7.x86_64.rpm
    sudo yum -y localinstall oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm 

references
----------

-  https://oracle-base.com/articles/vm/aws-ec2-installation-of-oracle

-  https://docs.oracle.com/en/database/oracle/oracle-database/19/cwsol/checking-the-oracle-database-prerequisites-packages-configuration.html#GUID-F0F28CEB-41DD-47CF-A1FE-DCF5F557A947

-  https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/running-rpm-packages-to-install-oracle-database.html#GUID-BB7C11E3-D385-4A2F-9EAF-75F4F0AACF02

Install Oracle
==============

references
----------

-  https://docs.oracle.com/en/database/oracle/oracle-database/19/install-and-upgrade.html

-  https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/installing-the-oracle-preinstallation-rpm-from-unbreakable-linux-network.html#GUID-555F704E-BD48-4E0E-AC9D-038596601194

-  https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/running-rpm-packages-to-install-oracle-database.html#GUID-BB7C11E3-D385-4A2F-9EAF-75F4F0AACF02

   cd ~/Downloads/oracle19

   sudo yum -y localinstall compat-libcap1-1.10-7.el7.x86\_64.rpm

**bug, there is no digest it must be installed with rpm**

::

    sudo rpm -i --nodigest oracle-database-ee-19c-1.0-1.x86_64.rpm

    export CV_ASSUME_DISTID=OEL7.6

configure the database
======================

::

    sudo /etc/init.d/oracledb_ORCLCDB-19c configure


https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/checking-server-hardware-and-memory-configuration.html#GUID-DC04ABB6-1822-444A-AB1B-8C306079439C
====================================================================================================================================================================

::

    set -x
    set -e
    grep MemTotal /proc/meminfo
    grep SwapTotal /proc/meminfo
    df -h /tmp
    free
    uname -m
    df -h /dev/shm

preinstall
==========

get the package
---------------

::

    cd ~/Downloads/oracle19
    curl -o oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm https://yum.oracle.com/repo/OracleLinux/OL7/latest/x86_64/getPackage/oracle-database-preinstall-19c-1.0-1.el7.x86_64.rpm

install it
----------

# must use-skip broken because of /etc/redhat-version dependency

sudo yum -y --skip-broken localinstall
oracle-database-preinstall-19c-1.0-1.el7.x86\_64.rpm

preinstall
==========

::

    # https://oracle-base.com/articles/vm/aws-ec2-installation-of-oracle
    # https://docs.oracle.com/en/database/oracle/oracle-database/19/cwsol/checking-the-oracle-database-prerequisites-packages-configuration.html#GUID-F0F28CEB-41DD-47CF-A1FE-DCF5F557A947

#
https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/running-rpm-packages-to-install-oracle-database.html#GUID-BB7C11E3-D385-4A2F-9EAF-75F4F0AACF02

install oracle
==============

#
https://docs.oracle.com/en/database/oracle/oracle-database/19/install-and-upgrade.html
#
https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/installing-the-oracle-preinstallation-rpm-from-unbreakable-linux-network.html#GUID-555F704E-BD48-4E0E-AC9D-038596601194

#
https://docs.oracle.com/en/database/oracle/oracle-database/19/ladbi/running-rpm-packages-to-install-oracle-database.html#GUID-BB7C11E3-D385-4A2F-9EAF-75F4F0AACF02

cd ~/Downloads/oracle19

sudo yum -y localinstall compat-libcap1-1.10-7.el7.x86\_64.rpm sudo yum
-y localinstall oracle-database-ee-19c-1.0-1.x86\_64.rpm

