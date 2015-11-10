#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING CLOUDERA MANAGER'
echo '----------------------------------------------'

wget http://archive.cloudera.com/cm5/installer/latest/cloudera-manager-installer.bin
chmod u+x cloudera-manager-installer.bin
sudo ./cloudera-manager-installer.bin
