package observables;

import observers.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class Item implements StockObservable {
    private List<StockObserver> observers;
    private int stockCount;

    public Item(int stockCount) {
        this.stockCount = stockCount;
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(StockObserver obs) {
        observers.add(obs);
    }

    @Override
    public void remove(StockObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void setStockCount(int cnt) {
        int prevCnt = stockCount;
        this.stockCount = cnt;
        if(prevCnt == 0 && cnt > 0) notifyUsers();
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }

    @Override
    public void notifyUsers() {
        for(StockObserver obs: observers) obs.update();
    }
}
