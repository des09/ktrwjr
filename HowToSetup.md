# How Do I Setup It? #
## Step1: download zip ##
Download the latest ktrwjr-x.x.x.zip(x.x.x is the version) from [Downloads](http://code.google.com/p/ktrwjr/downloads/list).

## Step2: copy files to your war ##
Unzip and copy files in the war directory to your application's war directory.

## Step3: edit your web.xml ##
Add the following to your web.xml.
```
  <servlet>
    <servlet-name>KtrWjrServiceServlet</servlet-name>
    <servlet-class>bufferings.ktr.wjr.server.service.KtrWjrServiceServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>KtrWjrServiceServlet</servlet-name>
    <url-pattern>/ktrwjr/ktrwjr/ktrwjr.s3gwt</url-pattern>
  </servlet-mapping>
```

## Step4: security constraint ##
It is better to lock down the ktrwjr urls so that only admin users can access to.

Add the following to your web.xml.
```
  <security-constraint>
    <web-resource-collection>
      <url-pattern>/ktrwjr/*</url-pattern>
    </web-resource-collection>
    <auth-constraint>
      <role-name>admin</role-name>
    </auth-constraint>
  </security-constraint>
```

## Step5: add junit.jar ##
Add "junit.jar" into your "war/WEB-INF/lib" if there's not.

## Step6: check source folder output ##
ktrwjr searches tests in "WEB-INF/classes" directory.<br>
If the output folder of the test source folder is not war/WEB-INF/classes,<br>
change it to war/WEB-INF/classes.<br>
<br>
In case of Eclipse<br>
<ol><li>Open property dialog of your project<br>
</li><li>Select "Java Build Path" from left tree<br>
</li><li>Select "Source" tab<br>
</li><li>Uncheck "Allow output folders for source folders"</li></ol>

<h2>That's all.</h2>
First, launch the Development Server and access to "/ktrwjr/index.html".<br>
After checking it goes well on dev-server, deploy to the Production Server.<br>
Enjoy ktrwjr testing!