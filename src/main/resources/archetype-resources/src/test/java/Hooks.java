#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.testsmith.support.listeners.HighlightElementsListener;
import io.testsmith.support.listeners.SavePageSourceOnExceptionListener;
import io.testsmith.support.listeners.SaveScreenshotOnExceptionListener;
import io.testsmith.support.listeners.WebDriverLoggingListener;
import ${package}.properties.Environment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import ${package}.utils.BrowserUtil;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver originalDriver = BrowserUtil.createDriver(browser);
        this.testContext.driver = new EventFiringDecorator(
                new WebDriverLoggingListener(),
                new SavePageSourceOnExceptionListener(originalDriver, "target/log/pagesources"),
                new SaveScreenshotOnExceptionListener(originalDriver, "target/log/screenshots"),
                new HighlightElementsListener()
        ).decorate(originalDriver);
        this.testContext.driver.manage().window().maximize();
        this.testContext.driver.get(Environment.getProperties().url());
        this.testContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) this.testContext.driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @After(order = 0)
    public void tearDown() {
        this.testContext.driver.quit();
    }
}
