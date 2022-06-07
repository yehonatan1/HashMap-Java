import java.util.Random;

public class ModHash {


    final long a, b, p;
    final int m;
    final static Random random = new Random();

    public ModHash(long a, long b, long p, int m) {
        this.a = a;
        this.b = b;
        this.p = p;
        this.m = m;
    }

    public static ModHash GetFunc(int m, long p) {

        long a = 1 + (random.nextLong() % (p - 1)); // a can't be zero
        long b = random.nextLong() % p;
        return new ModHash(a, b, p, m);
    }

    public int Hash(long key) {
        int y = (int) (((a * key + b) % p) % m);
        if (y < 0)
            y += m;
        return y;
    }
}
