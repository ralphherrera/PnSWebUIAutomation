package com.pnswebuiautomation.runner;


import com.pnswebuiautomation.stepdefinitions.ScenarioHooks;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import cucumber.perf.api.CucumberPerfOptions;
import cucumber.perf.runtime.CucumberPerf;
import cucumber.perf.runtime.PerfRuntimeOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RunWith(Cucumber.class)
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
@CucumberPerfOptions(
        plans = {"src/test/resources/features"},
        tags = {"not @bskip","@simperiodtest"},
        name = {"^(?!.*period).*$"})
public class ScenarioRunnerTest {

        private static final Logger log = LogManager.getLogger(ScenarioRunnerTest.class);
        private static final String CSV_FILE_EXT = ".csv";
        private static final String PROJECT_DIR_PATH = System.getProperty("user.dir");

        @BeforeClass
        public static void setUp() {
                PerfRuntimeOptions options = new PerfRuntimeOptions();
                options.addPlanPaths(Arrays.asList(new String[]{"src/test/resources/features"}));
                options.addTagFilters(Arrays.asList(new String[]{"not @bskip","@simperiodtest"}));
                options.addCucumberOptions(Arrays.asList(new String[]{"-g","com.pnswebuiautomation.stepdefinitions","-t","@planPosTester","src/test/resources/features",}));//"--plugin","default_summary","--plugin","null_summary","--plugin","cucumber.formatter.NullFormatter"

                CucumberPerf cukePerf = new CucumberPerf(ScenarioRunnerTest.class, options);
                try {
                        cukePerf.runThreads();
                } catch (Throwable e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }

        @AfterClass
        public static void afterTest() {
                StringBuilder fileNameToPath = new StringBuilder();
                fileNameToPath.append(PROJECT_DIR_PATH);
                fileNameToPath.append("/");
                fileNameToPath.append("Results");
                fileNameToPath.append("/");
                fileNameToPath.append(ScenarioHooks.scenario.getName().replaceAll(" ", "_"));
                fileNameToPath.append("-");
                final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yy-MM-dd_HH-mm-ss");
                fileNameToPath.append(LocalDateTime.now().format(DATE_TIME_FORMATTER));
                fileNameToPath.append(CSV_FILE_EXT);

                FileMgmtUtility.writeTestStepDurationToCSV(fileNameToPath.toString(), ScenarioHooks.stepDurationList);

        }
}
