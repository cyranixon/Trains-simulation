public class WagonBagażowoPocztowy extends Wagon implements PodlaczenieDoSieci {


    private int liczbaBagaży;

    private int liczbaPrzeysłek;


    public WagonBagażowoPocztowy( int liczbaBagaży, int licczbaPrzeysłek) {
        super();
        this.liczbaBagaży = liczbaBagaży;
        this.liczbaPrzeysłek = licczbaPrzeysłek;
    }




    public void załadowanieBagażem(){
        if (liczbaBagaży>100){
            System.out.println("Za duzo bagaży!");
        }else{
            System.out.println("Załadowano wagon Bagażem");
        }
    }

    public void załadowaniePrzesyłkami(){
        if (liczbaPrzeysłek>80){
            System.out.println("Za dużo Przesyłek!");
        }else{
            System.out.println("Załadowano Wagon Przesyłkami");
        }
    }

    public int getLiczbaBagaży() {
        return liczbaBagaży;
    }

    public int getLiczbaPrzeysłek() {
        return liczbaPrzeysłek;
    }

    public void setLiczbaBagaży(int liczbaBagaży) {
        this.liczbaBagaży = liczbaBagaży;
    }

    public void setLiczbaPrzeysłek(int liczbaPrzeysłek) {
        this.liczbaPrzeysłek = liczbaPrzeysłek;
    }




    @Override
    public String toString() {
        return "WagonBagażowoPocztowy{" +
                "liczbaBagaży=" + liczbaBagaży +
                ", liczbaPrzeysłek=" + liczbaPrzeysłek +
                '}';
    }

    @Override
    public void podłączonoDoSieci() {

    }
}
