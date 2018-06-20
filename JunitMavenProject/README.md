
1. Use the below maven command to run the script through command line.
   mvn clean install-Dtest=WikipediaTest
   
2. TetBase class contains the @BeforeClass and @AfterClass annotated methods.

3 The @BeforeClass anootated method is used to initiate the webdriver and yo open the chrome browser.

4. @AfterClass annotated method is used to close the browser.

5. SeleniumUtils class is contains the utility methods to open url and interact with browser.

6. The url is passed from the Constants class.

7. Wikipedia class is a page class using Page Factory pattern, which contains methods to retrieve the data from application and validation of the data.

8. WikipediaTest class contains the @Test annotated method from where the execution starts and the step by step navigation is defined here.
   
9. Chrome driver is placed in test/resources/driver directory.
   
   
   
   
   
   

