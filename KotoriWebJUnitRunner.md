# What Is Kotori Web JUnit Runner(ktrwjr)? #
![http://img.f.hatena.ne.jp/images/fotolife/b/bufferings/20100607/20100607065313.png](http://img.f.hatena.ne.jp/images/fotolife/b/bufferings/20100607/20100607065313.png)

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
<h1>Demonstration</h1>
<a href='http://ktrwjr.appspot.com/'>http://ktrwjr.appspot.com/</a>

<img src='http://img.f.hatena.ne.jp/images/fotolife/b/bufferings/20101229/20101229023238.jpg' />

<h1>Features</h1>
<ul><li>You can run your tests on both the Production Server and the Development Server.<br>
</li><li>When the test fails, you can see the error information.<br>
</li><li>You can see the real time, the CPU time and the API CPU time that the test took.<br>
</li><li>You can see the logs which is outputed during the running of the test.</li></ul>

<ul><li>Supports JUnit4 & JUnit3<br>
</li><li>I confirmed ktrwjr works well with IE8/FF3/Chrome10 on WinXP (I won't support IE6 & IE7).<br>
</li><li>Using GWT & jQueryUI Theme.</li></ul>

If you deploy ktrwjr with your GAE/j application, you can run your tests on the Production Server.<br>
(You can also run your tests on the Development Server.)<br>
<br>
<h1>How It Works?</h1>
ktrwjr is a simple web application.<br>
<ol><li>When you open the ktrwjr page, ktrwjr searches tests on the server and shows them.<br>
</li><li>You check test cases that you want to run, then click "Run" button.<br>
</li><li>They are run on the server and you receive results.