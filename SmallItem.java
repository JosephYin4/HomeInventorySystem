import java.util.Scanner;

public class SmallItem extends Item{
    private String WhereToFindIt;


    // default constructor
    // if we define a default constructor for the child
    // we have to remember to call the parent constructor as well
    public SmallItem() {
        super(); // call the parent constructor
        String WhereToFindIt = "N/A";
    }

    // In a child class, the overloaded constructor
    // must also call the parent's class overload constructor
    public SmallItem(int ID, String Name, int Quantity, double PricePerItem, double EstimatedLifeSpan, String WhereToFindIt) {
        super(ID, Name, Quantity, PricePerItem, EstimatedLifeSpan);
        this.WhereToFindIt = WhereToFindIt;
    }
    public String getWhereToFindIt() {
        return WhereToFindIt;
    }
    public void setWhereToFindIt(String WhereToFindIt) {
        this.WhereToFindIt = WhereToFindIt;
    }

    @Override
    public String report() {
        return super.report() +
                "WhereToFindIt: " + WhereToFindIt + "\n";

    }

    @Override
    public void edit() {
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new location to find the small item:");
        String newWhereToFindIt = sc.nextLine();
        this.WhereToFindIt = newWhereToFindIt;
    }

}
