@echo off
set path=C:\Users\Shahin Lap\.m2\repository\allure\allure-2.19.0\bin;C:\Program Files\Java\jdk-19\bin;%path%
allure serve allure-results
pause
exit