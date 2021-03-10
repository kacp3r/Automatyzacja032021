package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = "Steps",                                         //to jest pakiet, a nie ścieżka do pliku
        plugin = {"pretty"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
