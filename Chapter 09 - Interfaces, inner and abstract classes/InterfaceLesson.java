import java.util.*;

public class InterfaceLesson {

    public static void main(String[] args) {
        Player stef = new Player("Stefanos", 100, 100, "Hammer");
        System.out.println(stef.toString());
        Savable spider = new Monster("Black Widow", 100, 100);
        System.out.println(spider.toString());

        List stefValues = stef.saveToList();
        stef.updateFromList(stefValues);

        List spiderValues = stef.saveToList();
        stef.updateFromList(spiderValues);

        Monster.Hit monsterWounds = spider.new Hit(5);
        System.out.println(monsterWounds.getWounds());
        monsterWounds.setWounds(10);
        System.out.println(spider.toString());


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        scanner.close();
        return values;
    }

}

interface Saveable {

    List<String> saveToList();
    void updateFromList(List<String> values);

}

class Player implements Saveable {

    protected String name;
    protected int hitPoints;
    protected int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength, String weapon) {
        this(name, hitPoints, strength);
        this.weapon = weapon;
    }

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> saveToList() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        values.add(3, "" + this.weapon);
        return values;
    }

    @Override
    public void updateFromList(List<String> values) {
        if (values != null && values.size() > 0) {
            this.name = values.get(0);
            this.hitPoints = Integer.parseInt(values.get(1));
            this.strength = Integer.parseInt(values.get(2));
            this.weapon = values.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

}

class Monster extends Player {

    public Monster(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    class Hit {

        private int wounds;

        public Hit(int wounds) {
            this.wounds = wounds;
            hitPoints -= wounds;
        }

        public int getWounds() {
            return this.wounds;
        }

        public void setWounds(int wounds) {
            this.wounds += wounds;
            hitPoints -= wounds;
        }

    }

}
