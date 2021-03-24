# UIAutomationTestIMDB
Puzzle related to IMDB website


How to run ::
===============
Verify if java is installed or not (preferred version :: 1.8),if no then install and add to classpath.
Verify if maven is installed or not,if not then install and add add to classpath and check version.
Now, Unzip the source code and go to the root folder.
Now, open console from there and hit mvn install or mvn test command.
Now , wait until buid gets passed .
Now, you can see thr report in the console while the program is running as I have used Reporter class from testng to keep the test result in both testng report and console.
I have used Selenium webdriver and TestNG,Maven to write the whole code.For checking the presence of atleast one movie inside sorted movie list link , I have choosen rating as movie presence parameter.
I have kept my test data (constant data) in dataprovide class and used page factorypattern.

There are areas where this code can be improved as it can be dockerized and Reporting framework like allure could be integrated.





