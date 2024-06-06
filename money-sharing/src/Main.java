import entities.Expense;
import entities.MoneyTransfer;
import entities.Split;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>() {
            {
                add(new User("vikas"));
                add(new User("sum"));
                add(new User("viju"));
                add(new User("him"));
            }
        };

        MoneyTransfer moneyTransfer = new MoneyTransfer();
        moneyTransfer.registerUser(users.get(0));
        moneyTransfer.registerUser(users.get(1));
        moneyTransfer.registerUser(users.get(2));
        moneyTransfer.registerUser(users.get(3));

        Expense expense1 = new Expense(
                "me and brother suitcase",
                Split.EQUAL,
                users.get(3),
                new ArrayList<>() {{ add(users.get(0)); add(users.get(3)); }},
                1400
        );

        Expense expense2 = new Expense(
                "family expenses",
                Split.PERCENT,
                users.get(2),
                users,
                14000
        );
        expense2.setPercentDistribution(new ArrayList<>() {{ add(10.0); add(35.0); add(35.0); add(20.0); }});

        moneyTransfer.addExpense(expense1);
        moneyTransfer.addExpense(expense2);
        moneyTransfer.printBalanceForUsers();
    }
}