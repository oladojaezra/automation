# Inroduction

This repo contains all the Selenium (automation) test cases for Angular WebApp. We are using test framework.

# Development

## Drivers
Drivers are already checked in `drivers` directory but in case you need to download the driver you can download it from [here](https://chromedriver.storage.googleapis.com/index.html?path=89.0.4389.23/).

## Mac
You need to follow these [insturctions](https://www.browserstack.com/guide/run-selenium-tests-on-safari-using-safaridriver) to run the automation test case on Mac machine.
### Issues
On mac you can run into this error: "chromedriver canot be opened beause the developer cannot be verfied"

![Mac issue](./docs/chomedriver-cannot-be-opened.png)

run the following command and then
```shell
xattr -d com.apple.quarantine drivers/mac/chromedriver
```
## Test Execution
Once your environment is setup run the following command on console.
```shell
mvn test
```
## Style Check
It is important to keep the code style consistent hence we have enabled [pmd](https://pmd.github.io/latest/pmd_userdocs_tools_maven.html), & Check style. It is also important to run the style check before you push code changes and ensure that
it is not complaining about any code changes. You need to run the following
command to run the style check.

```shell
mvn pmd:check

mvn checkstyle:check
```
