am-svisstok-test
================
Svisstok Mobile Testing Framework

Setup
===

Be sure that appium server started, and you select path to app.

Clone project with git clone https://github.com/AlekseiMordas/am-svisstok-test.git

in terminal type "cd mobile-svisstok-tests"

In folder run "mvn clean install"

Go to tests/target/am.svisstok.tests-1.0.0 and run your tests with command:

java -jar am.svisstok.tests.jar --testng testng.xml --device IPHONE

 or (ANDROID, IOS7)

You need to check manually on what xcode should be runs tests. xcode5 (ios6) or xcode5 (ios7)
To prepare for iOS 6.1 testing. We run it again with a different Xcode:
sudo xcode-select -switch /Applications/Xcode-4.6.app/Contents/Developer/

To go back to iOS 7.0 testing.
sudo xcode-select -switch /Applications/Xcode.app/Contents/Developer/

more information see: https://github.com/appium/appium/blob/master/docs/en/running-on-osx.md

Note!
===

Authorization tests runs with xml: testng.xml


Call tests runs with xml: call-tests.xml


Card contacts tests runs with xml: card-contacts.xml


History tests: history-tests.xml



Jenkins Integration
===

There are some tests in call-tests, which wait incomming call.
It can be configured another jenkins job. 
java -jar am.svisstok.tests.jar --testng jenkinsCall.xml --device IPHONE —c skustov2 —a shustov3
where a - abonent. who accept the call, с - caller. e.g who make outgoing call.

When job will be ready, ask me to add url this job in code.

Writing your first Test
===

TBD
