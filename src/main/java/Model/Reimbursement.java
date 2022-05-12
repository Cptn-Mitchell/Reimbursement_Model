package Model;

public class Reimbursement {
    int Id;
    String author;
    int resolver;
    String description;
    String type;
    String status;
    int amount;


    public enum Status{
        APPROVED,
        PENDING,
        DENIED,
    }
}
