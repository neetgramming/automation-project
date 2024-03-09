# UI Automation

### Technology stack
1. Java
2. Selenium 4
3. TestNG
4. Allure reporting

### Prerequisites
1. Install latest java version
   https://www.oracle.com/java/technologies/downloads/
2. Install Apache Maven
   https://maven.apache.org/install.html
3. Install IntelliJ IDEA
   https://www.jetbrains.com/idea/download/?section=mac
4. Install at least one of the browsers: Chrome / Firefox

### Steps
1. Build the project
   Run on terminal:  `mvn clean install -DskipTests`

2. Go to project path: `cd ui-automation`

3. Run tests
   * Run on chrome: 
     * `mvn test -DsuiteXmlFile=chrome.xml`
   * Run on firefox: 
     * `mvn test -DsuiteXmlFile=firefox.xml`
   * Run on both the browsers: 
     * `mvn test -DsuiteXmlFile=parallel.xml`

4. Allure Report: (Run commands on terminal at project location)
   * `allure generate --clean`
   * `allure open`