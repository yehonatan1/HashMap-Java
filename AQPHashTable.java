import java.util.Random;

public class AQPHashTable extends OAHashTable {

    final int m;
    final long p;
    final ModHash modHash;

    public AQPHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int y = (int) ((modHash.Hash(x) + Math.pow(-1, i) * Math.pow(i, 2)) % m);
        if (y < 0)
            y += m;
        return y;
    }
}
