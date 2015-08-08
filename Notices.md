# Notices #
## 30 Seconds Limitation ##
ktrwjr simply runs test, so a test which takes more than 30 seconds will fail because of GAE limitation.

## Server Access ##
ktrwjr accesses the server once every time a test is run.

## Development Server Log Hook ##
ktrwjr hooks logging messages during the test running.<br>
The way of the log hook is different between the Production Server and the Development Server.<br>
On the Production Server, ktrwjr can hook all logs during the test running.<br>
On the other hand, on the Development Server, ktrwjr can only hook the logs of the LoggingAPI.<br>
<br>
<h2>GWTTestCase cannot be used</h2>
GWTTestCase is not supported by ktrwjr.<br>
<br>
If you have GWTTestCase tests in your application,<br>
please put them in another source folder and<br>
set its output dir except war/WEB-INF/classes.