import java.util.Random;

public class DoubleHashTable extends OAHashTable {

    final int m;
    final long p;
    final ModHash modHash1;
    final ModHash modHash2;

    public DoubleHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash1 = ModHash.GetFunc(m, p);
        modHash2 = ModHash.GetFunc(m-1, p);
    }

    @Override
    public int Hash(long x, int i) {
        int y = (modHash1.Hash(x) + (modHash2.Hash(x) + 1) * i) % m;
        if (y < 0)
            y += m;
        return y;
    }

}
