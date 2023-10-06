package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
plugin={"pretty","json:target/jsonReports/cucumber-report.json", "html:target/cucumber-report/cucumber.html"},
glue={"StepDefinition"})

// we can run maven via cmd line
//C:\Users\BurnettR0815\eclipse-workspace\APIFramework>mvn test -Dcucumber.filter.tags="@AddPlace"
//compile -> test -> verify (how maven runs)

public class TestRunner {

}

