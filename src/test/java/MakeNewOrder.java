import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.model.MainPage;
import ru.yandex.praktikum.model.OrderStatus;
import ru.yandex.praktikum.model.PersonalDataForm;
import ru.yandex.praktikum.model.RentalInformationForm;

@RunWith(Parameterized.class)
public class MakeNewOrder {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final String comment;

    public MakeNewOrder(String name, String surname, String address, String phoneNumber, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;

    }


    @Parameterized.Parameters
    public static Object[][] personalData() {
        return new Object[][] {
                {"Иван", "Иванов", "улица Пушкина, дом Колотушкина, кв. 1", "899911122333", "23.02.2023", "Без комментариев"},
                {"Антон", "Смирнов", "улица Орджоникидзе, д. 14, кв. 88", "899911122444", "03.06.2023", "Позвонить перед доставкой"},
        };
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void newOrderThroughTopButton() {
        MainPage mainPage = new MainPage(driver);
        PersonalDataForm personalDataForm = new PersonalDataForm(driver);
        RentalInformationForm rentalInformationForm = new RentalInformationForm(driver);
        OrderStatus orderStatus = new OrderStatus(driver);
        mainPage.openMainPage();
        mainPage.clickToCookieButton();
        mainPage.clickToTopOrderButton();
        personalDataForm.enterName(name);
        personalDataForm.enterSurname(surname);
        personalDataForm.enterAddress(address);
        personalDataForm.enterSubwayStation_1();
        personalDataForm.enterPhoneNumber(phoneNumber);
        personalDataForm.nextFormButtonClick();
        rentalInformationForm.enterDeliveryDate(date);
        rentalInformationForm.chooseRentalPeriod_1();
        rentalInformationForm.clickCheckBox_1();
        rentalInformationForm.enterComment(comment);
        rentalInformationForm.clickOrderButton();
        rentalInformationForm.clickYesButton();
        orderStatus.checkSuccessModal();
    }

    @Test
    public void newOrderThroughDownButton() {
        MainPage mainPage = new MainPage(driver);
        PersonalDataForm personalDataForm = new PersonalDataForm(driver);
        RentalInformationForm rentalInformationForm = new RentalInformationForm(driver);
        OrderStatus orderStatus = new OrderStatus(driver);
        mainPage.openMainPage();
        mainPage.clickToCookieButton();
        mainPage.scrollAndClickToDownOrderButton();
        personalDataForm.enterName(name);
        personalDataForm.enterSurname(surname);
        personalDataForm.enterAddress(address);
        personalDataForm.enterSubwayStation_2();
        personalDataForm.enterPhoneNumber(phoneNumber);
        personalDataForm.nextFormButtonClick();
        rentalInformationForm.enterDeliveryDate(date);
        rentalInformationForm.chooseRentalPeriod_2();
        rentalInformationForm.clickCheckBox_2();
        rentalInformationForm.enterComment(comment);
        rentalInformationForm.clickOrderButton();
        rentalInformationForm.clickYesButton();
        orderStatus.checkSuccessModal();
    }

    @After
    public void cleanUp() {
        OrderStatus orderStatus = new OrderStatus(driver);
        orderStatus.deleteOrderAfterTest();
        driver.quit();
    }


}
