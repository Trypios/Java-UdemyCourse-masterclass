public class PrimitiveTypesChallenge {

    public static void main(String[] args) {

        byte byteNum = 5;
        short shortNum = 25;
        int intNum = 205;
        long longNum = 50_000L + 10 * (byteNum + shortNum + intNum);

        System.out.println(longNum);

    }
}