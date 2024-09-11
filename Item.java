import java.util.Scanner;

// Item class is public-access, meaning
// any other classes can use it
public abstract class Item {
        private int ID;
        private String Name;
        private int Quantity;
        private double PricePerItem;
        private double EstimatedLifeSpan;

    // when a item is created
    // set its id to 0, name to "N/A", quantity to 0, priceperitem to 0,
    // estimatedlifespan to

    public Item() {
    this.ID = 0;
    this.Name = "N/A";
    this.Quantity = 0;
    this.PricePerItem = 0;
    this.EstimatedLifeSpan = 0;
    }

    // overload constructors are different variants
    // of constructors
    public Item(int ID, String Name, int Quantity, double PricePerItem, double EstimatedLifeSpan){
    this.ID = ID;
    this.Name = Name;
    this.Quantity = Quantity;
    this.PricePerItem = PricePerItem;
    this.EstimatedLifeSpan = EstimatedLifeSpan;
    }

    // only populate the ID, name and quantity in the object
    public Item(int ID, String Name, int Quantity) {
    this.PricePerItem = 0; // explicitly state that we want 0 as the default value
    this.EstimatedLifeSpan = 0; // explicitly state that we want 0 as the default value
    }

    //getter and setter methods

    public int getID(){
    return ID;
    }

    public String getName(){
    return Name;
    }

    public int getQuantity(){
    return Quantity;
    }

    public double getPricePerItem(){
    return PricePerItem;
    }

    public double getEstimatedLifeSpan(){
    return EstimatedLifeSpan;
    }

    public void setID(int ID){
    this.ID = ID;
    }

    public void setName(String Name){
    this.Name = Name;
    }

    public void setQuantity(int Quantity){
    this.Quantity = Quantity;
    }

    public void setPricePerItem(double PricePerItem){
    this.PricePerItem = PricePerItem;
    }

    public void setEstimatedLifeSpan(double EstimatedLifeSpan) {
        this.EstimatedLifeSpan = EstimatedLifeSpan;
    }

    public String report() {
        return "Item ID: " + ID + "\n"
                + "Item Name: " + Name + "\n"
                + "Quantity: " + Quantity + "\n"
                + "Price Per Item: " + PricePerItem + "\n"
                + "Estimated Lifespan(in Years): " + EstimatedLifeSpan + "\n";
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new ID for the item");
        int newID = sc.nextInt();
        sc.nextLine(); // consume the buffered new line
        this.ID = newID;

        System.out.println("Enter the new Name for the item");
        String newName = sc.nextLine();
        this.Name = newName;

        System.out.println("Enter the new quantity per Item");
        int Quantity = sc.nextInt();
        this.Quantity = Quantity;

        System.out.println("Enter the new Price per Item");
        double PricePerItem = sc.nextDouble();
        this.PricePerItem = PricePerItem;

        System.out.println("Enter the new Estimated Lifespan");
        double EstimatedLifeSpan = sc.nextDouble();
        this.EstimatedLifeSpan = EstimatedLifeSpan;


    }
}