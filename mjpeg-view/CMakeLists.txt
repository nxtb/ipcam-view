# Sets the minimum version of CMake required to build the native
# library.
cmake_minimum_required(VERSION 3.4.1)

# Creates the project's shared lib: libnative-lib.so.
# The lib is loaded by this project's Java code in MainActivity.java:
#     System.loadLibrary("native-lib");
# The lib name in both places must match.
add_library( ImageProc
             SHARED
        src/main/cpp/jpeg8d/jmemnobs.c
        src/main/cpp/jpeg8d/jcapimin.c
        src/main/cpp/jpeg8d/jcapistd.c
        src/main/cpp/jpeg8d/jccoefct.c
        src/main/cpp/jpeg8d/jccolor.c
        src/main/cpp/jpeg8d/jcdctmgr.c
        src/main/cpp/jpeg8d/jchuff.c
        src/main/cpp/jpeg8d/jcinit.c
        src/main/cpp/jpeg8d/jcmainct.c
        src/main/cpp/jpeg8d/jcmarker.c
        src/main/cpp/jpeg8d/jcmaster.c
        src/main/cpp/jpeg8d/jcomapi.c
        src/main/cpp/jpeg8d/jcparam.c
        src/main/cpp/jpeg8d/jcprepct.c
        src/main/cpp/jpeg8d/jcsample.c
        src/main/cpp/jpeg8d/jctrans.c
        src/main/cpp/jpeg8d/jdapimin.c
        src/main/cpp/jpeg8d/jdapistd.c
        src/main/cpp/jpeg8d/jdatadst.c
        src/main/cpp/jpeg8d/jdatasrc.c
        src/main/cpp/jpeg8d/jdcoefct.c
        src/main/cpp/jpeg8d/jdcolor.c
        src/main/cpp/jpeg8d/jddctmgr.c
        src/main/cpp/jpeg8d/jdhuff.c
        src/main/cpp/jpeg8d/jdinput.c
        src/main/cpp/jpeg8d/jdmainct.c
        src/main/cpp/jpeg8d/jdmarker.c
        src/main/cpp/jpeg8d/jdmaster.c
        src/main/cpp/jpeg8d/jdmerge.c
        src/main/cpp/jpeg8d/jdpostct.c
        src/main/cpp/jpeg8d/jdsample.c
        src/main/cpp/jpeg8d/jdtrans.c
        src/main/cpp/jpeg8d/jerror.c
        src/main/cpp/jpeg8d/jfdctflt.c
        src/main/cpp/jpeg8d/jfdctfst.c
        src/main/cpp/jpeg8d/jfdctint.c
        src/main/cpp/jpeg8d/jidctflt.c
        src/main/cpp/jpeg8d/jidctfst.c
        src/main/cpp/jpeg8d/jidctint.c
        src/main/cpp/jpeg8d/jquant1.c
        src/main/cpp/jpeg8d/jquant2.c
        src/main/cpp/jpeg8d/jutils.c
        src/main/cpp/jpeg8d/jmemmgr.c
        src/main/cpp/jpeg8d/jcarith.c
        src/main/cpp/jpeg8d/jdarith.c
        src/main/cpp/jpeg8d/jaricom.c

        src/main/cpp/ImageProc/ImageProc.c
        )

find_library(log-lib
             log )

find_library(jnigraphics-lib
             jnigraphics)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in the
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       ImageProc

                       ${log-lib}
                       ${jnigraphics-lib}
        )