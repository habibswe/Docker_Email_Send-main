// package TestRunner;

// import io.cucumber.testng.CucumberOptions;
// import org.testng.annotations.DataProvider;
// import org.testng.annotations.Test;
// import io.cucumber.testng.AbstractTestNGCucumberTests;

// @Test
// @CucumberOptions(features ="src/test/java/Feature", glue = "StepDef",monochrome = true,
// tags = "@Release",
//         plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//                 "rerun:target/failed_scenarios.txt"}

// )

// public class TestRunner extends AbstractTestNGCucumberTests {

//     @Override
//     @DataProvider(parallel = true)
//     public Object[][] scenarios()
//     {
//         return super.scenarios();
//     }


// }


package TestRunner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Test
@CucumberOptions(
        features = "src/test/java/Feature",
        glue = "StepDef",
        monochrome = true,
        tags = "@Release",
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed_scenarios.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path to the GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", "E:/geckodriver-v0.35.0-win64/geckodriver.exe");
        
        // Initialize FirefoxDriver
        driver = new FirefoxDriver();
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
