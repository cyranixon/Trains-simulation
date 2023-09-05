public class WagonPocztowy extends Wagon implements PodlaczenieDoSieci{


    private int liczbaListów;

    private int liczbaPaczek;

    private boolean czyWolny;




    public WagonPocztowy() {
        super();
        this.liczbaListów = random.nextInt(50,200);
        this.liczbaPaczek = random.nextInt(50,100);
    }


    public void wolny(){
        czyWolny = true;
    }
    public void zajety(){
        czyWolny=false;
    }

    public void nadajPaczki(){
        if (liczbaPaczek > 100){
            zajety();
            System.out.println("Za dużo paczek do nadania");
        }else {
            wolny();
            System.out.println("Pomyślnie nadano paczki");
        }
    }

    public void nadajListy(){
        if (liczbaListów > 100){
            zajety();
            System.out.println("Za dużo listo do nadania");
        }else {
            wolny();
            System.out.println("Pomyślnie nadano paczki");
        }
    }




















    @Override
    public void podłączonoDoSieci() {

    }
}
