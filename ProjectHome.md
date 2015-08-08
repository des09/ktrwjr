# News #

<font size='5'>Now we are free from GWT-RPC.</font>

**2011-03-20**<br>
We released ktrwjr 2.0.1.<br>
Fixed the issue. "Japanese chars cannot be used".<br>
<br>
<b>2011-03-18</b><br>
We released ktrwjr 2.0.0.<br>
Now we are free from GWT-RPC.<br>
We don't need gwt-servlet.jar any more.<br>

for more -> <a href='http://code.google.com/p/ktrwjr/wiki/ReleaseNotes'>Release Notes</a>

<h1>What Is Kotori Web JUnit Runner(ktrwjr)?</h1>
<img src='http://img.f.hatena.ne.jp/images/fotolife/b/bufferings/20100607/20100607065313.png' />
<table border='0'><tr>
<td>
I call "Kotori Web JUnit Runner" as "ktrwjr"[<br>
</td><td>
<img src='http://img.f.hatena.ne.jp/images/fotolife/b/bufferings/20100607/20100607072716.jpg' />
</td><td>
].<br>
</td></tr></table>

ktrwjr is a JUnit runner web application for GAE/j.<br>
It helps to run your tests on the Production Server and the Development Server.<br>
<br>
Haven't you ever wanted to execute your tests on the Production Server?<br>
With ktrwjr, you can do it easily.<br>
<br>
for more -> <a href='http://code.google.com/p/ktrwjr/wiki/KotoriWebJUnitRunner'>Kotori Web JUnit Runner</a>

<h1>ktrwjr was introduced in Google I/O 2010!</h1>
In the session <a href='http://code.google.com/intl/ja/events/io/2010/sessions/testing-techniques-app-engine.html'>Testing techniques for Google App Engine</a>, Max referred to ktrwjr!<br>
<br>
24:50 Max said:<br>
<blockquote>I've seen at least two other web test runners, which appear to do something similar.<br>
And some of them are really gorgeous. They have these unbelievably pretty UIs.</blockquote>

<blockquote>One of them is called <b>Kotori JUnit Web Runner</b>.<br>
And I just found out about it this week,<br>
and <b>I need to talk to that developer to see if we can collaborate, because their UI is absolutely gorgeous</b>.</blockquote>

<blockquote>There's a link to it that should be in the live wave when we're finished.</blockquote>

<h1>ktrwjr is bundled to Slim3!</h1>
Slim3<br>
<a href='http://slim3.org'>http://slim3.org</a>
<blockquote>Slim3 is a full-stack MVC framework optimized for Google App Engine/Java,<br>
and you can use Slim3 as just a datastore framework, too.</blockquote>

The tester package of Slim3 is very convenient,<br>
because we can use its test case similarly on the Cloud(the Production Server),<br>
on the Development Server and on the local test.<br>
<br>
Those who use Low-Level API instead of Slim3 Datastore can use Slim3 Tester and ktrwjr<br>
to check the actions on the Cloud.<br>
<br>
<h1>ktrwjr is used in "Grails JUnit Web Runner Plugin"!</h1>
Grails JUnit Web Runner Plugin<br>
<a href='http://code.google.com/p/junit-web-runner/'>http://code.google.com/p/junit-web-runner/</a>

<blockquote>Grails JUnit Web Runner Plugin is created based on Kotori Web JUnit Runner project<br>
which is a JUnit Runner GWT application that helps to run in-container test cases on grails application.<br>
Test cases execution in Google App Engine(GAE) Development or Production Server is supported.