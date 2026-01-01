public class TokenBucket {

    // The total capacity.
    private final int maxBucketSize;

    // How many tokens we add per second.
    private final int refillRate;

    // When we last added tokens.
    private long lastRefillTimestamp;

    private double currTokens;

    // Constructor.
    public TokenBucket(int maxBucketSize, int refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currTokens = maxBucketSize;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        // 1. Lazy refilling the bucket based on time passed.
        refill();

        // 2. Check if we have tokens.
        if (this.currTokens >= 1) {
            this.currTokens -= 1;
            return true;
        }

        return false;
    }

    private void refill() {
        // Check for the time passed and add tokens
        // by formula = timePassed * refillRate
        long now = System.nanoTime();
        long timePassed = now - lastRefillTimestamp;
        // Divide by 10^9.
        double tokensToAdd = (timePassed * (double) refillRate) / 1_000_000_000.0;

        this.currTokens = Math.min(maxBucketSize, this.currTokens + tokensToAdd);
        this.lastRefillTimestamp = now;
    }
}
