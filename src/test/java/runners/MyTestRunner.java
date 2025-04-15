package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//src//test//resources//features//ArticleTest.feature" ,
		glue = {"stepDefs"},
		monochrome =true,
		dryRun = false,
//		tags= "@SmokeTest",
//		tags= "@RegressionTest",
		plugin = {"pretty",
				"html:target/Reports/TestReport.html"
		}
	)

public class MyTestRunner extends AbstractTestNGCucumberTests {

}



