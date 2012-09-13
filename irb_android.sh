#!/bin/bash
TEST_SERVER_PORT=34777 
MOBILE_APP_PACKAGE='sh.calaba.demoproject.test'
adb shell am instrument -e class sh.calaba.instrumentationbackend.InstrumentationBackend -w $MOBILE_APP_PACKAGE/sh.calaba.instrumentationbackend.CalabashInstrumentationTestRunner &
sleep 7
IRBRC=.irbrc TEST_SERVER_PORT=$TEST_SERVER_PORT irb
