import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public class Menu {




    public static void main(String[] args) {

        List<String> nazwylokomotyw = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"));


        generwoanie100stacji();


        try {
        for (int i = 0; i < 25; i++) {
            int liczbaWagonow = (int) (Math.random() * 6) + 5;
            Lokomowtywa lokomowtywa = new Lokomowtywa(20,  nazwylokomotyw.get(i), Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), liczbaWagonow,100000);
            System.out.println(lokomowtywa);
            for (int j = 0; j < liczbaWagonow; j++) {
                int losowyWagon = (int)(Math.random()*11);
                switch (losowyWagon) {
                    case 0:
                        Wagon w = new WagonBagażowoPocztowy(50, 10);
                        lokomowtywa.dodajWagon(w);
                        break;
                        case 1:
                        Wagon w1 = new WagonChłodniczy(true, 50);
                        lokomowtywa.dodajWagon(w1);
                        break;

                    case 2:
                        Wagon w2 = new WagonNaCiekłeMateriałyToksyczne("pneumatyczne", "alarm przeciwpożarowy", 100, true);
                        lokomowtywa.dodajWagon(w2);
                        break;
                    case 3:
                        Wagon w3 = new WagonNaMateriałyCiekłe();
                        lokomowtywa.dodajWagon(w3);
                        break;
                    case 4:
                        Wagon w4 = new WagonNaMateriałyGazowe();
                        lokomowtywa.dodajWagon(w4);
                        break;
                    case 5:
                        Wagon w5 = new WagonNaMateriałyTokstyczne("elektryczny", "alarm niesprawności podwozia");
                        lokomowtywa.dodajWagon(w5);
                        break;
                    case 6:
                        Wagon w6 = new WagonNaMateriałyWybuchowe("pneumatyczne", "alarm przeciwpożarowy");
                        lokomowtywa.dodajWagon(w6);
                        break;
                    case 7:
                        Wagon w7 = new WagonPasażerski();
                        lokomowtywa.dodajWagon(w7);
                        break;
                    case 8:
                        Wagon w8 = new WagonPocztowy();
                        lokomowtywa.dodajWagon(w8);
                        break;
                    case 9:
                        Wagon w9 = new WagonRestaturacyjny();
                        lokomowtywa.dodajWagon(w9);
                        break;
                    case 10:
                        Wagon w10 = new WagonTowarowyCiężki("pneumatyczne", "alarm");
                        lokomowtywa.dodajWagon(w10);
                        break;
                    case 11:
                        Wagon w11 = new WagonTowarowyPodstawowy();
                        lokomowtywa.dodajWagon(w11);
                        break;
                }
            }
            System.out.println(lokomowtywa);
            Lokomowtywa.getLokomotywy().add(lokomowtywa);

        }
    } catch (SkladPociaguException e) {
            System.out.println(e);
        }

        menu();
    }
    public static void menu(){
        Scanner s =new Scanner(System.in);
        while (true){
            System.out.println("Wybierz co chcesz zrobić: ");
            System.out.println("1 - Utwórz lokomotywe");
            System.out.println("2 - wyrusz w trase");
            System.out.println("3 - wyswietl raport podróży");
            System.out.println("4 - zapisz do pliku");

            int operacja = s.nextInt();

            switch (operacja){
                case 1:
                    System.out.println("Podaj maksymalna liczbe wagonow elektrycznych: ");
                    int maksymalanaliczbaelektrycznych = s.nextInt();
                    System.out.println("Podaj nazwe lokomotywy: ");
                    String nazwaLokomotywy = s.next();
                    Lokomowtywa lok = new Lokomowtywa(maksymalanaliczbaelektrycznych,  nazwaLokomotywy, Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size())), 10,100000);
                    Lokomowtywa.getLokomotywy().add(lok);
                    System.out.println(lok);
                    break;
                case 2:
                    for (int i = 0; i<Lokomowtywa.getLokomotywy().size();i++) {
                        Thread thread = new Thread(Lokomowtywa.getLokomotywy().get(0));
                        thread.start();
                        System.out.println("Pociag jedzie");
                    }
                    break;
                case 3:
                    Lokomowtywa l = Lokomowtywa.wybierzLokomotywe();
                    l.raport();
                    break;
                case 4:
                    Thread t1 = new Thread(() -> {
                        while (!Thread.interrupted()){
                            try {
                                zapisdoPlikuAppState();
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    t1.start();
                    break;
            }
        }
    }

    public static void zapisdoPlikuAppState()throws FileNotFoundException, InterruptedException {
        Thread.sleep(5000);
        File app = new File("C:\\Users\\smurf\\OneDrive\\Pulpit\\PPJ_CW\\PROJEKT GUI\\src\\AppState.txt");
        PrintWriter pt = new PrintWriter(app);
        pt.println(Lokomowtywa.getLokomotywy());
        pt.close();
    }
    public static void generwoanie100stacji(){
        for (int i = 0; i < 100; i++) {
            Stacja stacja = new Stacja("Stacja" + i);
            stacja.dodajDoListyStacji(stacja);
            for (int j = 0; j< 10; j++) {
                if (!Stacja.getListaStacji().isEmpty()) {
                    Stacja st = Stacja.getListaStacji().get((int) (Math.random() * Stacja.getListaStacji().size()));
                    if (!stacja.getPolaczenia().keySet().contains(st))
                        stacja.dodajPolaczenie(st);
                }
            }
            System.out.println(stacja);
        }
    }

}



