# Gslate Automation Test

This is a test automation test for gslate created by Eddyn Gerardo Soto Arguedas.


## Getting Started

First check the prerequisites section and make your you have all set up. After that, Download the project or clone it. Once in your machine, follow the installing steps.

### Prerequisites

The setup recommendation is:
```
1- IntelliJ IDEA CE 2019.3 or above
2- Java SE Development Kit 11.0.5
3- Maven
4- ChromeDriver
```


### Installing

On IntelliJ IDEA, create a new project from existing sources

```
File / New / Project from Existing Sources ...
```

And go to the path where your project was saved. Once loaded, enable the maven auto-import to get all the dependencies installed.


## ChromeDriver


1- To install the driver on
```
src/test/resources/chromedriver/mac
```

## Running te test

There is 2 ways to run the test

1. Run the "Runner" class into scripts package 
2. Using the testng.xml file

You can also specify  the xml file you want to run, for now we just have one, so use: 
```
mvn clean test -DtestNGFile=testng.xml
```

## Reports
After run a suite the report file will be created on

```
src/test output
```

### Coding pattern

We are using Page Object Model as the design pattern.

Under this model, for each web page in the application, there should be corresponding page class. This Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

You will find three main packages here:

> /src/test/java/com/demo/opencart/automation/core (where all the logic related to the framework are located)

> /src/test/java/com/demo/opencart/automation/features (where all the cucumber features are located)

> /src/test/java/com/demo/opencart/automation/pages (where all the pages, elements and stepDef are located)

> /src/test/java/com/demo/opencart/automation/scripts (where all runners are located)

So, if you are collaborating with this project, please follow that pattern/guidelines.

## Built With

* [IntelliJ IDEA CE](https://www.jetbrains.com/idea/) - Java IDE
* [Selenium WebDriver](https://www.selenium.dev/) - Suite of tools for automation web browser
* [Maven](https://maven.apache.org/) - Dependency Management
* [ExtentReport](https://grasshopper.tech/2098/) - Framework for reports
* [Cucumber](https://cucumber.io/) - Test Cases
* [ChromeDriver]( https://chromedriver.chromium.org/downloads) - Driver 


## Authors

* **Eddyn Gerardo Soto Arguedas** - *Initial work* 

# Test Cases
### 1- Verify that the web site allows new customers to register.

#### Steps to reproduce
1. Go to home page
2. Click on my account button
3. Click on register
4. Fill up the form to create a user with the following data Name: "Automated" LastName: "TesUser" Email: "test@test.com" Phone: "8888 8888" Password: "ready2go"
5. Click in the checkbox to accept Privacy Policy
6. Click on continue
7. Verify that user was created successfully

NOTE: The email should change any time this test is running to avoid errors with users created previously.

#### Expected result
The user should be able to create a new user in the site.


### 2- Add an order using the search to find a specific product.

#### Steps to reproduce
1. I navigate to home page
2. Search for a product "Macbook Pro"
3. Select the first result displayed to add to the cart
4. The product should be added to the shopping cart "1 item(s) - $602.00"

#### Expected result
The user should be able to search for a product and this product is added to the shopping cart.


### 3- Verify a product price is displayed in the selected currency.
1. I navigate to home page
2. Look for the currency dropdown 
3. Change the currency to € Euro
4. Verify that the currency in the shopping cart match with the currency preselected "€"

#### Expected result
The user should be able to change the currency and this value is updated in the shopping cart.