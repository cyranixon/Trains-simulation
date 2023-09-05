public class WagonChłodniczy extends Wagon implements PodlaczenieDoSieci {


    private boolean czyDrzwiOtwarte;

    private int temperatura;

    public WagonChłodniczy(boolean czyDrzwiOtwarte , int temperatura) {

        super();
        this.czyDrzwiOtwarte = czyDrzwiOtwarte;
        this.temperatura = temperatura;
    }

    public void zamknijDrzwi(){
        czyDrzwiOtwarte = false;
    }

    public  void otworzDrzwi(){
        czyDrzwiOtwarte = true;
    }
    public void ustawTemperature(int nowaTemperatura){
        temperatura = nowaTemperatura;
    }


    public void uruchomChłodzenie(){
        System.out.println("Włączono system chłodniczy.");
    }

    public void wyłączChłodzenie(){
        System.out.println("Wyłączono system chłodniczy");
    }


    public void monitorowanieTemperatury(){
        if (temperatura < 0){
            System.out.println("Temperatura spadład poniżej zera. Redukuję temperature 0");
            wyłączChłodzenie();
        }else if (temperatura > 10){
            System.out.println("Temperatura przekroczyła 10 stopni. Redukuję temperature do 0");
            uruchomChłodzenie();
        }else System.out.println("Wagon pomyślnie sie chłodzi");
    }


    public void transportTowaru(){
        System.out.println("Rozpoczynam przewóz towaru");

        zamknijDrzwi();
        uruchomChłodzenie();

        for (int i = 0; i<5; i++){
            System.out.println("Przewożę towar");

            ustawTemperature( temperatura - 2);

        }
        wyłączChłodzenie();
        zamknijDrzwi();

        System.out.println("Zakończono transport towaru");
    }

    public boolean isCzyDrzwiOtwarte() {
        return czyDrzwiOtwarte;
    }

    public int getTemperatura() {
        return temperatura;
    }


    @Override
    public void podłączonoDoSieci() {

    }
}
