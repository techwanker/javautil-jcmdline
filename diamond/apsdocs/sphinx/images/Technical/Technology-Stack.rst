===============================================
Business Process Improvement : Technology Stack
===============================================

#. `Business Process Improvement <index.html>`__
#. `Project Description <Project-Description_786630.html>`__
#. `Technical <Technical_852124.html>`__

Business Process Improvement : Technology Stack
===============================================

Created by James Schmidt, last modified on Dec 19, 2019

This is probably always out of date. We constantly upgrade to the latest
versions.

Core Technologies
-----------------

Host
~~~~

Amazon Web Services

EC2-2 `https://aws.amazon.com/ec2/ <https://aws.amazon.com/ec2/>`__

DNS
`https://aws.amazon.com/route53/ <https://aws.amazon.com/route53/>`__

Storage `https://aws.amazon.com/s3/ <https://aws.amazon.com/s3/>`__

Operating System
~~~~~~~~~~~~~~~~

Redhat 8

| [ec2-user@ip-172-31-29-84 ~]$ uname -a
| Linux ip-172-31-29-84.ec2.internal 4.18.0-80.4.2.el8\_0.x86\_64 #1 SMP
Fri Jun 14 13:20:24 UTC 2019 x86\_64 x86\_64 x86\_64 GNU/Linux
| Installed Packages

| [ec2-user@ip-172-31-29-84 ~]$ sudo yum list installed
| Installed Packages
| ``NetworkManager.x86_64                               1:1.14.0-14.el8                                   @anaconda``
| ``NetworkManager-libnm.x86_64                         1:1.14.0-14.el8                                   @anaconda``
| ``NetworkManager-team.x86_64                          1:1.14.0-14.el8                                   @anaconda``
| ``NetworkManager-tui.x86_64                           1:1.14.0-14.el8                                   @anaconda``
| ``acl.x86_64                                          2.2.53-1.el8                                      @anaconda``
| ``alsa-lib.x86_64                                     1.1.9-4.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``aopalliance.noarch                                  1.0-17.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``apache-commons-cli.noarch                           1.4-4.module+el8+2452+b359bfcd                    @rhui-rhel-8-appstream-rhui-rpms``
| ``apache-commons-codec.noarch                         1.11-3.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``apache-commons-io.noarch                            1:2.6-3.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``apache-commons-lang3.noarch                         3.7-3.module+el8+2452+b359bfcd                    @rhui-rhel-8-appstream-rhui-rpms``
| ``apache-commons-logging.noarch                       1.2-13.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``atinject.noarch                                     1-28.20100611svn86.module+el8+2452+b359bfcd       @rhui-rhel-8-appstream-rhui-rpms``
| ``atk.x86_64                                          2.28.1-1.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``audit.x86_64                                        3.0-0.10.20180831git0047a6c.el8                   @anaconda``
| ``audit-libs.x86_64                                   3.0-0.10.20180831git0047a6c.el8                   @anaconda``
| ``authselect.x86_64                                   1.0-13.el8                                        @anaconda``
| ``authselect-compat.x86_64                            1.0-13.el8                                        @koji-override-1``
| ``authselect-libs.x86_64                              1.0-13.el8                                        @anaconda``
| ``avahi-libs.x86_64                                   0.7-19.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``basesystem.noarch                                   11-5.el8                                          @anaconda``
| ``bash.x86_64                                         4.4.19-7.el8                                      @anaconda``
| ``bc.x86_64                                           1.07.1-5.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``bind-export-libs.x86_64                             32:9.11.4-17.P2.el8_0                             @anaconda``
| ``binutils.x86_64                                     2.30-58.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``brotli.x86_64                                       1.0.6-1.el8                                       @anaconda``
| ``bzip2-devel.x86_64                                  1.0.6-26.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``bzip2-libs.x86_64                                   1.0.6-26.el8                                      @anaconda``
| ``c-ares.x86_64                                       1.13.0-5.el8                                      @anaconda``
| ``ca-certificates.noarch                              2018.2.24-6.el8                                   @anaconda``
| ``cairo.x86_64                                        1.15.12-3.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``cairo-gobject.x86_64                                1.15.12-3.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``cdi-api.noarch                                      1.2-8.module+el8+2452+b359bfcd                    @rhui-rhel-8-appstream-rhui-rpms``
| ``checkpolicy.x86_64                                  2.8-2.el8                                         @anaconda``
| ``chkconfig.x86_64                                    1.11-1.el8                                        @anaconda``
| ``chrony.x86_64                                       3.3-3.el8                                         @anaconda``
| ``cloud-init.noarch                                   18.2-6.el8                                        @koji-override-1``
| ``cloud-utils-growpart.noarch                         0.29-2.el8                                        @koji-override-1``
| ``copy-jdk-configs.noarch                             3.7-1.el8                                         @rhui-rhel-8-appstream-rhui-rpms``
| ``coreutils.x86_64                                    8.30-6.el8                                        @anaconda``
| ``coreutils-common.x86_64                             8.30-6.el8                                        @anaconda``
| ``cpio.x86_64                                         2.12-8.el8                                        @anaconda``
| ``cracklib.x86_64                                     2.9.6-15.el8                                      @anaconda``
| ``cracklib-dicts.x86_64                               2.9.6-15.el8                                      @anaconda``
| ``cronie.x86_64                                       1.5.2-2.el8                                       @anaconda``
| ``cronie-anacron.x86_64                               1.5.2-2.el8                                       @anaconda``
| ``crontabs.noarch                                     1.11-16.20150630git.el8                           @anaconda``
| ``crypto-policies.noarch                              20181217-6.git9a35207.el8                         @anaconda``
| ``cryptsetup-libs.x86_64                              2.0.6-1.el8                                       @anaconda``
| ``cups-libs.x86_64                                    1:2.2.6-28.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``curl.x86_64                                         7.61.1-8.el8                                      @anaconda``
| ``cyrus-sasl-lib.x86_64                               2.1.27-0.3rc7.el8                                 @anaconda``
| ``dbus.x86_64                                         1:1.12.8-7.el8                                    @anaconda``
| ``dbus-common.noarch                                  1:1.12.8-7.el8                                    @anaconda``
| ``dbus-daemon.x86_64                                  1:1.12.8-7.el8                                    @anaconda``
| ``dbus-glib.x86_64                                    0.110-2.el8                                       @anaconda``
| ``dbus-libs.x86_64                                    1:1.12.8-7.el8                                    @anaconda``
| ``dbus-tools.x86_64                                   1:1.12.8-7.el8                                    @anaconda``
| ``dejavu-fonts-common.noarch                          2.35-6.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``dejavu-sans-fonts.noarch                            2.35-6.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``device-mapper.x86_64                                8:1.02.155-6.el8                                  @anaconda``
| ``device-mapper-libs.x86_64                           8:1.02.155-6.el8                                  @anaconda``
| ``dhcp-client.x86_64                                  12:4.3.6-30.el8                                   @anaconda``
| ``dhcp-common.noarch                                  12:4.3.6-30.el8                                   @anaconda``
| ``dhcp-libs.x86_64                                    12:4.3.6-30.el8                                   @anaconda``
| ``diffutils.x86_64                                    3.6-5.el8                                         @anaconda``
| ``dmidecode.x86_64                                    1:3.2-1.el8                                       @anaconda``
| ``dnf.noarch                                          4.0.9.2-5.el8                                     @anaconda``
| ``dnf-data.noarch                                     4.0.9.2-5.el8                                     @anaconda``
| ``dnf-plugin-spacewalk.noarch                         2.8.5-9.module+el8+2754+6a08e8f4                  @koji-override-1``
| ``dnf-plugin-subscription-manager.x86_64              1.23.8-35.el8                                     @anaconda``
| ``dnf-plugins-core.noarch                             4.0.2.2-3.el8                                     @anaconda``
| ``dnf-utils.noarch                                    4.0.2.2-3.el8                                     @anaconda``
| ``dracut.x86_64                                       049-10.git20190115.el8                            @anaconda``
| ``dracut-config-generic.x86_64                        049-10.git20190115.el8                            @anaconda``
| ``dracut-config-rescue.x86_64                         049-10.git20190115.el8                            @anaconda``
| ``dracut-network.x86_64                               049-10.git20190115.el8                            @anaconda``
| ``dracut-squash.x86_64                                049-10.git20190115.el8                            @anaconda``
| ``e2fsprogs.x86_64                                    1.44.3-2.el8                                      @anaconda``
| ``e2fsprogs-libs.x86_64                               1.44.3-2.el8                                      @anaconda``
| ``elfutils-default-yama-scope.noarch                  0.174-6.el8                                       @anaconda``
| ``elfutils-libelf.x86_64                              0.176-5.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``elfutils-libelf-devel.x86_64                        0.176-5.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``elfutils-libs.x86_64                                0.176-5.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``emacs-filesystem.noarch                             1:26.1-5.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``ethtool.x86_64                                      2:4.16-1.el8                                      @anaconda``
| ``expat.x86_64                                        2.2.5-3.el8                                       @anaconda``
| ``expat-devel.x86_64                                  2.2.5-3.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``file.x86_64                                         5.33-8.el8                                        @anaconda``
| ``file-libs.x86_64                                    5.33-8.el8                                        @anaconda``
| ``filesystem.x86_64                                   3.8-2.el8                                         @anaconda``
| ``findutils.x86_64                                    1:4.6.0-20.el8                                    @anaconda``
| ``fipscheck.x86_64                                    1.5.0-4.el8                                       @anaconda``
| ``fipscheck-lib.x86_64                                1.5.0-4.el8                                       @anaconda``
| ``fontconfig.x86_64                                   2.13.1-3.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``fontconfig-devel.x86_64                             2.13.1-3.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``fontpackages-filesystem.noarch                      1.44-22.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``freetype.x86_64                                     2.9.1-4.el8                                       @anaconda``
| ``freetype-devel.x86_64                               2.9.1-4.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``fribidi.x86_64                                      1.0.4-6.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``fuse-libs.x86_64                                    2.9.7-12.el8                                      @anaconda``
| ``gawk.x86_64                                         4.2.1-1.el8                                       @anaconda``
| ``gdbm.x86_64                                         1:1.18-1.el8                                      @anaconda``
| ``gdbm-libs.x86_64                                    1:1.18-1.el8                                      @anaconda``
| ``gdisk.x86_64                                        1.0.3-6.el8                                       @anaconda``
| ``gdk-pixbuf2.x86_64                                  2.36.12-5.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``gdk-pixbuf2-modules.x86_64                          2.36.12-5.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``geolite2-city.noarch                                20180605-1.el8                                    @koji-override-1``
| ``geolite2-country.noarch                             20180605-1.el8                                    @koji-override-1``
| ``geronimo-annotation.noarch                          1.0-23.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``gettext.x86_64                                      0.19.8.1-14.el8                                   @anaconda``
| ``gettext-libs.x86_64                                 0.19.8.1-14.el8                                   @anaconda``
| ``giflib.x86_64                                       5.1.4-3.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``git.x86_64                                          2.18.1-4.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``git-core.x86_64                                     2.18.1-4.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``git-core-doc.noarch                                 2.18.1-4.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``glassfish-el-api.noarch                             3.0.1-0.7.b08.module+el8+2452+b359bfcd            @rhui-rhel-8-appstream-rhui-rpms``
| ``glib2.x86_64                                        2.56.4-1.el8                                      @anaconda``
| ``glibc.x86_64                                        2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``glibc-common.x86_64                                 2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``glibc-devel.x86_64                                  2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``glibc-headers.x86_64                                2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``glibc-langpack-en.x86_64                            2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``gmp.x86_64                                          1:6.1.2-8.el8                                     @anaconda``
| ``gnupg2.x86_64                                       2.2.9-1.el8                                       @anaconda``
| ``gnupg2-smime.x86_64                                 2.2.9-1.el8                                       @anaconda``
| ``gnutls.x86_64                                       3.6.5-2.el8                                       @anaconda``
| ``gobject-introspection.x86_64                        1.56.1-1.el8                                      @anaconda``
| ``google-guice.noarch                                 4.1-11.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``gpgme.x86_64                                        1.10.0-6.el8                                      @anaconda``
| ``gpm-libs.x86_64                                     1.20.7-15.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``graphite2.x86_64                                    1.3.10-10.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``grep.x86_64                                         3.1-6.el8                                         @anaconda``
| ``groff-base.x86_64                                   1.22.3-18.el8                                     @anaconda``
| ``grub2-common.noarch                                 1:2.02-66.el8                                     @anaconda``
| ``grub2-pc.x86_64                                     1:2.02-66.el8                                     @anaconda``
| ``grub2-pc-modules.noarch                             1:2.02-66.el8                                     @anaconda``
| ``grub2-tools.x86_64                                  1:2.02-66.el8                                     @anaconda``
| ``grub2-tools-extra.x86_64                            1:2.02-66.el8                                     @anaconda``
| ``grub2-tools-minimal.x86_64                          1:2.02-66.el8                                     @anaconda``
| ``grubby.x86_64                                       8.40-34.el8                                       @anaconda``
| ``gssproxy.x86_64                                     0.8.0-14.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``gtk-update-icon-cache.x86_64                        3.22.30-4.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``gtk2.x86_64                                         2.24.32-4.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``guava20.noarch                                      20.0-8.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``gzip.x86_64                                         1.9-4.el8                                         @anaconda``
| ``hardlink.x86_64                                     1:1.3-6.el8                                       @anaconda``
| ``harfbuzz.x86_64                                     1.7.5-3.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``hawtjni-runtime.noarch                              1.16-2.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``hdparm.x86_64                                       9.54-2.el8                                        @anaconda``
| ``hicolor-icon-theme.noarch                           0.17-2.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``hostname.x86_64                                     3.20-6.el8                                        @anaconda``
| ``httpcomponents-client.noarch                        4.5.5-4.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``httpcomponents-core.noarch                          4.4.10-3.module+el8+2452+b359bfcd                 @rhui-rhel-8-appstream-rhui-rpms``
| ``hwdata.noarch                                       0.314-8.0.el8                                     @anaconda``
| ``ibacm.x86_64                                        22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``ima-evm-utils.x86_64                                1.1-4.el8                                         @anaconda``
| ``info.x86_64                                         6.5-4.el8                                         @anaconda``
| ``initscripts.x86_64                                  10.00.1-1.el8                                     @anaconda``
| ``insights-client.noarch                              3.0.5-4.el8                                       @koji-override-1``
| ``ipcalc.x86_64                                       0.2.4-3.el8                                       @anaconda``
| ``iproute.x86_64                                      4.18.0-11.el8                                     @anaconda``
| ``iptables-libs.x86_64                                1.8.2-9.el8_0.1                                   @anaconda``
| ``iputils.x86_64                                      20180629-1.el8                                    @anaconda``
| ``irqbalance.x86_64                                   2:1.4.0-2.el8                                     @anaconda``
| ``jansi.noarch                                        1.17.1-1.module+el8+2477+516cbbff                 @rhui-rhel-8-appstream-rhui-rpms``
| ``jansi-native.x86_64                                 1.7-7.module+el8+2452+b359bfcd                    @rhui-rhel-8-appstream-rhui-rpms``
| ``jansson.x86_64                                      2.11-3.el8                                        @anaconda``
| ``jasper-libs.x86_64                                  2.0.14-4.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``java-1.8.0-openjdk.x86_64                           1:1.8.0.232.b09-2.el8_1                           @rhui-rhel-8-appstream-rhui-rpms``
| ``java-1.8.0-openjdk-devel.x86_64                     1:1.8.0.232.b09-2.el8_1                           @rhui-rhel-8-appstream-rhui-rpms``
| ``java-1.8.0-openjdk-headless.x86_64                  1:1.8.0.232.b09-2.el8_1                           @rhui-rhel-8-appstream-rhui-rpms``
| ``javapackages-filesystem.noarch                      5.3.0-1.module+el8+2447+6f56d9a6                  @rhui-rhel-8-appstream-rhui-rpms``
| ``javapackages-tools.noarch                           5.3.0-1.module+el8+2447+6f56d9a6                  @rhui-rhel-8-appstream-rhui-rpms``
| ``jbigkit-libs.x86_64                                 2.1-14.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``jboss-interceptors-1.2-api.noarch                   1.0.0-8.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``jcl-over-slf4j.noarch                               1.7.25-4.module+el8+2452+b359bfcd                 @rhui-rhel-8-appstream-rhui-rpms``
| ``json-c.x86_64                                       0.13.1-0.2.el8                                    @anaconda``
| ``json-glib.x86_64                                    1.4.4-1.el8                                       @anaconda``
| ``jsoup.noarch                                        1.11.3-3.module+el8+2452+b359bfcd                 @rhui-rhel-8-appstream-rhui-rpms``
| ``kbd.x86_64                                          2.0.4-8.el8                                       @anaconda``
| ``kbd-legacy.noarch                                   2.0.4-8.el8                                       @anaconda``
| ``kbd-misc.noarch                                     2.0.4-8.el8                                       @anaconda``
| ``kernel.x86_64                                       4.18.0-80.4.2.el8_0                               @anaconda``
| ``kernel-core.x86_64                                  4.18.0-80.4.2.el8_0                               @anaconda``
| ``kernel-headers.x86_64                               4.18.0-147.3.1.el8_1                              @rhui-rhel-8-baseos-rhui-rpms``
| ``kernel-modules.x86_64                               4.18.0-80.4.2.el8_0                               @anaconda``
| ``kernel-tools.x86_64                                 4.18.0-80.4.2.el8_0                               @anaconda``
| ``kernel-tools-libs.x86_64                            4.18.0-80.4.2.el8_0                               @anaconda``
| ``kexec-tools.x86_64                                  2.0.17-28.el8                                     @anaconda``
| ``keyutils.x86_64                                     1.5.10-6.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``keyutils-libs.x86_64                                1.5.10-6.el8                                      @anaconda``
| ``kmod.x86_64                                         25-11.el8_0.2                                     @anaconda``
| ``kmod-libs.x86_64                                    25-11.el8_0.2                                     @anaconda``
| ``kpartx.x86_64                                       0.7.8-7.el8                                       @anaconda``
| ``krb5-libs.x86_64                                    1.16.1-22.el8                                     @anaconda``
| ``ksh.x86_64                                          20120801-252.el8                                  @rhui-rhel-8-appstream-rhui-rpms``
| ``langpacks-en.noarch                                 1.0-12.el8                                        @koji-override-1``
| ``less.x86_64                                         530-1.el8                                         @anaconda``
| ``libX11.x86_64                                       1.6.7-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libX11-common.noarch                                1.6.7-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libX11-devel.x86_64                                 1.6.7-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libX11-xcb.x86_64                                   1.6.7-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXau.x86_64                                       1.0.8-13.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXau-devel.x86_64                                 1.0.8-13.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXcomposite.x86_64                                0.4.4-14.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXcursor.x86_64                                   1.1.15-3.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXdamage.x86_64                                   1.1.4-14.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXext.x86_64                                      1.3.3-9.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXfixes.x86_64                                    5.0.3-7.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXft.x86_64                                       2.3.2-10.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXi.x86_64                                        1.7.9-7.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXinerama.x86_64                                  1.1.4-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXrandr.x86_64                                    1.5.1-7.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libXrender.x86_64                                   0.9.10-7.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXrender-devel.x86_64                             0.9.10-7.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libXtst.x86_64                                      1.2.3-7.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libacl.x86_64                                       2.2.53-1.el8                                      @anaconda``
| ``libaio.x86_64                                       0.3.112-1.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``libaio-devel.x86_64                                 0.3.112-1.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``libarchive.x86_64                                   3.3.2-3.el8                                       @anaconda``
| ``libassuan.x86_64                                    2.5.1-3.el8                                       @anaconda``
| ``libattr.x86_64                                      2.4.48-3.el8                                      @anaconda``
| ``libbasicobjects.x86_64                              0.1.1-39.el8                                      @anaconda``
| ``libblkid.x86_64                                     2.32.1-8.el8                                      @anaconda``
| ``libcap.x86_64                                       2.25-9.el8                                        @anaconda``
| ``libcap-ng.x86_64                                    0.7.9-4.el8                                       @anaconda``
| ``libcollection.x86_64                                0.7.0-39.el8                                      @anaconda``
| ``libcom_err.x86_64                                   1.44.3-2.el8                                      @anaconda``
| ``libcomps.x86_64                                     0.1.8-13.el8                                      @anaconda``
| ``libcroco.x86_64                                     0.6.12-4.el8                                      @anaconda``
| ``libcurl.x86_64                                      7.61.1-8.el8                                      @anaconda``
| ``libdaemon.x86_64                                    0.14-15.el8                                       @anaconda``
| ``libdatrie.x86_64                                    0.2.9-7.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libdb.x86_64                                        5.3.28-36.el8                                     @anaconda``
| ``libdb-utils.x86_64                                  5.3.28-36.el8                                     @anaconda``
| ``libdhash.x86_64                                     0.5.0-39.el8                                      @anaconda``
| ``libdnf.x86_64                                       0.22.5-5.el8_0                                    @anaconda``
| ``libedit.x86_64                                      3.1-23.20170329cvs.el8                            @anaconda``
| ``libestr.x86_64                                      0.1.10-1.el8                                      @koji-override-1``
| ``libevent.x86_64                                     2.1.8-5.el8                                       @anaconda``
| ``libfastjson.x86_64                                  0.99.8-2.el8                                      @koji-override-1``
| ``libfdisk.x86_64                                     2.32.1-8.el8                                      @anaconda``
| ``libffi.x86_64                                       3.1-18.el8                                        @anaconda``
| ``libfontenc.x86_64                                   1.1.3-8.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``libgcc.x86_64                                       8.3.1-4.5.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``libgcrypt.x86_64                                    1.8.3-2.el8                                       @anaconda``
| ``libgomp.x86_64                                      8.2.1-3.5.el8                                     @anaconda``
| ``libgpg-error.x86_64                                 1.31-1.el8                                        @anaconda``
| ``libgudev.x86_64                                     232-4.el8                                         @anaconda``
| ``libibumad.x86_64                                    22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``libibverbs.x86_64                                   22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``libidn2.x86_64                                      2.0.5-1.el8                                       @anaconda``
| ``libini_config.x86_64                                1.3.1-39.el8                                      @anaconda``
| ``libjpeg-turbo.x86_64                                1.5.3-10.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libkcapi.x86_64                                     1.1.1-16_1.el8                                    @anaconda``
| ``libkcapi-hmaccalc.x86_64                            1.1.1-16_1.el8                                    @anaconda``
| ``libksba.x86_64                                      1.3.5-7.el8                                       @anaconda``
| ``libldb.x86_64                                       1.4.2-2.el8                                       @anaconda``
| ``libmaxminddb.x86_64                                 1.2.0-6.el8                                       @koji-override-1``
| ``libmetalink.x86_64                                  0.1.3-7.el8                                       @anaconda``
| ``libmnl.x86_64                                       1.0.4-6.el8                                       @anaconda``
| ``libmodulemd1.x86_64                                 1.8.0-5.el8                                       @anaconda``
| ``libmount.x86_64                                     2.32.1-8.el8                                      @anaconda``
| ``libndp.x86_64                                       1.6-6.el8                                         @anaconda``
| ``libnfsidmap.x86_64                                  1:2.3.3-14.el8_0                                  @anaconda``
| ``libnghttp2.x86_64                                   1.33.0-1.el8                                      @anaconda``
| ``libnl3.x86_64                                       3.4.0-4.el8                                       @anaconda``
| ``libnl3-cli.x86_64                                   3.4.0-4.el8                                       @anaconda``
| ``libnsl.x86_64                                       2.28-72.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``libnsl2.x86_64                                      1.2.0-2.20180605git4a062cf.el8                    @anaconda``
| ``libpath_utils.x86_64                                0.2.1-39.el8                                      @anaconda``
| ``libpcap.x86_64                                      14:1.9.0-1.el8                                    @anaconda``
| ``libpipeline.x86_64                                  1.5.0-2.el8                                       @anaconda``
| ``libpkgconf.x86_64                                   1.4.2-1.el8                                       @anaconda``
| ``libpng.x86_64                                       2:1.6.34-5.el8                                    @anaconda``
| ``libpng-devel.x86_64                                 2:1.6.34-5.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``libpq.x86_64                                        10.5-1.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``libpq-devel.x86_64                                  10.5-1.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``libpsl.x86_64                                       0.20.2-5.el8                                      @anaconda``
| ``libpwquality.x86_64                                 1.4.0-9.el8                                       @anaconda``
| ``librdmacm.x86_64                                    22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``libref_array.x86_64                                 0.1.5-39.el8                                      @anaconda``
| ``librepo.x86_64                                      1.9.2-1.el8                                       @anaconda``
| ``libreport-filesystem.x86_64                         2.9.5-6.el8                                       @anaconda``
| ``librhsm.x86_64                                      0.0.3-2.el8                                       @anaconda``
| ``libseccomp.x86_64                                   2.3.3-3.el8                                       @anaconda``
| ``libsecret.x86_64                                    0.18.6-1.el8                                      @anaconda``
| ``libselinux.x86_64                                   2.8-6.el8                                         @anaconda``
| ``libselinux-utils.x86_64                             2.8-6.el8                                         @anaconda``
| ``libsemanage.x86_64                                  2.8-5.el8                                         @anaconda``
| ``libsepol.x86_64                                     2.8-2.el8                                         @anaconda``
| ``libsigsegv.x86_64                                   2.11-5.el8                                        @anaconda``
| ``libsmartcols.x86_64                                 2.32.1-8.el8                                      @anaconda``
| ``libsolv.x86_64                                      0.6.35-6.el8                                      @anaconda``
| ``libss.x86_64                                        1.44.3-2.el8                                      @anaconda``
| ``libssh.x86_64                                       0.8.5-2.el8                                       @anaconda``
| ``libsss_autofs.x86_64                                2.0.0-43.el8_0.3                                  @anaconda``
| ``libsss_certmap.x86_64                               2.0.0-43.el8_0.3                                  @anaconda``
| ``libsss_idmap.x86_64                                 2.0.0-43.el8_0.3                                  @anaconda``
| ``libsss_nss_idmap.x86_64                             2.0.0-43.el8_0.3                                  @anaconda``
| ``libsss_sudo.x86_64                                  2.0.0-43.el8_0.3                                  @anaconda``
| ``libstdc++.x86_64                                    8.3.1-4.5.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``libstdc++-devel.x86_64                              8.3.1-4.5.el8                                     @rhui-rhel-8-appstream-rhui-rpms``
| ``libsysfs.x86_64                                     2.1.0-24.el8                                      @anaconda``
| ``libtalloc.x86_64                                    2.1.14-3.el8                                      @anaconda``
| ``libtasn1.x86_64                                     4.13-3.el8                                        @anaconda``
| ``libtdb.x86_64                                       1.3.16-3.el8                                      @anaconda``
| ``libteam.x86_64                                      1.27-10.el8                                       @anaconda``
| ``libtevent.x86_64                                    0.9.37-2.el8                                      @anaconda``
| ``libthai.x86_64                                      0.1.27-2.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libtiff.x86_64                                      4.0.9-15.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``libtirpc.x86_64                                     1.1.4-3.el8                                       @anaconda``
| ``libunistring.x86_64                                 0.9.9-3.el8                                       @anaconda``
| ``libusbx.x86_64                                      1.0.22-1.el8                                      @anaconda``
| ``libuser.x86_64                                      0.62-21.el8                                       @anaconda``
| ``libutempter.x86_64                                  1.1.6-14.el8                                      @anaconda``
| ``libuuid.x86_64                                      2.32.1-8.el8                                      @anaconda``
| ``libuuid-devel.x86_64                                2.32.1-8.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``libverto.x86_64                                     0.3.0-5.el8                                       @anaconda``
| ``libverto-libevent.x86_64                            0.3.0-5.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``libxcb.x86_64                                       1.13-5.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``libxcb-devel.x86_64                                 1.13-5.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``libxcrypt.x86_64                                    4.1.1-4.el8                                       @anaconda``
| ``libxcrypt-devel.x86_64                              4.1.1-4.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``libxkbcommon.x86_64                                 0.8.2-1.el8                                       @koji-override-1``
| ``libxml2.x86_64                                      2.9.7-5.el8                                       @anaconda``
| ``libyaml.x86_64                                      0.1.7-5.el8                                       @anaconda``
| ``lksctp-tools.x86_64                                 1.0.18-3.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``lm_sensors-libs.x86_64                              3.4.0-20.20180522git70f7e08.el8                   @rhui-rhel-8-baseos-rhui-rpms``
| ``logrotate.x86_64                                    3.14.0-3.el8                                      @anaconda``
| ``lshw.x86_64                                         B.02.18-16.el8                                    @anaconda``
| ``lsscsi.x86_64                                       0.30-1.el8                                        @anaconda``
| ``lua.x86_64                                          5.3.4-10.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``lua-libs.x86_64                                     5.3.4-10.el8                                      @anaconda``
| ``lz4-libs.x86_64                                     1.8.1.2-4.el8                                     @anaconda``
| ``lzo.x86_64                                          2.08-14.el8                                       @anaconda``
| ``make.x86_64                                         1:4.2.1-9.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``man-db.x86_64                                       2.7.6.1-17.el8                                    @anaconda``
| ``maven.noarch                                        1:3.5.4-5.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-lib.noarch                                    1:3.5.4-5.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-api.noarch                           1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-connector-basic.noarch               1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-impl.noarch                          1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-spi.noarch                           1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-transport-wagon.noarch               1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-resolver-util.noarch                          1:1.1.1-2.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-shared-utils.noarch                           3.2.1-0.1.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-wagon-file.noarch                             3.1.0-1.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-wagon-http.noarch                             3.1.0-1.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-wagon-http-shared.noarch                      3.1.0-1.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``maven-wagon-provider-api.noarch                     3.1.0-1.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``microcode_ctl.x86_64                                4:20180807a-2.20190514a.2.el8_0                   @anaconda``
| ``mlocate.x86_64                                      0.26-20.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``mozjs52.x86_64                                      52.9.0-1.el8                                      @anaconda``
| ``mpfr.x86_64                                         3.1.6-1.el8                                       @anaconda``
| ``ncurses.x86_64                                      6.1-7.20180224.el8                                @anaconda``
| ``ncurses-base.noarch                                 6.1-7.20180224.el8                                @anaconda``
| ``ncurses-libs.x86_64                                 6.1-7.20180224.el8                                @anaconda``
| ``net-tools.x86_64                                    2.0-0.51.20160912git.el8                          @anaconda``
| ``nettle.x86_64                                       3.4.1-1.el8                                       @anaconda``
| ``newt.x86_64                                         0.52.20-9.el8                                     @anaconda``
| ``nfs-utils.x86_64                                    1:2.3.3-26.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``npth.x86_64                                         1.5-4.el8                                         @anaconda``
| ``numactl-libs.x86_64                                 2.0.12-2.el8                                      @anaconda``
| ``openldap.x86_64                                     2.4.46-9.el8                                      @anaconda``
| ``openssh.x86_64                                      7.8p1-4.el8                                       @anaconda``
| ``openssh-clients.x86_64                              7.8p1-4.el8                                       @anaconda``
| ``openssh-server.x86_64                               7.8p1-4.el8                                       @anaconda``
| ``openssl.x86_64                                      1:1.1.1-8.el8                                     @anaconda``
| ``openssl-libs.x86_64                                 1:1.1.1-8.el8                                     @anaconda``
| ``openssl-pkcs11.x86_64                               0.4.8-2.el8                                       @anaconda``
| ``os-prober.x86_64                                    1.74-6.el8                                        @anaconda``
| ``p11-kit.x86_64                                      0.23.14-5.el8_0                                   @anaconda``
| ``p11-kit-trust.x86_64                                0.23.14-5.el8_0                                   @anaconda``
| ``pam.x86_64                                          1.3.1-4.el8                                       @anaconda``
| ``pango.x86_64                                        1.42.4-6.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``parted.x86_64                                       3.2-36.el8                                        @anaconda``
| ``passwd.x86_64                                       0.80-2.el8                                        @anaconda``
| ``pciutils.x86_64                                     3.5.6-4.el8                                       @anaconda``
| ``pciutils-libs.x86_64                                3.5.6-4.el8                                       @anaconda``
| ``pcre.x86_64                                         8.42-4.el8                                        @anaconda``
| ``pcre2.x86_64                                        10.32-1.el8                                       @anaconda``
| ``perl-Carp.noarch                                    1.42-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Data-Dumper.x86_64                             2.167-399.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Digest.noarch                                  1.17-395.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Digest-MD5.x86_64                              2.55-396.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Encode.x86_64                                  4:2.97-3.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Errno.x86_64                                   1.28-416.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Error.noarch                                   1:0.17025-2.el8                                   @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Exporter.noarch                                5.72-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-File-Path.noarch                               2.15-2.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-File-Temp.noarch                               0.230.600-1.el8                                   @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Getopt-Long.noarch                             1:2.50-4.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Git.noarch                                     2.18.1-4.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-HTTP-Tiny.noarch                               0.074-1.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-IO.x86_64                                      1.38-416.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-IO-Socket-IP.noarch                            0.39-5.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-IO-Socket-SSL.noarch                           2.066-3.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-MIME-Base64.x86_64                             3.15-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Mozilla-CA.noarch                              20160104-7.el8                                    @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Net-SSLeay.x86_64                              1.88-1.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-PathTools.x86_64                               3.74-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Pod-Escapes.noarch                             1:1.07-395.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Pod-Perldoc.noarch                             3.28-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Pod-Simple.noarch                              1:3.35-395.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Pod-Usage.noarch                               4:1.69-395.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Scalar-List-Utils.x86_64                       3:1.49-2.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Socket.x86_64                                  4:2.027-3.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Storable.x86_64                                1:3.11-3.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Term-ANSIColor.noarch                          4.06-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Term-Cap.noarch                                1.17-395.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-TermReadKey.x86_64                             2.37-7.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Text-ParseWords.noarch                         3.30-395.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Text-Tabs+Wrap.noarch                          2013.0523-395.el8                                 @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-Time-Local.noarch                              1:1.280-1.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-URI.noarch                                     1.73-3.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-Unicode-Normalize.x86_64                       1.25-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-constant.noarch                                1.33-396.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-interpreter.x86_64                             4:5.26.3-416.el8                                  @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-libnet.noarch                                  3.11-3.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``perl-libs.x86_64                                    4:5.26.3-416.el8                                  @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-macros.x86_64                                  4:5.26.3-416.el8                                  @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-parent.noarch                                  1:0.237-1.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-podlators.noarch                               4.11-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-threads.x86_64                                 1:2.21-2.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``perl-threads-shared.x86_64                          1.58-2.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``pigz.x86_64                                         2.4-2.el8                                         @anaconda``
| ``pinentry.x86_64                                     1.1.0-2.el8                                       @koji-override-1``
| ``pixman.x86_64                                       0.36.0-1.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``pkgconf.x86_64                                      1.4.2-1.el8                                       @anaconda``
| ``pkgconf-m4.noarch                                   1.4.2-1.el8                                       @anaconda``
| ``pkgconf-pkg-config.x86_64                           1.4.2-1.el8                                       @anaconda``
| ``platform-python.x86_64                              3.6.8-2.el8_0                                     @anaconda``
| ``platform-python-pip.noarch                          9.0.3-13.el8                                      @anaconda``
| ``platform-python-setuptools.noarch                   39.2.0-4.el8                                      @anaconda``
| ``plexus-cipher.noarch                                1.7-14.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``plexus-classworlds.noarch                           2.5.2-9.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``plexus-containers-component-annotations.noarch      1.7.1-8.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``plexus-interpolation.noarch                         1.22-9.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``plexus-sec-dispatcher.noarch                        1.4-26.module+el8+2452+b359bfcd                   @rhui-rhel-8-appstream-rhui-rpms``
| ``plexus-utils.noarch                                 3.1.0-3.module+el8+2452+b359bfcd                  @rhui-rhel-8-appstream-rhui-rpms``
| ``policycoreutils.x86_64                              2.8-16.1.el8                                      @anaconda``
| ``polkit.x86_64                                       0.115-6.el8                                       @anaconda``
| ``polkit-libs.x86_64                                  0.115-6.el8                                       @anaconda``
| ``polkit-pkla-compat.x86_64                           0.1-12.el8                                        @anaconda``
| ``popt.x86_64                                         1.16-14.el8                                       @anaconda``
| ``postgresql.x86_64                                   10.6-1.module+el8+2469+5ecd5aae                   @rhui-rhel-8-appstream-rhui-rpms``
| ``postgresql-server.x86_64                            10.6-1.module+el8+2469+5ecd5aae                   @rhui-rhel-8-appstream-rhui-rpms``
| ``prefixdevname.x86_64                                0.1.0-6.el8                                       @anaconda``
| ``procps-ng.x86_64                                    3.3.15-1.el8                                      @anaconda``
| ``publicsuffix-list.noarch                            20180723-1.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``publicsuffix-list-dafsa.noarch                      20180723-1.el8                                    @anaconda``
| ``python3-asn1crypto.noarch                           0.24.0-3.el8                                      @anaconda``
| ``python3-audit.x86_64                                3.0-0.10.20180831git0047a6c.el8                   @anaconda``
| ``python3-babel.noarch                                2.5.1-3.el8                                       @koji-override-1``
| ``python3-cairo.x86_64                                1.16.3-6.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``python3-cffi.x86_64                                 1.11.5-5.el8                                      @anaconda``
| ``python3-chardet.noarch                              3.0.4-7.el8                                       @anaconda``
| ``python3-configobj.noarch                            5.0.6-11.el8                                      @anaconda``
| ``python3-configshell.noarch                          1:1.1.fb25-1.el8                                  @rhui-rhel-8-baseos-rhui-rpms``
| ``python3-cryptography.x86_64                         2.3-2.el8                                         @anaconda``
| ``python3-dateutil.noarch                             1:2.6.1-6.el8                                     @anaconda``
| ``python3-dbus.x86_64                                 1.2.4-14.el8                                      @anaconda``
| ``python3-decorator.noarch                            4.2.1-2.el8                                       @anaconda``
| ``python3-dmidecode.x86_64                            3.12.2-13.el8                                     @anaconda``
| ``python3-dnf.noarch                                  4.0.9.2-5.el8                                     @anaconda``
| ``python3-dnf-plugin-spacewalk.noarch                 2.8.5-9.module+el8+2754+6a08e8f4                  @koji-override-1``
| ``python3-dnf-plugins-core.noarch                     4.0.2.2-3.el8                                     @anaconda``
| ``python3-ethtool.x86_64                              0.14-3.el8                                        @anaconda``
| ``python3-gobject.x86_64                              3.28.3-1.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``python3-gobject-base.x86_64                         3.28.3-1.el8                                      @anaconda``
| ``python3-gpg.x86_64                                  1.10.0-6.el8                                      @anaconda``
| ``python3-hawkey.x86_64                               0.22.5-5.el8_0                                    @anaconda``
| ``python3-hwdata.noarch                               2.3.6-3.el8                                       @koji-override-1``
| ``python3-idna.noarch                                 2.5-5.el8                                         @anaconda``
| ``python3-iniparse.noarch                             0.4-31.el8                                        @anaconda``
| ``python3-inotify.noarch                              0.9.6-13.el8                                      @anaconda``
| ``python3-jinja2.noarch                               2.10.1-2.el8_0                                    @koji-override-1``
| ``python3-jsonpatch.noarch                            1.21-2.el8                                        @koji-override-1``
| ``python3-jsonpointer.noarch                          1.10-11.el8                                       @koji-override-1``
| ``python3-jsonschema.noarch                           2.6.0-4.el8                                       @koji-override-1``
| ``python3-jwt.noarch                                  1.6.1-2.el8                                       @anaconda``
| ``python3-kmod.x86_64                                 0.9-20.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``python3-libcomps.x86_64                             0.1.8-13.el8                                      @anaconda``
| ``python3-libdnf.x86_64                               0.22.5-5.el8_0                                    @anaconda``
| ``python3-librepo.x86_64                              1.9.2-1.el8                                       @anaconda``
| ``python3-libs.x86_64                                 3.6.8-2.el8_0                                     @anaconda``
| ``python3-libselinux.x86_64                           2.8-6.el8                                         @anaconda``
| ``python3-libsemanage.x86_64                          2.8-5.el8                                         @anaconda``
| ``python3-libxml2.x86_64                              2.9.7-5.el8                                       @anaconda``
| ``python3-linux-procfs.noarch                         0.6-6.el8                                         @anaconda``
| ``python3-magic.noarch                                5.33-8.el8                                        @anaconda``
| ``python3-markupsafe.x86_64                           0.23-19.el8                                       @koji-override-1``
| ``python3-netifaces.x86_64                            0.10.6-4.el8                                      @koji-override-1``
| ``python3-newt.x86_64                                 0.52.20-9.el8                                     @koji-override-1``
| ``python3-oauthlib.noarch                             2.1.0-1.el8                                       @anaconda``
| ``python3-perf.x86_64                                 4.18.0-80.4.2.el8_0                               @anaconda``
| ``python3-pip.noarch                                  9.0.3-13.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``python3-ply.noarch                                  3.9-7.el8                                         @anaconda``
| ``python3-policycoreutils.noarch                      2.8-16.1.el8                                      @anaconda``
| ``python3-prettytable.noarch                          0.7.2-14.el8                                      @koji-override-1``
| ``python3-pyOpenSSL.noarch                            18.0.0-1.el8                                      @koji-override-1``
| ``python3-pycparser.noarch                            2.14-14.el8                                       @anaconda``
| ``python3-pyparsing.noarch                            2.1.10-7.el8                                      @rhui-rhel-8-baseos-rhui-rpms``
| ``python3-pyserial.noarch                             3.1.1-8.el8                                       @koji-override-1``
| ``python3-pysocks.noarch                              1.6.8-3.el8                                       @anaconda``
| ``python3-pytz.noarch                                 2017.2-9.el8                                      @koji-override-1``
| ``python3-pyudev.noarch                               0.21.0-7.el8                                      @anaconda``
| ``python3-pyyaml.x86_64                               3.12-12.el8                                       @anaconda``
| ``python3-requests.noarch                             2.20.0-1.el8                                      @anaconda``
| ``python3-rhn-check.x86_64                            2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``python3-rhn-client-tools.x86_64                     2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``python3-rhn-setup.x86_64                            2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``python3-rhnlib.noarch                               2.8.6-7.module+el8+2754+6a08e8f4                  @koji-override-1``
| ``python3-rpm.x86_64                                  4.14.2-9.el8                                      @anaconda``
| ``python3-rtslib.noarch                               2.1.fb69-3.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``python3-schedutils.x86_64                           0.6-5.el8                                         @anaconda``
| ``python3-setools.x86_64                              4.2.0-2.el8                                       @anaconda``
| ``python3-setuptools.noarch                           39.2.0-4.el8                                      @anaconda``
| ``python3-six.noarch                                  1.11.0-8.el8                                      @anaconda``
| ``python3-subscription-manager-rhsm.x86_64            1.23.8-35.el8                                     @anaconda``
| ``python3-syspurpose.x86_64                           1.23.8-35.el8                                     @anaconda``
| ``python3-unbound.x86_64                              1.7.3-8.el8                                       @koji-override-1``
| ``python3-urllib3.noarch                              1.23-5.el8                                        @anaconda``
| ``python3-urwid.x86_64                                1.3.1-4.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``python36.x86_64                                     3.6.8-2.module+el8.1.0+3334+5cb623d7              @rhui-rhel-8-appstream-rhui-rpms``
| ``qemu-guest-agent.x86_64                             15:2.12.0-64.module+el8.0.0+3180+d6a3561d.2       @koji-override-1``
| ``quota.x86_64                                        1:4.04-10.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``quota-nls.noarch                                    1:4.04-10.el8                                     @rhui-rhel-8-baseos-rhui-rpms``
| ``rdma-core.x86_64                                    22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``rdma-core-devel.x86_64                              22.3-1.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``readline.x86_64                                     7.0-10.el8                                        @anaconda``
| ``redhat-release.x86_64                               8.0-0.44.el8                                      @anaconda``
| ``redhat-release-eula.x86_64                          8.0-0.44.el8                                      @anaconda``
| ``rh-amazon-rhui-client.noarch                        3.0.17-1.el8                                      @koji-override-2``
| ``rhn-check.x86_64                                    2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``rhn-client-tools.x86_64                             2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``rhn-setup.x86_64                                    2.8.16-12.module+el8+2754+6a08e8f4                @koji-override-1``
| ``rhnlib.noarch                                       2.8.6-7.module+el8+2754+6a08e8f4                  @koji-override-1``
| ``rhnsd.x86_64                                        5.0.35-3.module+el8+2754+6a08e8f4                 @koji-override-1``
| ``rng-tools.x86_64                                    6.6-2.el8                                         @anaconda``
| ``rootfiles.noarch                                    8.1-22.el8                                        @anaconda``
| ``rpcbind.x86_64                                      1.2.5-4.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``rpm.x86_64                                          4.14.2-9.el8                                      @anaconda``
| ``rpm-build-libs.x86_64                               4.14.2-9.el8                                      @anaconda``
| ``rpm-libs.x86_64                                     4.14.2-9.el8                                      @anaconda``
| ``rpm-plugin-selinux.x86_64                           4.14.2-9.el8                                      @anaconda``
| ``rpm-plugin-systemd-inhibit.x86_64                   4.14.2-9.el8                                      @anaconda``
| ``rsync.x86_64                                        3.1.3-4.el8                                       @anaconda``
| ``rsyslog.x86_64                                      8.37.0-9.el8                                      @koji-override-1``
| ``sed.x86_64                                          4.5-1.el8                                         @anaconda``
| ``selinux-policy.noarch                               3.14.1-61.el8_0.1                                 @anaconda``
| ``selinux-policy-targeted.noarch                      3.14.1-61.el8_0.1                                 @anaconda``
| ``setup.noarch                                        2.12.2-2.el8                                      @anaconda``
| ``sg3_utils.x86_64                                    1.44-2.el8                                        @anaconda``
| ``sg3_utils-libs.x86_64                               1.44-2.el8                                        @anaconda``
| ``shadow-utils.x86_64                                 2:4.6-7.el8                                       @anaconda``
| ``shared-mime-info.x86_64                             1.9-3.el8                                         @anaconda``
| ``sisu-inject.noarch                                  1:0.3.3-6.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``sisu-plexus.noarch                                  1:0.3.3-6.module+el8+2452+b359bfcd                @rhui-rhel-8-appstream-rhui-rpms``
| ``slang.x86_64                                        2.3.2-3.el8                                       @anaconda``
| ``slf4j.noarch                                        1.7.25-4.module+el8+2452+b359bfcd                 @rhui-rhel-8-appstream-rhui-rpms``
| ``smartmontools.x86_64                                1:6.6-3.el8                                       @rhui-rhel-8-baseos-rhui-rpms``
| ``snappy.x86_64                                       1.1.7-5.el8                                       @anaconda``
| ``sqlite-libs.x86_64                                  3.26.0-3.el8                                      @anaconda``
| ``squashfs-tools.x86_64                               4.3-17.el8                                        @anaconda``
| ``sssd-client.x86_64                                  2.0.0-43.el8_0.3                                  @anaconda``
| ``sssd-common.x86_64                                  2.0.0-43.el8_0.3                                  @anaconda``
| ``sssd-kcm.x86_64                                     2.0.0-43.el8_0.3                                  @anaconda``
| ``sssd-nfs-idmap.x86_64                               2.0.0-43.el8_0.3                                  @anaconda``
| ``subscription-manager.x86_64                         1.23.8-35.el8                                     @anaconda``
| ``subscription-manager-rhsm-certificates.x86_64       1.23.8-35.el8                                     @anaconda``
| ``sudo.x86_64                                         1.8.25p1-4.el8                                    @anaconda``
| ``sysstat.x86_64                                      11.7.3-2.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``systemd.x86_64                                      239-13.el8_0.5                                    @anaconda``
| ``systemd-libs.x86_64                                 239-13.el8_0.5                                    @anaconda``
| ``systemd-pam.x86_64                                  239-13.el8_0.5                                    @anaconda``
| ``systemd-udev.x86_64                                 239-13.el8_0.5                                    @anaconda``
| ``tar.x86_64                                          2:1.30-4.el8                                      @anaconda``
| ``target-restore.noarch                               2.1.fb69-3.el8                                    @rhui-rhel-8-baseos-rhui-rpms``
| ``targetcli.noarch                                    2.1.fb49-1.el8                                    @rhui-rhel-8-appstream-rhui-rpms``
| ``teamd.x86_64                                        1.27-10.el8                                       @anaconda``
| ``timedatex.x86_64                                    0.5-3.el8                                         @anaconda``
| ``trousers.x86_64                                     0.3.14-2.el8                                      @anaconda``
| ``trousers-lib.x86_64                                 0.3.14-2.el8                                      @anaconda``
| ``ttmkfdir.x86_64                                     3.0.9-54.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``tuned.noarch                                        2.10.0-15.el8                                     @anaconda``
| ``tzdata.noarch                                       2019a-1.el8                                       @anaconda``
| ``tzdata-java.noarch                                  2019c-1.el8                                       @rhui-rhel-8-appstream-rhui-rpms``
| ``unbound-libs.x86_64                                 1.7.3-8.el8                                       @koji-override-1``
| ``unzip.x86_64                                        6.0-41.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``usermode.x86_64                                     1.113-1.el8                                       @anaconda``
| ``util-linux.x86_64                                   2.32.1-8.el8                                      @anaconda``
| ``vim-common.x86_64                                   2:8.0.1763-13.el8                                 @rhui-rhel-8-appstream-rhui-rpms``
| ``vim-enhanced.x86_64                                 2:8.0.1763-13.el8                                 @rhui-rhel-8-appstream-rhui-rpms``
| ``vim-filesystem.noarch                               2:8.0.1763-13.el8                                 @rhui-rhel-8-appstream-rhui-rpms``
| ``vim-minimal.x86_64                                  2:8.0.1763-10.el8                                 @anaconda``
| ``virt-what.x86_64                                    1.18-6.el8                                        @anaconda``
| ``wget.x86_64                                         1.19.5-8.el8_1.1                                  @rhui-rhel-8-appstream-rhui-rpms``
| ``which.x86_64                                        2.21-10.el8                                       @anaconda``
| ``xfsprogs.x86_64                                     4.19.0-2.el8                                      @anaconda``
| ``xkeyboard-config.noarch                             2.24-3.el8                                        @koji-override-1``
| ``xorg-x11-font-utils.x86_64                          1:7.5-40.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``xorg-x11-fonts-Type1.noarch                         7.5-19.el8                                        @rhui-rhel-8-appstream-rhui-rpms``
| ``xorg-x11-proto-devel.noarch                         2018.4-1.el8                                      @rhui-rhel-8-appstream-rhui-rpms``
| ``xz.x86_64                                           5.2.4-3.el8                                       @anaconda``
| ``xz-libs.x86_64                                      5.2.4-3.el8                                       @anaconda``
| ``yum.noarch                                          4.0.9.2-5.el8                                     @anaconda``
| ``zip.x86_64                                          3.0-23.el8                                        @rhui-rhel-8-baseos-rhui-rpms``
| ``zlib.x86_64                                         1.2.11-10.el8                                     @anaconda``
| ``zlib-devel.x86_64                                   1.2.11-10.el8                                     @rhui-rhel-8-baseos-rhui-rpms``

Build tool Maven
~~~~~~~~~~~~~~~~

Apache Maven 3.6.3

Source Change Management
~~~~~~~~~~~~~~~~~~~~~~~~

git version 1.8.3.1

Languages
~~~~~~~~~

java 1.8

python 3.6

typescript

markdown

representational text

Applications and dependencies
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

APS
^^^

| [INFO] com.pacificdataservices:diamond-planning:jar:19.11.0-SNAPSHOT
| [INFO] +- com.google.code.gson:gson:jar:2.8.0:compile
| [INFO] +- org.javautil:javautil-core:jar:VER-7.0.1:compile
| [INFO] \| +- commons-codec:commons-codec:jar:1.10:compile
| [INFO] \| +- org.apache.commons:commons-lang3:jar:3.8.1:compile
| [INFO] \| +- commons-lang:commons-lang:jar:2.4:compile
| [INFO] \| +- org.javautil:javautil-commandline:jar:VER-7.0.1:compile
| [INFO] \| \| +- jcmdline:jcmdline:jar:1.0.3:compile
| [INFO] \| \| -
commons-configuration:commons-configuration:jar:1.10:compile
| [INFO] \| +-
com.fasterxml.jackson.core:jackson-databind:jar:2.8.8:compile
| [INFO] \| \| -
com.fasterxml.jackson.core:jackson-core:jar:2.8.8:compile
| [INFO] \| +-
com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.8.8:compile
| [INFO] \| +- org.yaml:snakeyaml:jar:1.17:compile
| [INFO] \| +- org.slf4j:slf4j-api:jar:1.7.25:compile
| [INFO] \| +- log4j:log4j:jar:1.2.17:compile
| [INFO] \| +- org.slf4j:slf4j-log4j12:jar:1.7.25:compile
| [INFO] \| +- xml-apis:xml-apis:jar:1.4.01:compile
| [INFO] \| +- com.zaxxer:HikariCP:jar:2.5.1:compile
| [INFO] \| +- com.h2database:h2:jar:1.4.195:compile
| [INFO] \| +- commons-io:commons-io:jar:2.6:compile
| [INFO] \| +- dom4j:dom4j:jar:1.6.1:compile
| [INFO] \| +- org.beanshell:bsh:jar:2.0b4:compile
| [INFO] \| - javax.persistence:javax.persistence-api:jar:2.2:compile
| [INFO] +- org.javautil:javautil-hibernate:jar:VER-7.0.1:compile
| [INFO] \| +- commons-jxpath:commons-jxpath:jar:1.2:compile
| [INFO] \| \| +- javax.servlet:servlet-api:jar:2.2:compile
| [INFO] \| \| +- ant:ant-optional:jar:1.5.1:compile
| [INFO] \| \| +- jdom:jdom:jar:b9:compile
| [INFO] \| \| - commons-logging:commons-logging:jar:1.0:compile
| [INFO] \| +-
org.springframework:spring-context:jar:4.3.9.RELEASE:compile
| [INFO] \| \| +-
org.springframework:spring-aop:jar:4.3.9.RELEASE:compile
| [INFO] \| \| -
org.springframework:spring-expression:jar:4.3.9.RELEASE:compile
| [INFO] \| +- org.springframework:spring-orm:jar:4.3.9.RELEASE:compile
| [INFO] \| \| - org.springframework:spring-tx:jar:4.3.9.RELEASE:compile
| [INFO] \| +- org.springframework:spring-test:jar:4.3.9.RELEASE:compile
| [INFO] \| +-
org.springframework:spring-beans:jar:4.3.9.RELEASE:compile
| [INFO] \| +- org.springframework:spring-jdbc:jar:4.3.9.RELEASE:compile
| [INFO] \| +- org.hibernate:hibernate-ehcache:jar:5.0.12.Final:compile
| [INFO] \| \| +-
org.jboss.logging:jboss-logging:jar:3.3.1.Final:compile
| [INFO] \| \| - net.sf.ehcache:ehcache-core:jar:2.4.3:compile
| [INFO] \| +- org.hibernate:hibernate-core:jar:5.0.12.Final:compile
| [INFO] \| \| +-
org.hibernate.javax.persistence:hibernate-jpa-2.1-api:jar:1.0.0.Final:compile
| [INFO] \| \| +- org.javassist:javassist:jar:3.21.0-GA:compile
| [INFO] \| \| +- antlr:antlr:jar:2.7.7:compile
| [INFO] \| \| +-
org.apache.geronimo.specs:geronimo-jta\_1.1\_spec:jar:1.1.1:compile
| [INFO] \| \| +- org.jboss:jandex:jar:2.0.0.Final:compile
| [INFO] \| \| -
org.hibernate.common:hibernate-commons-annotations:jar:5.0.1.Final:compile
| [INFO] \| +- hibernate:hibernate-tools:jar:3.2.3.GA:compile
| [INFO] \| \| +- freemarker:freemarker:jar:2.3.8:compile
| [INFO] \| \| - org.hibernate:jtidy:jar:r8-20060801:compile
| [INFO] \| - javassist:javassist:jar:3.12.1.GA:compile
| [INFO] +- commons-beanutils:commons-beanutils:jar:1.9.3:compile
| [INFO] \| - commons-collections:commons-collections:jar:3.2.2:compile
| [INFO] +- org.apache.commons:commons-collections4:jar:4.0:compile
| [INFO] +-
org.springframework.boot:spring-boot-starter-data-jpa:jar:1.5.4.RELEASE:compile
| [INFO] \| +-
org.springframework.boot:spring-boot-starter:jar:1.5.4.RELEASE:compile
| [INFO] \| \| +-
org.springframework.boot:spring-boot:jar:1.5.4.RELEASE:compile
| [INFO] \| \| -
org.springframework.boot:spring-boot-autoconfigure:jar:1.5.4.RELEASE:compile
| [INFO] \| +-
org.springframework.boot:spring-boot-starter-aop:jar:1.5.4.RELEASE:compile
| [INFO] \| \| - org.aspectj:aspectjweaver:jar:1.8.10:compile
| [INFO] \| +-
org.springframework.boot:spring-boot-starter-jdbc:jar:1.5.4.RELEASE:compile
| [INFO] \| \| - org.apache.tomcat:tomcat-jdbc:jar:8.5.15:compile
| [INFO] \| \| - org.apache.tomcat:tomcat-juli:jar:8.5.15:compile
| [INFO] \| +-
org.hibernate:hibernate-entitymanager:jar:5.0.12.Final:compile
| [INFO] \| +- javax.transaction:javax.transaction-api:jar:1.2:compile
| [INFO] \| +-
org.springframework.data:spring-data-jpa:jar:1.11.4.RELEASE:compile
| [INFO] \| \| -
org.springframework.data:spring-data-commons:jar:1.13.4.RELEASE:compile
| [INFO] \| -
org.springframework:spring-aspects:jar:4.3.9.RELEASE:compile
| [INFO] +-
org.springframework.boot:spring-boot-starter-data-rest:jar:1.5.4.RELEASE:compile
| [INFO] \| +-
org.springframework.boot:spring-boot-starter-web:jar:1.5.4.RELEASE:compile
| [INFO] \| \| +-
org.springframework.boot:spring-boot-starter-tomcat:jar:1.5.4.RELEASE:compile
| [INFO] \| \| \| +-
org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.15:compile
| [INFO] \| \| \| +-
org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.15:compile
| [INFO] \| \| \| -
org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.15:compile
| [INFO] \| \| +-
org.hibernate:hibernate-validator:jar:5.3.5.Final:compile
| [INFO] \| \| \| +-
javax.validation:validation-api:jar:1.1.0.Final:compile
| [INFO] \| \| \| - com.fasterxml:classmate:jar:1.3.3:compile
| [INFO] \| \| +-
org.springframework:spring-web:jar:4.3.9.RELEASE:compile
| [INFO] \| \| -
org.springframework:spring-webmvc:jar:4.3.9.RELEASE:compile
| [INFO] \| +-
com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
| [INFO] \| -
org.springframework.data:spring-data-rest-webmvc:jar:2.6.4.RELEASE:compile
| [INFO] \| -
org.springframework.data:spring-data-rest-core:jar:2.6.4.RELEASE:compile
| [INFO] \| +-
org.springframework.hateoas:spring-hateoas:jar:0.23.0.RELEASE:compile
| [INFO] \| +-
org.springframework.plugin:spring-plugin-core:jar:1.2.0.RELEASE:compile
| [INFO] \| - org.atteo:evo-inflector:jar:1.2.2:compile
| [INFO] +- com.oracle:oracle-jdbc8:jar:18:compile
| [INFO] +- org.postgresql:postgresql:jar:9.4.1212.jre7:runtime
| [INFO] -
org.springframework.boot:spring-boot-starter-test:jar:1.5.4.RELEASE:test
| [INFO] +-
org.springframework.boot:spring-boot-test:jar:1.5.4.RELEASE:test
| [INFO] +-
org.springframework.boot:spring-boot-test-autoconfigure:jar:1.5.4.RELEASE:test
| [INFO] +- com.jayway.jsonpath:json-path:jar:2.2.0:test
| [INFO] \| - net.minidev:json-smart:jar:2.2.1:test
| [INFO] \| - net.minidev:accessors-smart:jar:1.1:test
| [INFO] \| - org.ow2.asm:asm:jar:5.0.3:test
| [INFO] +- junit:junit:jar:4.12:compile
| [INFO] +- org.assertj:assertj-core:jar:2.6.0:test
| [INFO] +- org.mockito:mockito-core:jar:1.10.19:test
| [INFO] \| - org.objenesis:objenesis:jar:2.1:test
| [INFO] +- org.hamcrest:hamcrest-core:jar:1.3:compile
| [INFO] +- org.hamcrest:hamcrest-library:jar:1.3:test
| [INFO] +- org.skyscreamer:jsonassert:jar:1.4.0:test
| [INFO] \| -
com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
| [INFO] - org.springframework:spring-core:jar:4.3.9.RELEASE:compile

website
^^^^^^^

| Angular CLI: 8.0.4
| Node: 10.17.0
| OS: linux x64
| Angular: 8.0.2
| ... animations, common, compiler, compiler-cli, core, forms
| ... language-service, platform-browser, platform-browser-dynamic
| ... router

Package Version
---------------

| @angular-devkit/architect 0.800.4
| @angular-devkit/build-angular 0.800.4
| @angular-devkit/build-optimizer 0.800.4
| @angular-devkit/build-webpack 0.800.4
| @angular-devkit/core 8.0.4
| @angular-devkit/schematics 8.0.4
| @angular/cdk 8.0.1
| @angular/cli 8.0.4
| @angular/material 8.0.1
| @ngtools/webpack 8.0.4
| @schematics/angular 8.0.4
| @schematics/update 0.800.4
| rxjs 6.4.0
| typescript 3.4.5
| webpack 4.30.0

javautil-7 javautil-core
^^^^^^^^^^^^^^^^^^^^^^^^

jjs ~/java-projects/javautil-7/javautil-core>mvn dependency:tree

-  | mvn dependency:tree
   | [INFO] Scanning for projects...
   | [INFO]
   | [INFO] ---------------------< org.javautil:javautil-core
   >---------------------
   | [INFO] Building javautil-core VER-7.0.1
   | [INFO] --------------------------------[ jar
   ]---------------------------------
   | [INFO]
   | [INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @
   javautil-core ---
   | [INFO] org.javautil:javautil-core:jar:VER-7.0.1
   | [INFO] +- commons-codec:commons-codec:jar:1.5:compile
   | [INFO] +- org.apache.commons:commons-lang3:jar:3.8.1:compile
   | [INFO] +- commons-lang:commons-lang:jar:2.4:compile
   | [INFO] +- org.javautil:javautil-commandline:jar:VER-7.0.1:compile
   | [INFO] \| +- jcmdline:jcmdline:jar:1.0.3:compile
   | [INFO] \| -
   commons-configuration:commons-configuration:jar:1.10:compile
   | [INFO] \| - commons-logging:commons-logging:jar:1.1.1:compile
   | [INFO] +-
   com.fasterxml.jackson.core:jackson-databind:jar:2.10.1:compile
   | [INFO] \| +-
   com.fasterxml.jackson.core:jackson-annotations:jar:2.10.1:compile
   | [INFO] \| -
   com.fasterxml.jackson.core:jackson-core:jar:2.10.1:compile
   | [INFO] +-
   com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.10.1:compile
   | [INFO] +- com.google.code.gson:gson:jar:2.6.2:compile
   | [INFO] +- org.yaml:snakeyaml:jar:1.23:compile
   | [INFO] +- org.slf4j:slf4j-api:jar:1.7.25:compile
   | [INFO] +- log4j:log4j:jar:1.2.17:compile
   | [INFO] +- org.slf4j:slf4j-log4j12:jar:1.7.25:compile
   | [INFO] +- xml-apis:xml-apis:jar:1.4.01:compile
   | [INFO] +- com.zaxxer:HikariCP:jar:3.4.1:compile
   | [INFO] +- com.oracle:oracle-jdbc8:jar:19:compile
   | [INFO] +- com.h2database:h2:jar:1.4.197:compile
   | [INFO] +- commons-io:commons-io:jar:2.6:compile
   | [INFO] +- dom4j:dom4j:jar:1.6.1:compile
   | [INFO] +- org.beanshell:bsh:jar:2.0b4:compile
   | [INFO] +- org.postgresql:postgresql:jar:42.2.8:test
   | [INFO] +- javax.persistence:javax.persistence-api:jar:2.2:compile
   | [INFO] +- org.mockito:mockito-core:jar:1.10.19:test
   | [INFO] \| +- org.hamcrest:hamcrest-core:jar:1.1:test
   | [INFO] \| - org.objenesis:objenesis:jar:2.1:test
   | [INFO] +- org.assertj:assertj-core:jar:3.6.2:test
   | [INFO] +- xerces:xercesImpl:jar:2.12.0:provided
   | [INFO] +- xerces:xmlParserAPIs:jar:2.6.2:provided
   | [INFO] - junit:junit:jar:4.12:test

javautil-poi
~~~~~~~~~~~~

| [INFO] ---------------------< org.javautil:javautil-poi
>----------------------
| [INFO] Building javautil-poi VER-7.0.1
| [INFO] --------------------------------[ jar
]---------------------------------
| [INFO]
| [INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @
javautil-poi ---
| [INFO] org.javautil:javautil-poi:jar:VER-7.0.1
| [INFO] +- org.javautil:javautil-core:jar:VER-7.0.1:compile
| [INFO] \| +- commons-codec:commons-codec:jar:1.5:compile
| [INFO] \| +- org.apache.commons:commons-lang3:jar:3.8.1:compile
| [INFO] \| +- commons-lang:commons-lang:jar:2.4:compile
| [INFO] \| +- org.javautil:javautil-commandline:jar:VER-7.0.1:compile
| [INFO] \| \| +- jcmdline:jcmdline:jar:1.0.3:compile
| [INFO] \| \| -
commons-configuration:commons-configuration:jar:1.10:compile
| [INFO] \| \| - commons-logging:commons-logging:jar:1.1.1:compile
| [INFO] \| +-
com.fasterxml.jackson.core:jackson-databind:jar:2.10.1:compile
| [INFO] \| \| +-
com.fasterxml.jackson.core:jackson-annotations:jar:2.10.1:compile
| [INFO] \| \| -
com.fasterxml.jackson.core:jackson-core:jar:2.10.1:compile
| [INFO] \| +-
com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.10.1:compile
| [INFO] \| +- com.google.code.gson:gson:jar:2.6.2:compile
| [INFO] \| +- org.yaml:snakeyaml:jar:1.23:compile
| [INFO] \| +- org.slf4j:slf4j-api:jar:1.7.25:compile
| [INFO] \| +- org.slf4j:slf4j-log4j12:jar:1.7.25:compile
| [INFO] \| +- com.zaxxer:HikariCP:jar:3.4.1:compile
| [INFO] \| +- com.oracle:oracle-jdbc8:jar:19:compile
| [INFO] \| +- com.h2database:h2:jar:1.4.197:compile
| [INFO] \| +- commons-io:commons-io:jar:2.6:compile
| [INFO] \| +- dom4j:dom4j:jar:1.6.1:compile
| [INFO] \| +- org.beanshell:bsh:jar:2.0b4:compile
| [INFO] \| - javax.persistence:javax.persistence-api:jar:2.2:compile
| [INFO] +- org.javautil:javautil-dblogging:jar:VER-7.0.1:compile
| [INFO] \| +- org.dom4j:dom4j:jar:2.1.1:compile
| [INFO] \| - org.apache.commons:commons-exec:jar:1.3:compile
| [INFO] +- org.apache.poi:poi:jar:4.1.0:compile
| [INFO] \| +- org.apache.commons:commons-collections4:jar:4.3:compile
| [INFO] \| - org.apache.commons:commons-math3:jar:3.6.1:compile
| [INFO] +- commons-collections:commons-collections:jar:3.2.1:compile
| [INFO] +- org.postgresql:postgresql:jar:42.2.1:test
| [INFO] +- xerces:xercesImpl:jar:2.12.0:provided
| [INFO] +- xerces:xmlParserAPIs:jar:2.6.2:provided
| [INFO] +- log4j:log4j:jar:1.2.17:compile
| [INFO] +- junit:junit:jar:4.12:test
| [INFO] \| - org.hamcrest:hamcrest-core:jar:1.3:test
| [INFO] - xml-apis:xml-apis:jar:1.4.01:compile

Build tool

Apache Maven 3.6.3

Document generated by Confluence on Dec 22, 2019 07:29

`Atlassian <http://www.atlassian.com/>`__
