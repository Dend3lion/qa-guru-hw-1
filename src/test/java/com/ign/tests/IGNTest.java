package com.ign.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IGNTest extends TestBase {
    @BeforeEach
    void setUp() {
        open("https://ign.com/");
    }

    @ValueSource(strings = {
            "Home",
            "Search",
            "Reviews"
    })
    @ParameterizedTest(name = "Category {0} should be present")
    @DisplayName("Navigation menu should display valid categories")
    void CategoriesTest(String category) {
        $(".sidebar-section").$(byText(category)).shouldBe(visible);
    }

    @CsvSource(value = {
            "Diablo 4, Blizzard",
            "Final Fantasy XVI, Square Enix",
            "Starfield, Bethesda Game Studios"
    })
    @ParameterizedTest(name = "Game {0} should be published by {1}")
    @DisplayName("Searched games should display valid name, publisher, release date")
    void SearchResultsTest(String name, String publisher) {
        $(".sidebar-section").$(byText("Search")).click();
        $("input[type='search']").setValue(name);
        $("a[title='Go to game']").shouldHave(text(publisher));
    }

    static Stream<Arguments> categoriesSubcategories() {
        return Stream.of(
                Arguments.of("Reviews", List.of("All Reviews", "Editor's Choice", "Game Reviews", "Movie Reviews", "TV Show Reviews", "Tech Reviews")),
                Arguments.of("News", List.of("All News", "Columns", "PlayStation", "Xbox", "Nintendo", "PC", "Mobile", "Movies", "Television", "Comics", "Tech"))
        );
    }

    @MethodSource("categoriesSubcategories")
    @ParameterizedTest(name = "Category {0} should have subcategory {1}")
    @DisplayName("Navigation categories should have valid subcategories")
    void categoriesSubcategoriesTest(String category, List<String> subcategories) {
        $(".sidebar-section").$(byText(category)).click();
        $(".sidebar-section." + category.toLowerCase()).$$(".navigation-item").shouldHave(texts(subcategories));
    }
}
