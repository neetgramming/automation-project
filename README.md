# QA Automation Assignment

### Prerequisites
1. Install latest java version
   https://www.oracle.com/java/technologies/downloads/
2. Install Apache Maven
   https://maven.apache.org/install.html
3. Install IntelliJ IDEA
   https://www.jetbrains.com/idea/download/?section=mac
4. Install at least one of the browsers: Chrome / Firefox

_***Note: Please copy and paste the commands on terminal if they don't work, by clicking on play button_
### UI Automation

#### Technology stack
1. Java
2. Selenium 4
3. TestNG
4. Allure reporting

#### Steps (Run the commands on IntelliJ terminal at the project location)
1. Go to project path: `cd ui-automation`

2.  Build the project: `mvn clean install -DskipTests=true`

3. Run tests
   * Run on chrome: 
     * `mvn test -DsuiteXmlFile=uitestschrome.xml`
   * Run on firefox: 
     * `mvn test -DsuiteXmlFile=uitestsfirefox.xml`
   * Run on both the browsers: 
     * `mvn test -DsuiteXmlFile=uitestsparallel.xml`

4. Allure Report:
   * `allure generate --clean`
   * `allure open`

### API Automation 

#### Technology stack
1. Java
2. RESTAssured
3. TestNG
4. Allure reporting

#### Steps (Run the commands on IntelliJ terminal at the project location)
1.  Go to project path: `cd api-automation`

2. Build the project: `mvn clean install -DskipTests=true`

3. Run tests: `mvn test -DsuiteXmlFile=apitests.xml`

4. Allure Report: (Run commands on terminal at project location)
    * `allure generate --clean`
    * `allure open`