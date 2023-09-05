import java.security.PublicKey;
import java.util.Scanner;

public class WagonNaCiekłeMateriałyToksyczne extends WagonTowarowyCiężki{



    private int pojemność;

    private boolean czyJestIzolowany;


    public WagonNaCiekłeMateriałyToksyczne(String systemHamulcowy, String zabezpieczenia, int pojemność, boolean czyJestIzolowany) {
        super(systemHamulcowy,zabezpieczenia);
        this.pojemność = pojemność;
        this.czyJestIzolowany = czyJestIzolowany;
    }

    public void sprawdźWagon(){
        System.out.println("Sprawdzam wagon.....");
        if (czyJestIzolowany){
            System.out.println("Wagon gotowy do transportu");
        }else if (!czyJestIzolowany){
            System.out.println("Wagon nie spełnia wymagań bezpieczeństwa");
        }else System.out.println("Wagon wymaga napraw");
    }

    public void rozładunekWagonu(){
        System.out.println("Dostepne rodzaje cieczy: kwas_siarkowy lub substancja_żrąca");
        Scanner s = new Scanner(System.in);
        System.out.println("podaj rodzaj materiału:");
        String materiał = s.next();
        System.out.println("Rozładunek materiału :" + materiał + " z wagonu...");
        switch (materiał){
            case "kwas_siarkowy":
                for (int i=0; i<pojemność;i++){
                    System.out.println("Rozładowano " + i+ "litrów kwasu siarkowego.");
                }
                break;
            case "substancja_żrąca":
                for (int i = 0; i < pojemność; i++) {
                    System.out.println("Rozładowano " + i + " litrów substancji żrącej.");
                }
                break;
            default:
                System.out.println("Nie można rozładować materiału!! - nieznana substancja ");

        }
    }






}
