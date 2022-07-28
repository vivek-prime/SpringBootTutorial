package com.example.SpringBootTutorial.utlities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyDictionaryTest {
    private MyDictionary dictMock;

    @BeforeAll
    void setUp() {
        log.info("Tests are going to start");
        dictMock = mock(MyDictionary.class);
    }

    @Test()
    @DisplayName("Throw Null Pointer Exception when key is not found")
    public void throwException() {

        when(dictMock.getMeaning(anyString())).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"), "Key not found");
    }
}