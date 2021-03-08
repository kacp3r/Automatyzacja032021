package Day1.Pkg2;

import Day1.Pkg1.Class1;

public class Class1InstanceInAnotherPkg {
    public void metoda3() {
        Class1 dupa = new Class1();
        dupa.publiczna = 1;
        //dupa.protektowana = 1;
        //dupa.zadna = 1;
        //dupa.prywatna = 1;
    }
}
