package ru.yandex.praktikum.model;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    private By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");
    private By ACCORDION = By.className("Home_FAQ__3uVm4");
    private By TOP_ORDER_BUTTON = By.className("Button_Button__ra12g");
    private By DOWN_ORDER_BUTTON = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");



    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void clickToCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void scrollToAccordion() {
        WebElement element = driver.findElement(ACCORDION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickToTopOrderButton() {
        driver.findElement(TOP_ORDER_BUTTON).click();
    }

    public void scrollAndClickToDownOrderButton() {
        WebElement element = driver.findElement(DOWN_ORDER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(DOWN_ORDER_BUTTON));
        driver.findElement(DOWN_ORDER_BUTTON).click();
    }


}
