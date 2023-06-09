package class08.Homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
hw:
goto syntax hrms
login
click on recruitment
select a date on the calendar

 */
public class HW extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "safari";
        openBrowserAndLaunchApplication(url, browser);

        // login into the website
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        //click on recruitment
        WebElement recruitmentBtn=driver.findElement(By.xpath
                ("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitmentBtn.click();

       //click on the calendar date of application
        WebElement calendar = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
        calendar.click();

        // Select  August
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        monthDropdown.click();
        Select month = new Select(monthDropdown);
        month.selectByValue("7");

        // Select 1984
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        yearDropdown.click();
        Select year = new Select(yearDropdown);
        year.selectByValue("1984");

        // Select 3
        List<WebElement> allDates = driver.findElements(By.xpath
                ("//table/tbody/tr/td[5]/a[text()='3']"));
        for (WebElement date : allDates) {
            String currentDate = date.getText();
            if (currentDate.equals("3")) {
                date.click();
                break;
            }
        }
        
    }
}
