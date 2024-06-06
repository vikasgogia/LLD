package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyTransfer {
    // <userId, user>
    private HashMap<Integer, User> users;

    public MoneyTransfer() {
        this.users = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public boolean addExpense(Expense expense) {
        if(!checkIfUsersExist(expense.getGroupMembers())) return false;
        return calculateExpenses(expense);
    }

    public void printBalanceForUsers() {
        for(Map.Entry<Integer, User> entry: users.entrySet()) {
            User user = entry.getValue();
            user.printTotalExpenses();
        }
    }

    private boolean checkIfUsersExist(List<User> expenseGroupMembers) {
        for(User user: expenseGroupMembers) {
            if(!users.containsKey(user.getId())) return false;
        }
        return true;
    }

    private boolean calculateExpenses(Expense expense) {
        List<Double> amtPerHead;

        switch(expense.getSplit()) {
            case EQUAL -> {
                amtPerHead = equalDistribution(expense.getAmount(), expense.getGroupMembers().size());
                for(int i=0; i< expense.getGroupMembers().size(); i++) {
                    // add expense in the group members expense sheet
                    User user = expense.getGroupMembers().get(i);
                    user.addToExpenseSheet(expense.getPaidBy(), amtPerHead.get(i));

                    // add expense in the paidBy's expense sheet
                    expense.getPaidBy().addToExpenseSheet(user, (-1) * amtPerHead.get(i));
                }
                return true;
            }
            case EXACT -> {
                return exactDistribution(expense);
            }
            case PERCENT -> {
                return percentDistribution(expense);
            }
        }
        return false;
    }

    private boolean percentDistribution(Expense expense) {
        List<Double> amtPerHead = expense.getPercentDistribution();

        if(amtPerHead.size() != expense.getGroupMembers().size()) {
            System.out.println("Size is not equal");
            return false;
        }

        for(int i=0; i< expense.getGroupMembers().size(); i++) {
            double amount = (amtPerHead.get(i) * expense.getAmount()) / 100.0;
            amount = Math.floor((amount * 100.0) + 0.5) / 100.0;

            // add expense in the group members expense sheet
            User user = expense.getGroupMembers().get(i);
            user.addToExpenseSheet(expense.getPaidBy(), amount);

            // add expense in the paidBy's expense sheet
            expense.getPaidBy().addToExpenseSheet(user, (-1) * amount);
        }
        return true;
    }

    private boolean exactDistribution(Expense expense) {
        List<Double> amtPerHead = expense.getExactDistribution();

        if(amtPerHead.size() != expense.getGroupMembers().size()) {
            System.out.println("Size is not equal");
            return false;
        }

        for(int i=0; i< expense.getGroupMembers().size(); i++) {
            // add expense in the group members expense sheet
            User user = expense.getGroupMembers().get(i);
            user.addToExpenseSheet(expense.getPaidBy(), amtPerHead.get(i));

            // add expense in the paidBy's expense sheet
            expense.getPaidBy().addToExpenseSheet(user, (-1) * amtPerHead.get(i));
        }
        return true;
    }

    private List<Double> equalDistribution(double amount, int memberCount) {
        List<Double> parts = new ArrayList<>();
        for(int i=0; i< memberCount; i++) {
            parts.add(((100.0 * amount) / (memberCount - i)) / 100.0);
        }
        return parts;
    }
}
