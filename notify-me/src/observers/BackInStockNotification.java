package observers;

import observables.StockObservable;

public class BackInStockNotification implements StockObserver {

    private StockObservable stockObservable;

    public BackInStockNotification(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        int newCnt = stockObservable.getStockCount();
        System.out.println("Count of stock: " + newCnt);
    }
}
