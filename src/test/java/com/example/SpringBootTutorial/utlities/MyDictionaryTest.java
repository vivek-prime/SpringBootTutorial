package com.example.SpringBootTutorial.utlities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
class MyDictionaryTest {

    @BeforeEach
    void setUp() {
    }

    @Test()
    @DisplayName("Throw Null Pointer Exception when key is not found")
    public void throwException() {
        MyDictionary dictMock = mock(MyDictionary.class);
        when(dictMock.getMeaning(anyString())).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"), "Key not found");
    }
}