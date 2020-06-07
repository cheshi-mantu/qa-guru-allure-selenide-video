package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static helpers.Environment.*;

@Epic("QA.GURU automation course")
@Story("Search tests with video")
@Tag("search_tests")
class SearchTests extends TestBase {
    @Test
    @Description("Open page, search for string, try to match")
    @DisplayName("Successful search test")
    void successfulSearch() {
        step("Open search page by URL " + urlstring , ()-> open(urlstring));
        step("Enter search test " + searchstring, ()->{
            $(byName("q")).val(searchstring).pressEnter();
        });
        step("Check if searched string is present in search output", ()->{
            $("html").shouldHave(text(searchstring));
        });
    }

}