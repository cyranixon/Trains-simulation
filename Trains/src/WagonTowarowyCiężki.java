public class WagonTowarowyCiężki extends Wagon {


    private String systemHamulcowy;


    private String zabezpieczenia;

    public WagonTowarowyCiężki( String systemHamulcowy, String zabezpieczenia) {
        super();
        this.systemHamulcowy = systemHamulcowy;
        this.zabezpieczenia = zabezpieczenia;
    }



    public void wyswietlCechyHamulców() {
        if (systemHamulcowy.equals("elektryczny")) {
            System.out.println("Hamulce elektryczne");
        } else if (systemHamulcowy.equals("pneumatyczne")) {
            System.out.println("Hamulce pneumatyczne");
        } else {
            System.out.println("Nieznany typ hamulca");
        }
    }
    public void sprawdzZabezpieczenia(){
        if (zabezpieczenia.equals("alarm przeciwpożarowy")){
            System.out.println("Wagon spełnia warunki minimalnych zabezpieczeń");
        }else if (zabezpieczenia.equals("alarm niepsrawności podwozia")){
            System.out.println("Wagon spełnia minimalne warunki zabezpieczen");

        }else System.out.println("Wagon nie spełnia minimalnych warunków zabezpieczeń");
    }

    public String getSystemHamulcowy() {
        return systemHamulcowy;
    }

    public String getZabezpieczenia() {
        return zabezpieczenia;
    }
}
