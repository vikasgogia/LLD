package entities;

import java.util.List;

public class Expense {

    private static int counter = 0;
    private int id;
    private String description;
    private Split split;
    private List<Double> percentDistribution, exactDistribution;
    private User paidBy;
    private double amount;
    private List<User> groupMembers;

    public Expense(String description, Split split, User paidBy, List<User> groupMembers, double amount) {
        this.description = description;
        this.split = split;
        this.paidBy = paidBy;
        this.groupMembers = groupMembers;
        this.id = counter++;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getPercentDistribution() {
        return percentDistribution;
    }

    public List<Double> getExactDistribution() {
        return exactDistribution;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public Split getSplit() {
        return split;
    }
}
