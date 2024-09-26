# Selenium-Challenge

This project is based on the framework provided by [_Patricio Miner_](https://www.freerangetesters.com/) from his selenium-java course.


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-43B02A?style=for-the-badge&logo=cucumber&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=Selenium&logoColor=white)
Insertar Allure


The test cases used for this project come from a technical challenge by Stori, adapted for Java and Selenium, as the original was intended for Appium and Python.

## How to use

1. Execute `gradle build` on a terminal to download the project dependencies.
    > This will also execute the current test case tag

2. Execute test cases
    * Via `gradle build` command.
    * Via runner file located at `src/test/java/runner`
      <br> You need to update the tag in the `CucumberOptions` based on the tag of the test case to be executed.
3. Reports will be created locally at `folderLocation` and at [cucumber reports](https://reports.cucumber.io/).
    - For [allure reports](https://allurereport.org/docs/install/), you need to have it installed on your machine and be at the reports folder location and execute on a terminal `allure open`
    - For cucumber reports, open `https://reports.cucumber.io/report-collections/98c337f1-8e6f-4dfc-87e7-fa4304c67852`

<br>
<br>

<div style="color:#856404; background-color: #fff3cd; padding: 10px; border-radius: 5px;">
    The test cases for the switch tab/window (4, 5) has changed so it's impossible to complete them.
</div>

