require recipes-core/images/core-image-base.bb

SUMMARY = "Moelinux base image for MangoPi MQ Pro board"

IMAGE_INSTALL:append = " haveged "
PACKAGE_EXCLUDE:append = "rng-tools"
IMAGE_INSTALL:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'bluez5 linux-firmware-rtl8723ds', '', d)} "
IMAGE_INSTALL:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'networkmanager-wifi networkmanager-nmcli', '', d)} "

EXTRA_IMAGE_FEATURES:append = " ssh-server-dropbear"
EXTRA_IMAGE_FEATURES:remove = " package-management"

PACKAGECONFIG:pn-networkmanager:remove =" ${@bb.utils.contains('MACHINE_FEATURES', 'wifi' ' ifupdown dnsmasq ', '', d}}"
