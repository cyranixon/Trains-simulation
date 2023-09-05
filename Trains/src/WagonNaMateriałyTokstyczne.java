public class WagonNaMateriałyTokstyczne extends WagonTowarowyCiężki implements  CechyWagonuNaMateriałyCiekłe{


    private boolean czyOtwarty;


    private int poziomToksyn;


    public WagonNaMateriałyTokstyczne(String systemHamulcowy, String zabezpieczenia) {
        super(systemHamulcowy,zabezpieczenia);
        this.poziomToksyn = 0;
        this.czyOtwarty = false;
    }

    public void otworzWagon(){
        this.czyOtwarty = true;
    }
    public void zamknijWagon(){
        this.czyOtwarty = false;
    }

    public void dodajToksycznosci(int ilość){
        if (this.czyOtwarty){
            this.poziomToksyn += ilość;
        }
    }
    public void odejmijToksyczności(int ilość) {
        if (this.czyOtwarty) {
            this.poziomToksyn -= ilość;
            if (this.poziomToksyn < 0) {
                this.poziomToksyn = 0;
            }
        }
    }


    public int getPoziomToksyn() {
        return poziomToksyn;
    }
    public boolean czyOtwarty(){
        return this.czyOtwarty;
    }

    @Override
    public void kuloodporny() {

    }
}
