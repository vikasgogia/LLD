package entities;

import java.util.HashMap;

public class User {

    private static int counter = 0;
    private int id;
    private String name;
    // total amount that user owes or gets back
    // -ve -> gets back, +ve -> owes to another user
    private double totalExpenses;
    // amount tracking as per friends/ users
    private HashMap<Integer, Double> expenseSheet;

    public User(String name) {
        this.name = name;
        this.id = counter++;
        this.totalExpenses = 0;
        this.expenseSheet = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void printTotalExpenses() {
        if(totalExpenses > 0) {
            System.out.println(this.name + " owes a total of " + totalExpenses);
        }
        else {
            System.out.println(this.name + " gets back a total of " + totalExpenses);
        }
    }

    public void addToExpenseSheet(User user, double amount) {
        if(user.getId() == id) {
            return;
        }
        if(expenseSheet.containsKey(user.getId())) {
            expenseSheet.put(user.getId(), expenseSheet.get(user.getId()) + amount);
        }
        else expenseSheet.put(user.getId(), amount);
    }
}
