public class Burger {

    public String name = "Plain Burger";
    private String breadRoll;
    private String meat;
    private double price = 3.99d;
    private String nameAddition1;
    private double priceAddition1;
    private String nameAddition2;
    private double priceAddition2;
    private String nameAddition3;
    private double priceAddition3;
    private String nameAddition4;
    private double priceAddition4;

    public Burger(String breadRoll, String meat) {
        this.breadRoll = breadRoll;
        this.meat = meat;
    }

    public void getBurgerInfo() {
        System.out.println("\nNew burger order:\n- " + name + " ($" + String.format("%.2f", price) + ")\n    * Meat: " + this.meat + "\n    * Bread roll: " + this.breadRoll);
    }

    public double getPrice() {
        return price;
    }

    public String getBreadRoll() {
        return breadRoll;
    }

    public String getMeat() {
        return meat;
    }

    public void setAddition1(String nameAddition1, double priceAddition1) {
        this.nameAddition1 = nameAddition1;
        this.priceAddition1 = priceAddition1;
        System.out.println("- " + nameAddition1 + " added ($" + String.format("%.2f", priceAddition1) + ")");
    }

    public void setAddition2(String nameAddition2, double priceAddition2) {
        this.nameAddition2 = nameAddition2;
        this.priceAddition2 = priceAddition2;
        System.out.println("- " + nameAddition2 + " added ($" + String.format("%.2f", priceAddition2) + ")");
    }

    public void setAddition3(String nameAddition3, double priceAddition3) {
        this.nameAddition3 = nameAddition3;
        this.priceAddition3 = priceAddition3;
        System.out.println("- " + nameAddition3 + " added ($" + String.format("%.2f", priceAddition3) + ")");
    }

    public void setAddition4(String nameAddition4, double priceAddition4) {
        this.nameAddition4 = nameAddition4;
        this.priceAddition4 = priceAddition4;
        System.out.println("- " + nameAddition4 + " added ($" + String.format("%.2f", priceAddition4) + ")");
    }

    public void confirmation() {
        System.out.println("Confirmation...\nYou have selected the following:\n");
        System.out.println("- " + name + " with " + this.breadRoll + " and " + this.meat + " | $" + this.price);
        whatAdditions();
    }

    public void whatAdditions() {
        if (priceAddition1 != 0) { System.out.println("- " + this.nameAddition1 + " | $" + String.format("%.2f", priceAddition1)); }
        if (priceAddition2 != 0) { System.out.println("- " + this.nameAddition2 + " | $" + String.format("%.2f", priceAddition2)); }
        if (priceAddition3 != 0) { System.out.println("- " + this.nameAddition3 + " | $" + String.format("%.2f", priceAddition3)); }
        if (priceAddition4 != 0) { System.out.println("- " + this.nameAddition4 + " | $" + String.format("%.2f", priceAddition4)); }
    }

    public void finalPrice() {
        price += priceAddition1 + priceAddition2 + priceAddition3 + priceAddition4;
        System.out.println("The total price is $" + String.format("%.2f", price) + ".");
    }

    public double getFinalPrice() {
        return price += priceAddition1 + priceAddition2 + priceAddition3 + priceAddition4;
    }

}

class bigBurger extends Burger {

    public String name = "Big Burger";
    private String nameAddition5;
    private double priceAddition5;
    private String nameAddition6;
    private double priceAddition6;

    public bigBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
    }

    public void setAddition5(String nameAddition5, double priceAddition5) {
        this.nameAddition5 = nameAddition5;
        this.priceAddition5 = priceAddition5;
        System.out.println("- " + nameAddition5 + " added ($" + String.format("%.2f", priceAddition5) + ")");
    }

    public void setAddition6(String nameAddition6, double priceAddition6) {
        this.nameAddition6 = nameAddition6;
        this.priceAddition6 = priceAddition6;
        System.out.println("- " + nameAddition6 + " added ($" + String.format("%.2f", priceAddition6) + ")");
    }

    @Override
    public void getBurgerInfo() {
        System.out.println("\nNew burger order:\n- " + name + " ($" + String.format("%.2f", super.getPrice()) + ")\n    * Meat: " + super.getMeat() + "\n    * Bread roll: " + super.getBreadRoll());
    }

    @Override
    public void confirmation() {
        System.out.println("Confirmation...\nYou have selected the following:\n");
        System.out.println("- " + name + " with " + super.getBreadRoll() + " and " + super.getMeat() + " | $" + super.getPrice());
        whatAdditions();
    }

    @Override
    public void whatAdditions() {
        super.whatAdditions();
        if (priceAddition5 != 0) { System.out.println("- " + this.nameAddition5 + " | $" + String.format("%.2f", priceAddition5)); }
        if (priceAddition6 != 0) { System.out.println("- " + this.nameAddition6 + " | $" + String.format("%.2f", priceAddition6)); }
    }

    @Override
    public void finalPrice() {
        double price = getFinalPrice();
        price += priceAddition5 + priceAddition6;
        System.out.println("The total price is $" + String.format("%.2f", price) + ".");
    }
}
class deluxeBurger extends Burger {

    public String name = "Deluxe Burger";
    public double price = 7.5d;

    public deluxeBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
    }

    @Override
    public void getBurgerInfo() {
        System.out.println("\nNew burger order:\n- " + name + " ($" + String.format("%.2f", price) + ")\n    * Meat: " + super.getMeat() + "\n    * Bread roll: " + super.getBreadRoll() + "\n    * Bacon\n    * Cheese\n    * Fries\n    * Soft drink");
    }

    @Override
    public void confirmation() {
        System.out.println("Confirmation...\nYou have selected the following:\n");
        System.out.println("- " + name + " with " + super.getBreadRoll() + " and " + super.getMeat() + " | $" + String.format("%.2f", price) + "\n- Bacon\n- Cheese\n- Fries\n- Soft drink");
        whatAdditions();
    }

    @Override
    public void finalPrice() {
        System.out.println("The total price is $" + String.format("%.2f", price) + ".");
    }

}
/*
        UNIT TESTING IN MAIN:

        //burger selection:
        Burger basicBurger = new Burger("sesame buns","ham");
        basicBurger.getBurgerInfo();
        //ingredients selection:
        basicBurger.setAddition1("Cheese",1d);
        basicBurger.setAddition2("Tomato",0.2d);
        //display:
        System.out.println("");
        basicBurger.confirmation();
        System.out.println("");
        basicBurger.finalPrice();
        System.out.println("");

        bigBurger bigBurger = new bigBurger("brown-rye buns","ham");
        bigBurger.getBurgerInfo();
        bigBurger.setAddition1("Onions", 0.25d);
        bigBurger.setAddition2("Cheese",1d);
        bigBurger.setAddition3("Tomato",0.2d);
        bigBurger.setAddition4("Sauce",0.1d);
        bigBurger.setAddition5("Lettuce",0.2d);
        bigBurger.setAddition6("Bacon",0.80d);
        System.out.println("");
        bigBurger.confirmation();
        System.out.println("");
        bigBurger.finalPrice();
        System.out.println("");

        deluxeBurger deluxeBurger = new deluxeBurger("beatroot buns","beef");
        deluxeBurger.getBurgerInfo();
        System.out.println("");
        deluxeBurger.confirmation();
        System.out.println("");
        deluxeBurger.finalPrice();
        System.out.println("");
*/
