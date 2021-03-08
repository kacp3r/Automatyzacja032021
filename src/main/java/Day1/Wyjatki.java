package Day1;

public class Wyjatki {

    public static void m1(){
        int x = 10;
        int y = 0;

        try{
            System.out.println("Start");
            double z = x / y;
            System.out.println("udało się");
        } catch (ArithmeticException e) {
            System.out.println("Wyjątek!!!");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            throw new ArithmeticException("Dzielił przez zero jełop!");
        } finally {
            System.out.println("zawsze się wykona na koniec");
        }

        System.out.println("Już po");
    }

    public static void m2(){
        m1();
    }

    public static void main(String[] args) {
        m2();
    }
}
