package HugeInteger;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

public class HugeIntegerTest {
    private HugeInteger hugeInteger1;
    private HugeInteger hugeInteger2;

    @BeforeEach
    public void setThisUp(){

        hugeInteger1 = new HugeInteger();
        hugeInteger2 = new HugeInteger();
    }

    @Test
    void testToCheckThatHugeIntegerArrayHasLengthForty(){
        hugeInteger1.getArray();
        assertEquals(40,hugeInteger1.getArrayLength());
    }

    @Test
    void testThatHugeIntegerArrayCanNotContainLetters(){
        String number = "78976567898S6789876567893434343456785466";
        hugeInteger1.parse(number);
        int[] array = hugeInteger1.getArray();
        assertEquals(Arrays.toString(new int[]{7, 8, 9, 7, 6, 5, 6, 7, 8, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), Arrays.toString(array));
    }

    @Test
    void testThatHugeIntegerArrayCanNotContainMoreThanFourtyElements(){
        String number = "78976567898767898765678934343434567854667";
        hugeInteger1.parse(number);
        int[] array = hugeInteger1.getArray();
        assertEquals(Arrays.toString(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), Arrays.toString(array));
    }


    @Test
    void testToAddTwoTwoHugeIntegerArray(){
        String number = "7897656789876789876567893434343456785464";
        hugeInteger1.parse(number);
        String number2 = "7897656789876789876567893434343456785466";
        hugeInteger2.parse(number2);
        HugeInteger hugeInteger = hugeInteger1.add(hugeInteger2);
        assertEquals(Arrays.toString(new int[]{15, 7, 9, 5, 3, 1, 3, 5, 7, 9, 7, 5, 3, 5, 7, 9, 7, 5, 3, 1, 3, 5, 7, 9, 7, 9, 7, 9, 7, 9, 7, 9, 1, 3, 5, 7, 1, 9, 3, 0}), Arrays.toString(hugeInteger.getArray()));
    }

    @Test
    void testToSubtractTwoTwoHugeIntegerArray(){
        String number = "6574326789873589876567893934343423495479";
        hugeInteger1.parse(number);
        String number2 = "7897656789876789876567893434343456785466";
        hugeInteger2.parse(number2);
        HugeInteger hugeInteger = hugeInteger1.subtract(hugeInteger2);
        assertEquals(Arrays.toString(new int[]{-1, 3, 2, 3, 3, 3, 0, 0, 0, 0, 0, 0, 3, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 0, 0, 0, 0, 0, 0, 3, 3, 2, 8, 9, 9, 8, 7}), Arrays.toString(hugeInteger.getArray()));
//        assertEquals(496, sum);
    }

    @DisplayName("Returns true when two huge integer compared are equal")
    @Test
    void isEqualToTest() {
        String number1 = "7897656789876789876567893434343456785466";
        hugeInteger1.parse(number1);

        String number2 = "7897656789876789876567893434343456785466";
        hugeInteger2.parse(number2);

        boolean result = hugeInteger1.isEqualTo(hugeInteger2);
        assertTrue(result);
    }

    @DisplayName("Returns false when two huge integer arrays compared are equal")
    @Test
    void isNotEqualToTest() {
        String number1 = "7797656789876789876567893434343456785466";
        hugeInteger1.parse(number1);

        String number2 = "7897656789876789876567893434343456785466";
        hugeInteger2.parse(number2);

        boolean result = hugeInteger1.isNotEqualTo(hugeInteger2);
        assertTrue(result);
    }

    @DisplayName("Returns true if one huge integer array is less than the other")
    @Test
    void isLessThanTest() {
        String number1 = "7897656789876789876567893434343456785465";
        hugeInteger1.parse(number1);

        String number2 = "7897656789876789876567893434343456785466";
        hugeInteger2.parse(number2);

        boolean result = hugeInteger1.isLessThan(hugeInteger2);
        assertTrue(result);
    }


}