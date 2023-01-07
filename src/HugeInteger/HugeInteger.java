package HugeInteger;

import java.util.Arrays;
import java.util.List;

public class HugeInteger {
    private final int[] array;

    public HugeInteger(){
        array = new int[40];
    }


    public int getArrayLength() {

        return array.length;
    }

    public int[] getArray() {
        return array;
    }

    public void parse(String number) {
        if (number.length() < getArrayLength() || number.length() == getArrayLength()) {
            try {
                for (int i = 0; i < number.length(); i++) {
                        char s = number.charAt(i);
                        int y = Integer.parseInt(String.valueOf(s));
                        array[i] += y;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must contain only digits");
            }
        }else {
            System.out.println("Huge integer can only be 40 digits");
        }
    }

    public HugeInteger add(HugeInteger hugeInteger2) {
        int[] firstArray = this.getArray();
        int[] secondArray = hugeInteger2.getArray();
        int count = this.getArrayLength() - 1;
        int remainder = 0;

        HugeInteger hugeInteger = new HugeInteger();
        int[] thirdArray = hugeInteger.getArray();

        for(int i = count; i >= 0; ){
                int sum = (firstArray[i] + remainder) + secondArray[i];
                if (sum > 9 && i != 0) {
                    int loop = sum % 10;
                    thirdArray[count] = loop;
                    remainder = sum / 10;
                }else {
                    thirdArray[count] = sum;
                }
                count--;
                i--;
        }
        return hugeInteger;
    }

    public HugeInteger subtract(HugeInteger hugeInteger2) {
        int[] firstArray = this.getArray();
        int[] secondArray = hugeInteger2.getArray();
//        int[] total = new int[40];
        int count = this.getArrayLength()- 1;
        int borrow = 0;
        int difference = 0;
        HugeInteger hugeInteger = new HugeInteger();
        int[] thirdArray = hugeInteger.getArray();

        for(int i = 40-1; i >= 0; ){
            for (int j = 40-1; j >= 0; j--){
                if (secondArray[j] >= firstArray[i]) {
                    difference = secondArray[j] - firstArray[i];
                    thirdArray[count] = difference;
                }else {
                    int check = j -1;
                    secondArray[check] = secondArray[check] - 1;
                    borrow = 1*10;
                   difference = (secondArray[j] + borrow) - firstArray[i];
                    thirdArray[count] = difference;
                }
                if (firstArray[1] < secondArray[1]){
                    thirdArray[0]*=-1;
                }
                count--;
                i--;
            }
        }
        return hugeInteger;
    }

    @Override
    public String toString() {
        return "HugeInteger{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public boolean isEqualTo(HugeInteger hugeInteger2) {
        int[] array1 = this.getArray();
        int[] array2 = hugeInteger2.getArray();
        return Arrays.equals(array1, array2);
    }

    public boolean isNotEqualTo(HugeInteger hugeInteger2) {
        int[] array1 = this.getArray();
        int[] array2 = hugeInteger2.getArray();
        return !Arrays.equals(array1, array2);
    }

    public boolean isLessThan(HugeInteger hugeInteger2) {
        int[] array1 = this.getArray();
        int[] array2 = hugeInteger2.getArray();

        for(int i = 0; i < 40; i++){
            if (array1[i] < array2[i]){
                return true;
            }
        }

        return false;
    }
}
