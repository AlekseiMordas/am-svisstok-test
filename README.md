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

(or ANDROID)

Note!
===

Authorization tests runs with xml: testng.xml
===

Call tests runs with xml: call-tests.xml
===

Card contacts tests runs with xml: card-contacts.xml


Jenkins Integration
===

TBD

Writing your first Test
===

TBD
