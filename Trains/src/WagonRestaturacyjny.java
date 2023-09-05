import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WagonRestaturacyjny extends Wagon implements PodlaczenieDoSieci{


    private ArrayList<String> menu;
    private ArrayList<String> zamowienia;

    private Scanner s;


    public WagonRestaturacyjny() {
        super();
        this.s= new Scanner(System.in);
        this.zamowienia = new ArrayList<>();
        this.menu = new ArrayList<>();
        menu.add("zupa_pomidorowa");
        menu.add("zurek");
        menu.add("ramen");
        menu.add("hot-dog");
        menu.add("pizza");
        menu.add("szot");
    }



    public void pokazMenu(){
        System.out.println("menu: ");
        for (String danie : menu){
            System.out.println(" "+danie);
        }
    }



    public void zamówDanie(){
        System.out.println("Co chcesz zamówić?");
        String danie = s.nextLine();
        if (menu.contains(danie)){
            zamowienia.add(danie);
            System.out.println("Przyjęto zamówienie:"+ danie);
        }else {
            System.out.println("Niestety nie posidamy " +danie+ " w karcie");
        }
    }

    public void wyswietlZamówienie(){
        System.out.println("Zamówienia:");
        for (String danie : zamowienia){
            System.out.println("- "+ danie);
        }
    }
    public void zamknijSkladanieZamowien() {
        s.close();
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    public ArrayList<String> getZamowienia() {
        return zamowienia;
    }


    @Override
    public void podłączonoDoSieci() {

    }
}
