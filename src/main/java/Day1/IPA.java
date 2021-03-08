package Day1;

public class IPA extends Piwo {
    private int ibu;


    public IPA(String nazwa, double moc, int ibu) {
        super(nazwa, moc);
        this.ibu = ibu;
    }

    @Override
    public String toString() {
        return "IPA{" +
                "ibu=" + ibu +
                ", moc=" + moc +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
