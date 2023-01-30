package ru.yandex.praktikum.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class OrderStatus {
    private WebDriver driver;
    private By SUCCESS_MODAL = By.className("Order_Modal__YZ-d3");
    private By STATUS_BUTTON = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");
    private By CANCEL_BUTTON = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/button");
    private By CONFIRMATION_BUTTON = By.xpath("/html/body/div/div/div[2]/div[4]/div[2]/button[2]");
    private By GOOD_BUTTON = By.xpath("/html/body/div/div/div[2]/div[4]/div[2]/button");


    public OrderStatus(WebDriver driver){
        this.driver = driver;
    }


    public void checkSuccessModal() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SUCCESS_MODAL));
        WebElement element = driver.findElement(SUCCESS_MODAL);
        assertEquals("Окно успешного заказа не найдено", true, element.isDisplayed());
    }

    public void deleteOrderAfterTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(STATUS_BUTTON));
        driver.findElement(STATUS_BUTTON).click();
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON));
        driver.findElement(CANCEL_BUTTON).click();
        wait.until(ExpectedConditions.elementToBeClickable(CONFIRMATION_BUTTON));
        driver.findElement(CONFIRMATION_BUTTON).click();
        wait.until(ExpectedConditions.elementToBeClickable(GOOD_BUTTON));
        driver.findElement(GOOD_BUTTON).click();
        driver.findElement(GOOD_BUTTON).click();
    }


}
