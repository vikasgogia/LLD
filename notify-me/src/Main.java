import observables.Item;
import observables.StockObservable;
import observers.BackInStockNotification;
import observers.StockObserver;

public class Main {
    public static void main(String[] args) {

        StockObservable item = new Item(0);

        StockObserver obs1 = new BackInStockNotification(item);
        StockObserver obs2 = new BackInStockNotification(item);
        StockObserver obs3 = new BackInStockNotification(item);

        item.add(obs1);
        item.add(obs2);
        item.add(obs3);

        item.setStockCount(100);
    }
}