public class Main {

    public static void main(String[] arg) throws InterruptedException{
        // capacity = 10
        // refill rate  5 tokens / second
        TokenBucket bucket = new TokenBucket(10, 5);

        System.out.println("--- Bursting the bucket (12 requests) ---");
        for (int i = 1; i <= 12; i++) {
            boolean allowed = bucket.allowRequest();
            System.out.println("Request " + i + ": " + (allowed ? "✅ Allowed" : "❌ Denied"));
        }

        System.out.println("\n--- Waiting 1 second for refill... ---");
        Thread.sleep(1000);

        System.out.println("--- Trying 7 more requests ---");
        for (int i = 1; i <= 7; i++) {
            boolean allowed = bucket.allowRequest();
            System.out.println("Request " + i + ": " + (allowed ? "✅ Allowed" : "❌ Denied"));
        }
    }
}
