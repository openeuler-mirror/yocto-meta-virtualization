HOMEPAGE = "http://www.docker.com"
SUMMARY = "Linux container runtime"
DESCRIPTION = "Linux container runtime \
 Docker complements kernel namespacing with a high-level API which \
 operates at the process level. It runs unix processes with strong \
 guarantees of isolation and repeatability across servers. \
 . \
 Docker is a great building block for automating distributed systems: \
 large-scale web deployments, database clusters, continuous deployment \
 systems, private PaaS, service-oriented architectures, etc. \
 . \
 This package contains the daemon and client, which are \
 officially supported on x86_64 and arm hosts. \
 Other architectures are considered experimental. \
 . \
 Also, note that kernel version 3.10 or above is required for proper \
 operation of the daemon process, and that any lower versions may have \
 subtle and/or glaring issues. \
 "

#
# https://github.com/docker/docker-ce-packaging.git
#  common.mk:
#    DOCKER_CLI_REPO    ?= https://github.com/docker/cli.git
#    DOCKER_ENGINE_REPO ?= https://github.com/docker/docker.git
#    REF                ?= HEAD
#    DOCKER_CLI_REF     ?= $(REF)
#    DOCKER_ENGINE_REF  ?= $(REF)
#
# These follow the tags for our releases in the listed repositories
# so we get that tag, and make it our SRCREVS:
#

SRCREV_docker = "8728dd246c3ab53105434eef8ffe997b6fd14dc6"
SRCREV_libnetwork = "b3507428be5b458cb0e2b4086b13531fb0706e46"
SRCREV_cli = "370c28948e3c12dce3d1df60b6f184990618553f"
SRC_URI = "\
	git://github.com/docker/docker.git;branch=20.10;name=docker \
	git://github.com/docker/libnetwork.git;branch=master;name=libnetwork;destsuffix=git/libnetwork \
	git://github.com/docker/cli;branch=20.10;name=cli;destsuffix=git/cli \
	file://0001-libnetwork-use-GO-instead-of-go.patch \
	file://docker.init \
        file://0001-dynbinary-use-go-cross-compiler.patch \
        file://0001-cli-use-external-GO111MODULE-and-cross-compiler.patch \
	"

require docker.inc

# Apache-2.0 for docker
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://src/import/LICENSE;md5=4859e97a9c7780e77972d989f0823f28"

DOCKER_VERSION = "20.10.6-ce"
PV = "${DOCKER_VERSION}+git${SRCREV_docker}"
