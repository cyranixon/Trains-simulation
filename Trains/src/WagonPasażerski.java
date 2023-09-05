import java.util.Scanner;

public class WagonPasażerski extends Wagon implements PodlaczenieDoSieci{

    private int pojemność;

    private int pasażerowie;

    public WagonPasażerski() {
        super();
        this.pojemność = 100;
        this.pasażerowie = random.nextInt(20,200);
    }



    public void czyJestMiejsce(){
        if (pasażerowie > pojemność) {
            System.out.println("Nie ma juz wolnych miejsc!!");
        }else if(pasażerowie<pojemność){
            System.out.println("Są wolne miejsca");
        }
    }

    public void wybierzKlasęWagonu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Wybierz klasę wagonu od 1 do 3");
        int klasaWagonu = s.nextInt();

        switch (klasaWagonu){
            case 1:
                System.out.println("Jedziesz w pierwszej klasie.");
                break;
            case 2:
                System.out.println("Jedziesz w drugiej klasie");
                break;
            case 3:
                System.out.println("Jedziesz w trzeciej klasie.");
                break;
            default:
                System.out.println("Nie ma takiej klasy wagonu.");
                break;
        }
    }





    @Override
    public void podłączonoDoSieci() {

    }
}
