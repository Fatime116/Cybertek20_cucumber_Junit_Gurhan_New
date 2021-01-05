package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//if you add more additional plugin, use{"",""}
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",   //converted Json into readable cucumber HTML report
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false,
        tags = "@woodenspoonEtsy"


)
public class CukesRunner {


}
