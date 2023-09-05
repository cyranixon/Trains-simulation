import javax.swing.*;
import java.util.*;

public class Lokomowtywa implements Runnable{



    private int maksymalnaLiczbaWagonowElektrycznych;

    private String nazwa;

    private Stacja stacjaŹródłowa;

    private Stacja stacjaDocelowaTransportu;

    private Stacja stacjaNaKtorejJest = stacjaŹródłowa;

    private int i=0;

    private int id;
    private double predkosc;
    private int maxWagony;
    private int maxWaga;

    private  List<Wagon> wagony  = new ArrayList<>();

    private static List<Lokomowtywa> lokomotywy = new ArrayList<>();


    private List<Stacja> trasaPociagu = new ArrayList<>();

    private static int coutner = 0;

    private int doSieci = 0;

    private Random random;

    private int trasaMiedzyStacjami;

    private int trasaGlowna;

    private int dlugosTrasy = 0;


    public Lokomowtywa(int maksymalnaLiczbaWagonowElektrycznych, String nazwa, Stacja stacjaŹródłowa, Stacja stacjaDocelowaTransportu, int maxWagony, int maxWaga) {
        this.maksymalnaLiczbaWagonowElektrycznych = maksymalnaLiczbaWagonowElektrycznych;
        this.nazwa = nazwa;
        this.stacjaŹródłowa = stacjaŹródłowa;
        this.stacjaDocelowaTransportu = stacjaDocelowaTransportu;
        this.id = coutner++;
        this.predkosc = (int)(Math.random()*50+20);
        this.maxWagony = maxWagony;
        this.maxWaga = maxWaga;
        random = new Random();
    }


    public void dodajWagon(Wagon wagon) throws SkladPociaguException {
        if (wagony.size() == maxWagony) {
            throw new SkladPociaguException("Nie można dodać kolejnego wagonu. Osiągnięto maksymalną liczbę wagonów w składzie pociągu.");
        }
        if (wagon instanceof PodlaczenieDoSieci){
            if (doSieci == maksymalnaLiczbaWagonowElektrycznych)throw  new SkladPociaguException("Przekroczono maksymalna liczbe wagonow podlaczonych do sieci");
            doSieci++;
        }
        int aktualnaWaga = 0;
        for (Wagon w : wagony) {
            aktualnaWaga += w.getWagaBrutto();

        }
         if (aktualnaWaga+wagon.getWagaBrutto() > maxWaga ){
             throw new SkladPociaguException("Nie można dodać kolejnego wagonu. Osiągnięto maksymalny uciąg.");

         }
         wagony.add(wagon);
    }

    public void znajdzPolaczenie() {
        Queue<Stacja> queue = new LinkedList<>();
        List<Stacja> odwiedzone = new ArrayList<>();
        Map<Stacja, Integer> odleglosci = new HashMap<>();
        Map<Stacja, Stacja> poprzednie = new HashMap<>();

        Stacja start = stacjaŹródłowa;
        queue.add(start);
        odleglosci.put(start, 0);
        poprzednie.put(start, null);

        while (!queue.isEmpty()) {
            Stacja obecna = queue.remove();

            if (!odwiedzone.contains(obecna)) {
                odwiedzone.add(obecna);

                if (obecna == stacjaDocelowaTransportu) {
                    break;
                }

                Map<Stacja, Integer> polaczenia = obecna.getPolaczenia();
                for (Stacja sąsiadująca : polaczenia.keySet()) {
                    int odleglosc = polaczenia.get(sąsiadująca);
                    int nowaOdleglosc = odleglosci.get(obecna) + odleglosc;

                    if (!odleglosci.containsKey(sąsiadująca) || nowaOdleglosc < odleglosci.get(sąsiadująca)) {
                        odleglosci.put(sąsiadująca, nowaOdleglosc);
                        poprzednie.put(sąsiadująca, obecna);
                        queue.add(sąsiadująca);
                    }
                }

            }
        }

        Stacja obecna = stacjaDocelowaTransportu;
        List<Stacja> trasa = new ArrayList<>();
        while (obecna != null) {
            trasa.add(obecna);
            obecna = poprzednie.get(obecna);
        }

        if (!odwiedzone.contains(stacjaDocelowaTransportu)) {
            System.out.println("Nie znaleziono połączenia między stacjami.");
            return;
        }

        System.out.print("Trasa: ");
        for (int i = trasa.size() - 1; i >= 0; i--) {
            System.out.print(trasa.get(i).getNazwa() + " ");
            trasaPociagu.add(trasa.get(i));
        }
        System.out.println();

        for (int j = 0; j < trasaPociagu.size() - 1; j++) {
            Integer dlugoscPolaczenia = trasaPociagu.get(j).getPolaczenia().get(trasaPociagu.get(j+1));
            if (dlugoscPolaczenia != null) {
                dlugosTrasy += dlugoscPolaczenia;
            }
        }
        System.out.println("Długość trasy: " + dlugosTrasy);
        System.out.println();

    }

    public static Lokomowtywa wybierzLokomotywe(){
        for (int i=0; i<lokomotywy.size();i++){
            System.out.println(i+" "+ lokomotywy.get(i).nazwa);
        }
        Scanner s= new Scanner(System.in);
        System.out.println("Podaj numer lokomotywy ktora chcesz wybrac");
        int numer = s.nextInt();
        return lokomotywy.get(numer);
    }



//    Stacja obecna = stacjaDocelowaTransportu; // INNA WERSJA/odwrocone stacje
//        while (obecna != null) {
//        System.out.println("Odwiedzona stacja: " + obecna.getNazwa());
//        obecna =poprzednie.get(obecna);
//    }
//        if (!odwiedzone.contains(stacjaDocelowaTransportu)) {
//        System.out.println("Nie znaleziono połączenia między stacjami.");
//        return;
//    }
//
//    dlugosTrasy = odleglosci.get(stacjaDocelowaTransportu);
//        System.out.println("Długość trasy: " + dlugosTrasy);


    public void jedz() throws PrzekroczonoPredkoscException {
        znajdzPolaczenie();
            while (!Thread.interrupted()) {
                trasaMiedzyStacjami = 0;
                trasaGlowna = 0;
                for (i = 0; i < trasaPociagu.size() - 1; i++) {
                    stacjaNaKtorejJest = trasaPociagu.get(i);
                    if (!trasaPociagu.get(i + 1).equals(null)) {
                        while (trasaMiedzyStacjami < stacjaNaKtorejJest.getPolaczenia().get(trasaPociagu.get(i + 1))) {
                            System.out.println("Jebie cie na suke, skurwysynie");
                            zmianaPredkosci();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            trasaMiedzyStacjami += predkosc;
                            trasaGlowna += predkosc;
                        }
                        raport();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        trasaMiedzyStacjami = 0;
                    }
                    nowaTrasa();
                    trasaGlowna = 0;
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    znajdzPolaczenie();
                }
            }
    }

    public Stacja nowaTrasa(){
        stacjaŹródłowa = stacjaDocelowaTransportu;
        trasaPociagu.clear();
        return stacjaDocelowaTransportu = Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size()));
    }

    public void zmianaPredkosci() throws PrzekroczonoPredkoscException {

        int rand =(int) (Math.random()*2);

        if (predkosc>200)throw new PrzekroczonoPredkoscException(toString());

        if (this.predkosc>1 ){

            if (rand == 1){
                this.predkosc+=predkosc*0.03;
            }else {
                this.predkosc -= predkosc*0.03;
            }
        }else {
            this.predkosc+=10;
        }
    }

    public  void raport(){

        System.out.println("Nazwa: "+ nazwa + " Podlaczone wagony: "+ wagony +" ilość wagonów: "+wagony.size());
//        System.out.println("Procent przejechanej trasy: "+ (double)trasaGlowna/dlugosTrasy);
//        System.out.println("Procent ukończonej drogi miedzy stacjami: "+ (trasaMiedzyStacjami/stacjaNaKtorejJest.getPolaczenia().get(trasaPociagu.get(i+1))));
    }


    public String getNazwa() {
        return nazwa;
    }


    public double getPredkosc() {
        return predkosc;
    }

    public int getMaksymalnaLiczbaWagonowElektrycznych() {
        return maksymalnaLiczbaWagonowElektrycznych;
    }


    public int getId() {
        return id;
    }

    public static List<Lokomowtywa> getLokomotywy() {
        return lokomotywy;
    }

    public List<Wagon> getWagony() {
        return wagony;
    }

    public int getMaxWagony() {
        return maxWagony;
    }


    public Stacja getStacjaŹródłowa() {
        return stacjaŹródłowa;
    }

    public Stacja getStacjaDocelowaTransportu() {
        return stacjaDocelowaTransportu;
    }

    public int getMaxWaga() {return maxWaga;}


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                zmianaPredkosci();
                Thread.sleep(1000); // czekaj 1 sekundę
            } catch (InterruptedException | PrzekroczonoPredkoscException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Lokomotywa " + nazwa;
    }


}

