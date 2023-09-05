import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Presentation {
    public static void main(String[] args) throws PrzekroczonoPredkoscException {

        System.out.println("INFORMACJE O TRASIE: ");
        generwoanie100stacji();
        Lokomowtywa lok = new Lokomowtywa(20,  "1", Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), 10,100000);
        lok.znajdzPolaczenie();
        System.out.println("========================");
        System.out.println("STACJA DOCELOWA: ");
        System.out.println(lok.getStacjaDocelowaTransportu());
        System.out.println("========================");
        System.out.println("RAPORT POCIAGU");
        lok.jedz();
        lok.raport();

        WagonRestaturacyjny wagon1 = new WagonRestaturacyjny();
        wagon1.pokazMenu();// pokazuje menu dań dla wagonu
        wagon1.zamówDanie();// użytkownik wybiera danie z list
        wagon1.wyswietlZamówienie();// ta metoda wyswietla zamowienie

        WagonChłodniczy w2 = new WagonChłodniczy(true, 10);
        w2.ustawTemperature(20);//ustawianie temperatury w awagonie
        w2.monitorowanieTemperatury();// monitorowanie stanu temperatury i wsywietlanie odpowiednich komunikatow
        w2.wyłączChłodzenie();// wlacza chlodzenie(true)
        w2.wyłączChłodzenie();//wylacza chlodzenie(false)
        w2.transportTowaru();//roczpoczyna transport towaru

        WagonNaCiekłeMateriałyToksyczne w3 = new WagonNaCiekłeMateriałyToksyczne("pneumatyczne", "alarm przeciwpozarowy", 50, true );
        w3.sprawdźWagon();//sprawdza czy wagon jest gotowy do drogi
        w3.rozładunekWagonu();// roladunek wagonu z pobraniem od uzytkownika co chce rozladowac

        WagonBagażowoPocztowy w4 = new WagonBagażowoPocztowy(30,40);
        w4.załadowanieBagażem();//zaludnek bagazem w zaleznosci ile bagazy chce sie zaladowac
        w4.załadowaniePrzesyłkami();//zaladunek przesylkami w zaleznosci ile ich jest

        WagonNaMateriałyGazowe w5 = new WagonNaMateriałyGazowe();
        w5.dodajGaz();//dodaje wylosowana liczbe gazu
        w5.usunGaz();//usuwa gaz

        WagonNaMateriałyCiekłe w6 = new WagonNaMateriałyCiekłe();
        w6.zJakiegoMateriałuJestZbiornik();//uzytkownik wybiera material dla zbiornika
        w6.sprawdzBezpieczeństwoWagonu();//sprawdza czy wagon moze wyjechac w podroz
        w6.jestWentylBezpieczeństwa();//dodaje wentyl bezp
        w6.nieMaWentylBezpieczeństwa();//usuwa wentyl bezp
        w6.jestOdpornoścNaRdzewie();// ustala odpornosc na rdzewienie
        w6.nieMaOdpornoścNaRdzewienie();//ustala brak odpornosci na rdzewienie

        WagonPasażerski w7= new WagonPasażerski();
        w7.czyJestMiejsce();//sprawdza czy jest miejsce w wagonie
        w7.wybierzKlasęWagonu();//uzytkownik wybiera klase wagonu w ktorym jedzie


        WagonNaMateriałyWybuchowe w8 = new WagonNaMateriałyWybuchowe("elektryczne", "alarm niesprawności podwozia");
        w8.kontrolaWagonu();//sprawdza stan wagonu przed wyruszeniem w trase
        w8.naprawaWagonu();//naprawia wagon jesli jest uszkodzony

        WagonTowarowyPodstawowy w9 = new WagonTowarowyPodstawowy();
        w9.otworzDrzwi();//otwiera drzwi
        w9.zamknijDrzwi();//zamyka drzwi
        w9.wejściePersonelu();//wpuszcza  personel w zleznosci ile jest osob
        w9.wybierzRodzajŁadunku();//użytkownik wybiera z list czym chce zaladowac wagon

        WagonTowarowyCiężki w10 = new WagonTowarowyCiężki("elektryczny", "alarm przeciwpożarowy");
        w10.wyswietlCechyHamulców();//wysiwtla cechy hamulcow
        w10.sprawdzZabezpieczenia();// sprawdza czy wagon jest zabezpieczony

        WagonNaMateriałyTokstyczne w11 = new WagonNaMateriałyTokstyczne("pneumatyczne", "alarm przeciwpożarowy");
        w11.otworzWagon();//otwiera drzwi(true)
        w11.zamknijWagon();//zamyka drzwi(false)
        w11.dodajToksycznosci(20);//dodaje ilosc toksyn podana w konstruktorze
        w11.odejmijToksyczności(10);//odejmuje ilosc toksyn podana w konstruktorze

        WagonPocztowy w12 = new WagonPocztowy();
        w12.zajety();//ustala ze wagon jest zajety
        w12.wolny();//ustala ze wagon jest wolny
        w12.nadajPaczki();//nadaje losowa ilosc paczek i sprawdza czy nie jest ich za duzo
        w12.nadajListy();// nadaje losowa ilosc listow i sprawdza czy nie jest ich za duzo
    }


    public static void generwoanie100stacji() {
        for (int i = 0; i < 100; i++) {
            Stacja stacja = new Stacja("Stacja" + i);
            for (int j = 0; j < 10; j++) {
                if (!Stacja.getListaStacji().isEmpty()) {
                    Stacja st = Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size()));
                    if (!stacja.getPolaczenia().keySet().contains(st))
                        stacja.dodajPolaczenie(st);
                }
            }
        }
    }



}
