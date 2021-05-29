public class BinaryAdder
{

    /**
     * Start up
     * @param args first and second value need to be the integers to add, third value is the bitsize
     */
    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int bitsize = Integer.parseInt(args[2]);

        Adder _adder = new Adder(bitsize);

        int result = _adder.add(number1, number2);
        System.out.println("The Result of " + number1 + " + " + number2 + " is " + result);
    }
}
