package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Add5Test {

    private Add5 add5;

    @BeforeEach
    public void setup(){
        add5 = new Add5();
    }


    @ParameterizedTest(name = "Given {0} return {1}")
    @MethodSource("add5TestCases")
    public void add5_givenValue_thenReturnValuePlus5(int value, int expectedResult){
        int actualValue = add5.add5(value);
        assertThat(actualValue).isEqualTo(expectedResult);
    }


    public static Stream<Arguments> add5TestCases(){
        return Stream.of(
                Arguments.of(0, 5),
                Arguments.of(-5, 0),
                Arguments.of(5, 10),
                Arguments.of(10, 15),
                Arguments.of(-10, -5)
        );
    }

}
