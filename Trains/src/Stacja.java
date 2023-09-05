import java.util.*;


public class Stacja {


    private Map<Stacja, Integer> polaczenia=new HashMap<>();


    private String nazwa;

    private static List<Stacja> listaStacji = new ArrayList<>();

    public Stacja(String nazwa) {
        this.nazwa = nazwa;
        listaStacji.add(this);
    }


    public void dodajDoListyStacji(Stacja stacja) {
        listaStacji.add(stacja);
    }

    public void dodajPolaczenie(Stacja stacja) {
        if (!polaczenia.keySet().contains(stacja)) {
            polaczenia.put(stacja, (int) (Math.random() * 300) + 100);
            stacja.dodajPolaczenie(this);
        }
    }


    public Map<Stacja, Integer> getPolaczenia() {
        return polaczenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public static List<Stacja> getListaStacji() {
        return listaStacji;
    }

    @Override
    public String toString() {
        return "Stacja "+nazwa;
    }
}


