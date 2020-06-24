# java-web-ui-test-sample
This is a sample  Java based web UI test automation project

It uses Selenide, Cucumber, JUnit, Allure and Gradle.


---

# Set up #

1. Install Git
2. Install Java 11
3. Install Gradle
4. Install Allure (optionally) to get fancy reports

## Clone this repository

You can clone this repo using git console via https:
```
git clone https://github.com/aroygas/java-web-ui-test-sample.git
```

---

# Running tests #

To run all the tests just call gradle at project's root with "clean test" command:
```
gradle clean test
```

## Tags ##

Each scenario has some set of tags. <br>
Test suites are managed by mentioning tags. <br>
Tags follow the rules: <br>
`@part1`                                 - run only tests tagged as @part1 <br>
`not @part2`                     - exclude tests tagged as @part2 from run <br>
`@part1 or @part2`    - run tests tagged as @part1 OR tagged as @part2 <br>
`@part1 and @part2` - run tests tagged as @part1 AND tagged as @part2 <br>
`@part1 and not @part2`  - run tests tagged as @part1 AND exclude tests tagged as @part2 from the run <br>

So, to run only part 1 tests run:
```
gradle clean test -Dtags="@part1"
```

---

# Generating html report #

To generate a report using Allure at project's root run:
```
allure serve ./build/allure-results
```