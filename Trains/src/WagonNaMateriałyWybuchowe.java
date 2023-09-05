public class WagonNaMateriałyWybuchowe extends WagonTowarowyCiężki{



    private boolean testWagonu;

    private boolean czyDziała;





    public WagonNaMateriałyWybuchowe(String systemHamulcowy, String zabezpieczenia) {
        super(systemHamulcowy,zabezpieczenia);
        this.testWagonu = false;
        this.czyDziała = false;
    }


    public void kontrolaWagonu(){
        System.out.println("Rozpoczynam kontrolę wagonu....");

        for (int i =6; i>0;i--){
            System.out.println("Pozostało "+ i + " sekund...");
        }
        this.testWagonu = true;
        System.out.println("Wagon przeszedł kontrole pomyślnie - zatwierdzam możliwość wyruszenia w trase");
    }
    public void naprawaWagonu(){
        System.out.println("Rozpoczynam naprawę wagonu....");

        for (int i =6; i>0;i--){
            System.out.println("Pozostało "+ i + " sekund...");
        }
        this.czyDziała = true;
        System.out.println("Wagon naprawiony! - szerokiej drogi!");
    }

    public void sprawdźStan(){
        System.out.println("Sprawdzanie sprawności technicznej wagonu");
        if (!this.testWagonu){
            System.out.println("Wagon nie przeszedł jeszcze kontroli!");
            return;
        }
        if (!this.czyDziała){
            System.out.println("Wagon jest uszkodzony - wymagana naprawa");
            return;
        }
        System.out.println("Wagon jest gotowy do przewozu ładunku");
    }

    public boolean isTestWagonu() {
        return testWagonu;
    }

    public boolean isCzyDziała() {
        return czyDziała;
    }
}
