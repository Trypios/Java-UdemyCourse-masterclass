public class FloorPacker {

    public static void main(String[] args) {

        System.out.println(canPack (1, 0, 4)); //should return false since bigCount is 1 (big bag of 5 kilos) and goal is 4 kilos.
        System.out.println(canPack (1, 0, 5)); //should return true since bigCount is 1 (big bag of 5 kilos) and goal is 5 kilos.
        System.out.println(canPack (0, 5, 4)); //should return true since smallCount is 5 (small bags of 1 kilo) and goal is 4 kilos, and we have 1 bag left which is ok as mentioned above.
        System.out.println(canPack (2, 2, 11)); //should return true since bigCount is 2 (big bags 5 kilos each) and smallCount is 2 (small bags of 1 kilo), makes in total 12 kilos and goal is 11 kilos.
        System.out.println(canPack (-3, 2, 12)); //should return false since bigCount is negative.

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        //bigCount = count of big flour bags (5kg each). smallCount = count of small flour bags (1kg each)
        //goal = amount of kg of flour needed to assemble a package.
        if ((bigCount < 0) || (smallCount <0) || (goal < 0)) {
            return false;
        }
        int target = 0;
        while ((target < goal) && (bigCount != 0)) {
            target += 5;
            bigCount --;
            if (target > goal) {
                target -= 5;
                break;
            } else if (target == goal) {
                return true;
            }
        }
        while ((target < goal) && (smallCount != 0)) {
            target += 1;
            smallCount --;
            if (target == goal) {
                return true;
            }
        }
        return false;
    }

}