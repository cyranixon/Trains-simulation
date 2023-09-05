import java.util.Scanner;

public class WagonNaMateriałyCiekłe extends WagonTowarowyPodstawowy {




    private boolean wentylBezpieczeństwa;

    private boolean odpornoścNaRdzewienie;

    private int zbiornik;

    private Scanner s;

    public WagonNaMateriałyCiekłe() {
        super();
        this.s = new Scanner(System.in);

    }


    public void zJakiegoMateriałuJestZbiornik(){
        System.out.println("wybierz zbiornik na ciecz: ");
        System.out.println("1 - metalowy");
        System.out.println("2 - tworzywo sztuczne");
        System.out.println("3 - stalowy");

        this.zbiornik = s.nextInt();
        switch (zbiornik) {
            case 1:
                System.out.println("Zbiornik wykonany z metalu.");
                break;
            case 2:
                System.out.println("Zbiornik wykonany z tworzywa sztucznego.");
                break;
            case 3:
                System.out.println("Zbiornik wykonany ze stali");
            default:
                System.out.println("Nieznany typ zbiornika.");
                break;
        }
    }

    public void sprawdzBezpieczeństwoWagonu(){
        if (wentylBezpieczeństwa && odpornoścNaRdzewienie){
            System.out.println("Wagon spełnia wymogi bezpieczeństwa");
        }else if( wentylBezpieczeństwa ){
            System.out.println("Wagonowi brakuje odporności na rdzewienie  - nie spełnia minimalnych wymogów");
        } else if (odpornoścNaRdzewienie) {
            System.out.println("Wagonowi brakuje wentylu bepieczeństwa - nie spełnia minimalnych wymogw");
        }else {
            System.out.println("Wagon nie spełnia minimalnych wymogów bezpieczeństwa");
        }
    }

    public void jestWentylBezpieczeństwa() {
        this.wentylBezpieczeństwa = true;
    }

    public void nieMaWentylBezpieczeństwa() {
        this.wentylBezpieczeństwa = false;
    }

    public void jestOdpornoścNaRdzewie() {
        this.odpornoścNaRdzewienie = true;
    }

    public void nieMaOdpornoścNaRdzewienie() {
        this.odpornoścNaRdzewienie = false;
    }


}
