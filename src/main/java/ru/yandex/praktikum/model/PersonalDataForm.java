package ru.yandex.praktikum.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDataForm {
    private WebDriver driver;
    private By NAME = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private By SURNAME = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    private By ADDRESS = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private By SUBWAY = By.className("select-search__input");
    private By SUBWAY_STATION_1 = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[114]/button/div[2]");
    private By SUBWAY_STATION_2 = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[10]/button/div[2]");
    private By PHONE_NUMBER = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    private By NEXT_FORM_BUTTON = By.xpath("/html/body/div/div/div[2]/div[3]/button");


    public PersonalDataForm(WebDriver driver){
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(NAME).clear();
        driver.findElement(NAME).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(SURNAME).clear();
        driver.findElement(SURNAME).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(address);
    }

    public void enterSubwayStation_1() {
        driver.findElement(SUBWAY).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SUBWAY_STATION_1));
        driver.findElement(SUBWAY_STATION_1).click();
    }

    public void enterSubwayStation_2() {
        driver.findElement(SUBWAY).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SUBWAY_STATION_2));
        driver.findElement(SUBWAY_STATION_2).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
    }

    public void nextFormButtonClick() {
        driver.findElement(NEXT_FORM_BUTTON).click();
    }

}
