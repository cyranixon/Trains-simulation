public class WagonNaMateriałyGazowe extends  WagonTowarowyPodstawowy{

    private int pojemnośćZbiornika;
    private  int ilośćGazu;

    public WagonNaMateriałyGazowe() {
        super();
        this.pojemnośćZbiornika = 100;
        this.ilośćGazu = random.nextInt(20,200);
    }

    public void dodajGaz(){
        if(ilośćGazu>pojemnośćZbiornika){
            System.out.println("Wagon nie zmiesci tyle gazu");
        }else if (ilośćGazu <= pojemnośćZbiornika){
            System.out.println("Pomyślnie załadowano wagon");
        }
    }

    public void usunGaz(){
        if (pojemnośćZbiornika - ilośćGazu >=0){
            pojemnośćZbiornika -= ilośćGazu;
        }else {
            System.out.println("Wagon jest pusty");
        }
    }


    public int getPojemnośćZbiornika() {
        return pojemnośćZbiornika;
    }

    public int getIlośćGazu() {
        return ilośćGazu;
    }
}
