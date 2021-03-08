package Day1;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    public static void main(String[] args) {
        Piwo lager = new Piwo("lager", 13.1);
        System.out.println(lager.czyPiwo(17));
        System.out.println(lager.czyPiwo(122));

        List<Piwo> menu = new ArrayList<>();
        menu.add(lager);
        menu.add(new Piwo("stout", 8.8));
        menu.add(new Piwo("IPA", 3.3));
        menu.add(new Piwo("porter", 1.1));
//        System.out.println(menu.get(1)); //to działa tak jakby tam było .toString()
//
//        menu.remove(0);
//        System.out.println(menu.get(0));
//
//        System.out.println(menu.size());
//        System.out.println(menu);
//        for (Piwo piwo : menu) {
//            System.out.println(piwo + " " + menu.indexOf(piwo));
//        }

        IPA ipa = new IPA("Crazy Mike", 8.0, 100);
        System.out.println(ipa);
        Piwo ipa2 = new IPA("Rowing Jack", 11.1, 0);  // polimorfizm, ipa jest piwem

        menu.add(ipa);  // polimorfizm, ipa jest piwem, wchodzi do listy piw
        menu.add(ipa2);

        for (Piwo piwo : menu) {
            System.out.println(piwo + " " + menu.indexOf(piwo));
        }
    }
}
