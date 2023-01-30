package ru.yandex.praktikum.model;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentalInformationForm {
    private WebDriver driver;
    private By DELIVERY_DATE = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By RENTAL_PERIOD_LIST_ARROW = By.className("Dropdown-arrow");
    private By PERIOD_1 = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[3]");
    private By PERIOD_2 = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[5]");
    private By CHECK_BOX_1 = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input");
    private By CHECK_BOX_2 = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]/input");
    private By COMMENT = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    private By ORDER_BUTTON = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private By YES_BUTTON = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");


    public RentalInformationForm(WebDriver driver){
        this.driver = driver;
    }

    public void enterDeliveryDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(DELIVERY_DATE));
        driver.findElement(DELIVERY_DATE).click();
        driver.findElement(DELIVERY_DATE).clear();
        driver.findElement(DELIVERY_DATE).sendKeys(date, Keys.ENTER);
    }

    public void chooseRentalPeriod_1() {
        driver.findElement(RENTAL_PERIOD_LIST_ARROW).click();
        driver.findElement(PERIOD_1).click();
    }

    public void chooseRentalPeriod_2() {
        driver.findElement(RENTAL_PERIOD_LIST_ARROW).click();
        driver.findElement(PERIOD_2).click();
    }

    public void clickCheckBox_1() {
        driver.findElement(CHECK_BOX_1).click();
    }

    public void clickCheckBox_2() {
        driver.findElement(CHECK_BOX_2).click();
    }

    public void enterComment(String comment) {
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickYesButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(YES_BUTTON));
        driver.findElement(YES_BUTTON).click();
    }

}
