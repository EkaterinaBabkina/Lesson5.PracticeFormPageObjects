package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.firstName;
import static tests.TestData.lastName;

public class PracticeFormTestsFaker extends TestBase {
        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                phone = faker.phoneNumber().subscriberNumber(10),
                currentAddress = faker.address().fullAddress();

        @Test
        void selenidePracticeTestFaker() {
                registrationPage.openPage();
                $("#firstName").setValue(firstName);
                $("#lastName").setValue(lastName);
                $("#userEmail").setValue(userEmail);
                $("#genterWrapper").$(byText("Male")).click();
                $("#userNumber").setValue(phone);
                $("#dateOfBirthInput").click();
                registrationPage.calendar.setDate();
                $("#subjectsInput").setValue("Commerce").pressEnter();
                $("#subjectsInput").setValue("Eco").pressEnter();
                $("#hobbiesWrapper").$(byText("Reading")).click();
                $("#hobbiesWrapper").$(byText("Music")).click();
                $("#uploadPicture").uploadFromClasspath("img/1.png");
                $("#currentAddress").setValue(currentAddress);
                $("#stateCity-wrapper").$(byText("Select State")).click();
                $("#stateCity-wrapper").$(byText("NCR")).click();
                $("#stateCity-wrapper").$(byText("Select City")).click();
                $("#stateCity-wrapper").$(byText("Delhi")).click();
                $("#submit").click();
                $(".modal-title").shouldHave(text("Thanks for submitting the form"));
                $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                        text(userEmail), text("Male"), text(phone), text("06 October,1993"),
                        text("Commerce, Economics"), text("Reading, Music"), text("1.png"), text(currentAddress), text("NCR Delhi"));
        }
}