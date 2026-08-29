package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructorThrowsOnInvalidSex() {
        Exception e = assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
        assertTrue(e.getMessage().contains("допустимые значения"));
    }

    @Test
    void doesHaveManeTrueForMale() throws Exception {
        assertTrue(new Lion("Самец", feline).doesHaveMane());
    }

    @Test
    void doesHaveManeFalseForFemale() throws Exception {
        assertFalse(new Lion("Самка", feline).doesHaveMane());
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, new Lion("Самец", feline).getKittens());
        verify(feline).getKittens();
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), new Lion("Самец", feline).getFood());
        verify(feline).getFood("Хищник");
    }
}
