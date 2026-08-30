package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LionParametrizedTest {

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void constructorAcceptsValidSex(String sex) throws Exception {
        assertDoesNotThrow(() -> new Lion(sex, feline));
    }
}
