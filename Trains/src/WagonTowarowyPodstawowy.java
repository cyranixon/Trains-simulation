import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WagonTowarowyPodstawowy extends Wagon{




    private List ladunki;


    private int ilośćPersonelu;


    private boolean czyOtwarte;

    public WagonTowarowyPodstawowy() {
        super();
        this.ladunki = new ArrayList<>(Arrays.asList("Lody", " Warzywa", "elektronika","słodycze","węgiel"));
        this.ilośćPersonelu = random.nextInt(10,80);
    }

    public void otworzDrzwi(){
       czyOtwarte = true;
    }
    public void zamknijDrzwi(){
        czyOtwarte = false;
    }

    public void wejściePersonelu(){
        otworzDrzwi();
        if (ilośćPersonelu > 50){
            System.out.println("Za duża liczba personelu - zamykam dzrzwi ");
            zamknijDrzwi();
        }else if (ilośćPersonelu < 50 && ilośćPersonelu >30){
            System.out.println("Pomyślnie wpuszczono persolnel");
            zamknijDrzwi();
        }else if (ilośćPersonelu < 30){
            System.out.println("Za mało personelu - czekam na więcej osób");
            otworzDrzwi();
        }

    }

    public void wybierzRodzajŁadunku(){

        Scanner s = new Scanner(System.in);
        System.out.println("Wybierz rodzaj ładunku do przewozu:"+ladunki);
        String ladunek = s.nextLine();

        switch (ladunek){
            case "Lody":
                System.out.println("Załadowano wagon ladunkiem: "+ladunek);
                break;
            case "Warzywa":
                System.out.println("Załadowano wagon ladunkiem:"+ladunek);
                break;
            case"elektronika":
                System.out.println("Załadowano wagon ladunkiem:"+ladunek);
                break;
            case "słodycze":
                System.out.println("Załadowano wagon ladunkiem:"+ladunek);
                break;
            case "węgiel":
                System.out.println("Załadowano wagon ladunkiem:"+ladunek);
                break;
            default:
                System.out.println("Nieznany typ towaru.");

        }
    }

    public List getLadunki() {
        return ladunki;
    }

    public int getIlośćPersonelu() {
        return ilośćPersonelu;
    }

    public boolean isCzyOtwarte() {
        return czyOtwarte;
    }
}
