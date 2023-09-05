import java.util.Random;

public abstract class Wagon {

    private int idNumber;
    private int wagaNetto;
    private int wagaBrutto;

    Random random = new Random();

    private static int counter = 1 ;


    public Wagon() {

        this.wagaNetto = random.nextInt(1000,1500);
        this.wagaBrutto = random.nextInt(1500,2000);
        idNumber = counter++;
    }

    public int getWagaNetto() { return wagaNetto; }

    public int getWagaBrutto() { return wagaBrutto; }

    @Override
    public String toString() {
        return "Wagon{" +
                "idNumber=" + idNumber +
                ", wagaNetto=" + wagaNetto +
                ", wagaBrutto=" + wagaBrutto +
                '}';
            }
}
