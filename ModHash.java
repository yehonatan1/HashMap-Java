import java.util.Random;

public class ModHash {


    long a, b, p;
    int m;

    public ModHash(long a, long b, long p, int m) {
        this.a = a;
        this.b = b;
        this.p = p;
        this.m = m;
    }

    public static ModHash GetFunc(int m, long p) {
        // TODO implement random choice of mod function from family
        Random random = new Random(10);
        long a = 1 + (random.nextLong() % (p - 1)); // a can't be zero
        long b = random.nextLong() % p;
        return new ModHash(a, b, p, m);
    }

    public int Hash(long key) {
        // TODO implement hash function
        return (int) (((a * key + b) % p) % m);
    }
}
