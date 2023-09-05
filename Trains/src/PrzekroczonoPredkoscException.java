public class PrzekroczonoPredkoscException extends  Exception{
    public PrzekroczonoPredkoscException(String message) {
        super("Przekroczono limit predkosci"+ message);
    }
}
