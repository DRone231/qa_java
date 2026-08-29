package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    void getSoundReturnsMya() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodDelegatesToPredatorEatMeat() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(feline).eatMeat();
    }
}
