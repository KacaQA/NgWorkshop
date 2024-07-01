import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NgExercise {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @Test
    public void testSelectDropdownOption() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        dropdown.selectByVisibleText("SQL");
        Thread.sleep(2000);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "SQL", "Selected option is not SQL");
    }

    @Test
    public void testCheckCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.cssSelector("input[value='option-2']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        Thread.sleep(2000);
        Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");

        // Uncheck the checkbox
        checkbox.click();
        Thread.sleep(2000);
        Assert.assertFalse(checkbox.isSelected(), "Checkbox is not unchecked");
    }

    @Test
    public void testSelectRadioButton() throws InterruptedException {
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='blue']"));
        if (!radioButton.isSelected()) {
            radioButton.click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(radioButton.isSelected(), "Radio button 'Blue' is not selected");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
