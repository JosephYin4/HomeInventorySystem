import java.util.ArrayList;
import java.util.Scanner;

public class BigItem extends Item{
    private double Weight;//in kg
    private double Size;//in cubic meters

    // we have to remember to call the parent constructor as well
    public BigItem() {
        super(); // call the parent constructor
        Weight = 0;
        Size = 0;
    }

    // In a child class, the overloaded constructor
    // must also call the parent's class overload constructor
    public BigItem(int ID, String Name, int Quantity, double PricePerItem, double EstimatedLifeSpan, double Weight, double Size) {
        super(ID, Name, Quantity, PricePerItem, EstimatedLifeSpan);
        this.Weight = Weight;
        this.Size = Size;
    }
    public double getWeight() {
        return Weight;
    }
    public void setWeight(double Weight) {
        this.Weight = Weight;
    }
    public double getSize() {
        return Size;
    }
    public void setSize(double Size) {
        this.Size = Size;
    }


    @Override
    public String report() {
        return super.report() +
                "Weight(in kg): " + Weight + "\n"  +
                "Size(in cubic meters): " + Size + "kg\n";
    }

    @Override
    public void edit() {
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new Weight in kg:");
        double newWeight = sc.nextDouble();
        this.Weight = newWeight;

        System.out.println("Enter the new Size in cubic meters: ");
        double newSize = sc.nextDouble();
        this.Size = newSize;

    }

}
