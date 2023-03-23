package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static int water = 400;
    public static int milk = 540;
    public static int coffee = 120;
    public static int cups = 9;
    public static int money = 550;
    public static boolean work = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (work) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buy(scanner);
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    work = false;
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }


    }
    public static void makeCoffee(int requiredWater, int requiredMilk, int requiredCoffee, int cost) {
        if (water < requiredWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < requiredMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee < requiredCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= requiredWater;
            milk -= requiredMilk;
            coffee -= requiredCoffee;
            cups -= 1;
            money += cost;
        }
    }

    public static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Unknown command!");
                break;
        }
    }
    public static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += scanner.nextInt();
    }
    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
