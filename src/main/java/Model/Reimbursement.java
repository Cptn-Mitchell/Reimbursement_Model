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
    public enum reimbursementType{
        LODGING,
        TRAVEL,
        FOOD,
        OTHER,

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "Id=" + Id +
                ", author='" + author + '\'' +
                ", resolver=" + resolver +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
