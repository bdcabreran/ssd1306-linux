SUMMARY="SSD1306 OLED I2C driver"
DESCRIPTION = "SSD1306 OLED I2C driver working in Linux"
HOMEPAGE = "https://github.com/bdcabreran/ssd1306-linux"
SECTION = "console/utils"
LICENSE = "MIT"

# git md5sum LICENSE
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b694e603a996c3bfdc6093ed1f70c8f"

SRC_URI = " \
    git://github.com/bdcabreran/ssd1306-linux.git;protocol=https;branch=master \
"
# git rev-parse HEAD
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# coreutils provides fmt which is used in the Makefile
DEPENDS = "i2c-tools coreutils-native"

EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/ssd1306_bin ${D}${bindir}
}

