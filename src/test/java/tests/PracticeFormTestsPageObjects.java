package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.firstName;
import static tests.TestData.lastName;

public class PracticeFormTestsPageObjects extends TestBase {


        @Test
        void selenidePracticeTest() {
                open("/automation-practice-form");
                $("#firstName").setValue(firstName);
                $("#lastName").setValue(lastName);
                $("#userEmail").setValue("chbmptbnp@kalinkin.ru");
                $("#genterWrapper").$(byText("Male")).click();
                $("#userNumber").setValue("4654586274");
                $("#dateOfBirthInput").click();
                $(".react-datepicker__month-select").click();
                $(".react-datepicker__month-select").$(byText("October")).click();
                $(".react-datepicker__year-select").click();
                $(".react-datepicker__year-select").$(byText("1993")).click();
                $x("//div[contains(@aria-label,\"October 6th, 1993\")]").click();
                $("#subjectsInput").setValue("Commerce").pressEnter();
                $("#subjectsInput").setValue("Eco").pressEnter();
                $("#hobbiesWrapper").$(byText("Reading")).click();
                $("#hobbiesWrapper").$(byText("Music")).click();
                $("#uploadPicture").uploadFromClasspath("img/1.png");
                $("#currentAddress").setValue("Moscow, Kalinkina str, 75");
                $("#stateCity-wrapper").$(byText("Select State")).click();
                $("#stateCity-wrapper").$(byText("NCR")).click();
                $("#stateCity-wrapper").$(byText("Select City")).click();
                $("#stateCity-wrapper").$(byText("Delhi")).click();
                $("#submit").click();
                $(".modal-title").shouldHave(text("Thanks for submitting the form"));
                $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                        text("chbmptbnp@kalinkin.ru"), text("Male"), text("4654586274"), text("06 October,1993"),
                        text("Commerce, Economics"), text("Reading, Music"), text("1.png"), text("Moscow, Kalinkina str, 75"), text("NCR Delhi"));
        }
}


