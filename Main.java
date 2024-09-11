

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Item> inventory = new ArrayList<Item>();
    static ArrayList<Item> bigItemInventory = new ArrayList<Item>();
    static ArrayList<Item> smallItemInventory = new ArrayList<Item>();


    // display the menu and make sure the user enters between 1 and 6
    public static void main(String args[]) {


        while (true) {
            int choice = displayMenu();
            boolean keepRunning = processChoice(choice);
            if (keepRunning == false) {
                break;
            }
        }
    }

    public static int displayMenu() {
        while (true) {
            System.out.println("*** Welcome to Home Inventory System ***");
            System.out.println("Main Menu");
            System.out.println("1. Add a household item");
            System.out.println("2. List all household items");
            System.out.println("3. Edit a household item");
            System.out.println("4. Delete a household item");
            System.out.println("5. Show total cost of household items");
            System.out.println("6. Show estimated yearly cost of particular item");
            System.out.println("7. Quit");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice >= 1 && choice <= 6) {
                return choice;
            } else if (choice == 7) {
                return 0;
            } else {
                System.out.println("Invalid choice. Please choose between 1 to 7");
            }
        }
    }


    // depending on the user has entered at the menu, do something
    // if return true, keep running the program
    // if return false, quit the program
    public static boolean processChoice(int choice) {

        // We create an ArrayList that can store Item
        // (when we create a class, that class is also considered as a data type)
        //ArrayList<Item> inventory = new ArrayList<Item>();

        if (choice == 1) {
            addNewItem(inventory);
            return true;
        }
        if (choice == 2) {
            displayAllItems(inventory);
            return true;
        }
        if (choice == 3) {
            editItem(inventory);
            return true;
        }
        if (choice == 4) {
            deleteItem(inventory);
            return true;
        }
        if (choice == 5) {
            calculateTotalInventoryCost(inventory);
            return true;
        }
        if (choice == 6) {
            calculateEstimatedCostToReplaceItemYearly(inventory);
            return true;
        }
        if (choice == 0){
            return false;
        }
    return false; }


    public static void displayAllItems(ArrayList<Item> inventory) {
        System.out.println("<<Listing all inventory items>>");
        for (Item i : inventory) {
            System.out.println(i.report());
        }
    }


        public static void addNewItem (ArrayList<Item> inventory) {

            System.out.println("Add new item");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the type of item to create");
            System.out.println("B for big item or S for small item: ");
            String itemType = sc.nextLine();
            while (!itemType.toUpperCase().equals("B") && !itemType.toUpperCase().equals("S")) {
                System.out.println("Enter the type of item to create");
                System.out.println("B for big item or S for small item: ");
                itemType = sc.nextLine();
            }

            // ask the user to enter details for parent Item class
            System.out.println("What is the item ID?(Key from 001 to 999) ");
            int ID = sc.nextInt();
            System.out.println(ID);
            sc.nextLine();//get rid of the buffered \n
            System.out.print("Enter item name: ");
            String Name = sc.nextLine();
            System.out.print(Name);
            System.out.print("Enter quantity of same item(0 to 100): ");
            int Quantity = sc.nextInt();
            sc.nextLine(); // get rid of the buffered \n
            System.out.print(Quantity);
            System.out.print("Enter price per item in dollars: ");
            double PricePerItem = sc.nextDouble();
            System.out.print(PricePerItem);
            System.out.print("Enter estimated lifespan of item in years: ");
            double EstimatedLifeSpan = sc.nextDouble();
            System.out.print(EstimatedLifeSpan);
            sc.nextLine();//get rid of the buffered \n

            // create a placeholder and set it to empty
            Item newItem = null;

            if (itemType.toUpperCase().equals("B")) {
                // ask the user for information pertaining to the big item
                System.out.print("Enter the item weight in kg: ");
                double Weight = sc.nextDouble();
                System.out.println("Enter the item size in cubic meters: ");
                double Size = sc.nextDouble();

                // the `newItem` is the placeholder that we have created before the `if`
                newItem = new BigItem(ID, Name, Quantity, PricePerItem, EstimatedLifeSpan, Weight, Size);
            } else if (itemType.toUpperCase().equals("S")) {
                // ask the user for the information needed to create a small item
                System.out.print("Enter the location to find the small item: ");

                String WhereToFindIt = sc.nextLine();

                newItem = new SmallItem(ID, Name, Quantity, PricePerItem, EstimatedLifeSpan, WhereToFindIt);
            }
            inventory.add(newItem);

        }


    public static void editItem(ArrayList<Item> inventory) {

        // 1. ask the user to select which item to edit
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to edit: ");
        int ItemIndex = sc.nextInt();

        // 2. base on the item, we will ask the questions for
        // the new values for the item
        Item ItemToEdit = inventory.get(ItemIndex);
        ItemToEdit.edit();
        System.out.println("Item edited successfully");

    }

    public static void deleteItem(ArrayList<Item> inventory) {

        // 1. ask the user to select which item to edit
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to delete: ");
        int ItemIndex = sc.nextInt();

        // 2. base on the item, we will ask the questions for
        // the new values for the item
        inventory.remove(ItemIndex);
        System.out.println("Item removed successfully");
    }

    public static void calculateTotalInventoryCost(ArrayList<Item> inventory){
            double TotalInventoryCost = 0;
            for (int i = 0; i < inventory.size(); i++) {
            TotalInventoryCost = TotalInventoryCost + (inventory.get(i).getQuantity() * inventory.get(i).getPricePerItem());
        }   System.out.println("Total Inventory Cost is: $" + TotalInventoryCost);
    }

    public static void calculateEstimatedCostToReplaceItemYearly(ArrayList<Item> inventory){
            double EstimatedCostToReplaceItemYearly = 0;
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to calculate estimated yearly replacement cost: ");
        int ItemIndex = sc.nextInt();
        EstimatedCostToReplaceItemYearly = inventory.get(ItemIndex).getPricePerItem() / inventory.get(ItemIndex).getEstimatedLifeSpan();
        System.out.println("The estimated yearly replacement cost for this item is: $" + EstimatedCostToReplaceItemYearly);
    }
  }

