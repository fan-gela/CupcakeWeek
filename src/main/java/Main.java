import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

//        make into a loop?
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();

        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        cupcakeMenu.add(cupcake);

        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        cupcakeMenu.add(redVelvet);

        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
//        Drink water = new Drink();
//        Soda soda = new Soda();
//        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing.");
        input = new Scanner(System.in);

        String[] drinkTypes = {"water", "soda", "milk"};

        for (String drinkType : drinkTypes) {
            Drink drink = getDrinkByType(drinkType);
            System.out.println("We are deciding on the price for our " + drinkType + " drink. Here is the description:");
            drink.type();
            System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
            priceText = input.nextLine();
            drink.setPrice(price);
            drinkMenu.add(drink);
        }

        new Order(cupcakeMenu, drinkMenu);
    }

    private static Drink getDrinkByType(String drinkType) {
        if (drinkType.equals("water")) {
            return new Drink();
        } else if (drinkType.equals("soda")) {
            return new Soda();
        } else if (drinkType.equals("milk")) {
            return new Milk();
        }
        throw new IllegalArgumentException("Invalid drink type: " + drinkType);
    }


}

class Cupcake {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }

}

class RedVelvet extends Cupcake {
    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {
    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("This is a bottle of water.");
    }

}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of milk");
    }
}