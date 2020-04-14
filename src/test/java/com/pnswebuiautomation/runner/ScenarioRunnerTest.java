package com.pnswebuiautomation.runner;


import com.pnswebuiautomation.stepdefinitions.ScenarioHooks;
import com.pnswebuiautomation.utilities.CommonUtility;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import cucumber.perf.api.CucumberPerfOptions;
import cucumber.perf.runtime.CucumberPerf;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(Cucumber.class)
@CucumberPerfOptions(
        plans = {"src/test/resources"},
        tags = {"@ApplyLearnerOnVFHCourse"},
        name = {"^(?!.*period).*$"})
@CucumberOptions(
        tags = {},
        features = {"src/test/resources/features"},
        glue = {"com.pnswebuiautomation.stepdefinitions"}, // package of stepdefinition classes
//        dryRun = true, // checks that every Step mentioned in the Feature File have corresponding code written in Step Definition file or not
        monochrome = true, // console output for the Cucumber test are much more readable
        plugin = {
                "pretty",
                "html:target/testresults/html", // test results as html
                "json:target/testresults/cucumber.json", // test results as json
                "junit:target/testresults/cucumber.xml" // test results as xml
        })
public class ScenarioRunnerTest {

        private static final Logger log = LogManager.getLogger(ScenarioRunnerTest.class);
        private static final String CSV_FILE_EXT = ".csv";
        private static final String PROJECT_DIR_PATH = System.getProperty("user.dir");

        @BeforeClass
        public static void setUp() {
                CucumberPerf cukePerf = new CucumberPerf(ScenarioRunnerTest.class);
        }

        // @AfterClass
        public static void afterTest() {
                StringBuilder fileNameToPath = new StringBuilder();
                fileNameToPath.append(PROJECT_DIR_PATH);
                fileNameToPath.append("/");
                fileNameToPath.append("Results");
                fileNameToPath.append("/");
                fileNameToPath.append(ScenarioHooks.scenario.getName().replaceAll(" ", "_"));
                fileNameToPath.append("-");
                fileNameToPath.append(CommonUtility.covertLocalDateTimeToString(LocalDateTime.now()).replaceAll("/", "_"));
                fileNameToPath.append(CSV_FILE_EXT);

                FileMgmtUtility.writeTestStepDurationToCSV(fileNameToPath.toString(), ScenarioHooks.stepDurationList);

        }
}
