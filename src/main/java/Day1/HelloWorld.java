package Day1;

public class HelloWorld {
    public static String wiadomosc = "Hello";
    public static int ile_razy_wyswietlic = 6;

    public static void drukuj_wiadomosc(String wiadomosc_do_wyswietlenia, int ile_razy) {
        int i = 0;
        while (i<ile_razy){
            System.out.println(wiadomosc_do_wyswietlenia);
            i++;
        }
    }

    public static void main(String[] args) {
//        String message = "Hello World";
//
//        String message2 = new String("Hello World");
//
//        System.out.println(message.equals("Hello World"));
//        System.out.println(message == message2);
//
//        String number = "123";
//        System.out.println(123 == Integer.parseInt(number));
//
//        String number2 = "123.456.789";
//        System.out.println(123456789 == Integer.parseInt(number2.replace(".", "")));
//
//        System.out.println( "message" );

        drukuj_wiadomosc(wiadomosc, ile_razy_wyswietlic);
    }
}
