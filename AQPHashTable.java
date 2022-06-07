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
        int z;
        if (i % 2 == 0)
            z = 1;
        else
            z = -1;
        int y = ((modHash.Hash(x) + z * (i * i)) % m);
        if (y < 0)
            y += m;
        return y;
    }
}
