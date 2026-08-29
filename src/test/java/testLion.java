package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void constructorAcceptsValidSex(String sex) throws Exception {
        assertDoesNotThrow(() -> new Lion(sex));
    }

    @Test
    void constructorThrowsOnInvalidSex() {
        Exception e = assertThrows(Exception.class, () -> new Lion("Неизвестно"));
        assertTrue(e.getMessage().contains("допустимые значения"));
    }

    @Test
    void doesHaveManeTrueForMale() throws Exception {
        assertTrue(new Lion("Самец").doesHaveMane());
    }

    @Test
    void doesHaveManeFalseForFemale() throws Exception {
        assertFalse(new Lion("Самка").doesHaveMane());
    }

    @Test
    void getKittensReturnsFromFeline() throws Exception {
        assertEquals(1, new Lion("Самец").getKittens());
    }

    @Test
    void getFoodReturnsPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), new Lion("Самец").getFood());
    }
}
