package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\masin\\eclipse-workspace\\CartBDD\\src\\test\\resources\\Features",glue= {"stepDefinition"},plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true)
public class testRunners {

}
