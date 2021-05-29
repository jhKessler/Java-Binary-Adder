import java.util.Arrays;

public class Adder
{
    private int _bitSize;
    private int _maxNum;

    public Adder(int bitSize) {
        _bitSize = bitSize;
    }

    public int add(int number1, int number2) {
        boolean[] num1AsBits = convertToBits(number1);
        boolean[] num2AsBits = convertToBits(number2);

        boolean[] resultBits = addBits(num1AsBits, num2AsBits);
        return convertToInt(resultBits);
    }

    private boolean[] addBits(boolean[] num1AsBits, boolean[] num2AsBits) {
        boolean[] resultBits = new boolean[_bitSize];

        boolean incrementNextBit = false;
        boolean bitSum = false;
        boolean bitXor;

        for (int i=0; i < _bitSize; i++) {
            bitXor = num1AsBits[i] ^ num2AsBits[i];
            bitSum = bitXor ^ incrementNextBit;
            incrementNextBit = num1AsBits[i] && num2AsBits[i] || bitXor && incrementNextBit;
            resultBits[i] = bitSum;
        }

        return resultBits;
    }

    private boolean[] convertToBits(int number) {

        boolean[] bitArray = new boolean[_bitSize];

        for (int i=0; i<_bitSize; i++) {
            bitArray[i] = (number & 1 << i) != 0;
        }
        return bitArray;
    }

    private int convertToInt(boolean[] bits) {
        int result = 0;
        for (int i=0; i<_bitSize; i++) {
            if (bits[i]) {
                result += 1 << i;
            }
        }
        return result;
    }

}
