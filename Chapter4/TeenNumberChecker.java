public class TeenNumberChecker {
    public static boolean hasTeen(int x, int y, int z) {
           if (x>=13 && x<=19) {
               return true;
           } else if (y>=13 && y<=19) {
               return true;
           } else if (z>=13 && z<=19) {
               return true;
           }
           return false;
   
       }
   
       public static boolean isTeen(int a) {
           return a>=13 && a<=19;
       }
   }