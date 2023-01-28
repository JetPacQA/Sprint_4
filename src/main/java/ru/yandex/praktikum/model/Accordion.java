package ru.yandex.praktikum.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Accordion {
    private WebDriver driver;


    public Accordion (WebDriver driver){
        this.driver = driver;
    }

    public void clickToAccordionHeading(String heading) {
        driver.findElement(By.id(heading)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(heading)));
    }

    public void compareText(String panel, String reference) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(panel)));
        String textFromPanel = driver.findElement(By.id(panel)).getText();
        assertEquals("Текст не совпадет с эталонным", reference, textFromPanel);

    }





}
