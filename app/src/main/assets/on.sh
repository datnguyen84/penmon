#!/system/bin/sh
ip link set wlan0 down
sleep 2
echo 4 > /sys/module/wlan/parameters/con_mode
sleep 2
ip link set wlan0 up
