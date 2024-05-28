package observables;

import observers.StockObserver;

public interface StockObservable {

    void add(StockObserver obs);

    void remove(StockObserver obs);

    void setStockCount(int cnt);

    int getStockCount();

    void notifyUsers();
}
