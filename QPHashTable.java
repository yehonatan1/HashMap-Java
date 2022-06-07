import java.util.Random;

public class QPHashTable extends OAHashTable {

    int m;
    long p;
    ModHash modHash;

    public QPHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int y = (modHash.Hash(x) + (i * i)) % m;
        if (y < 0)
            y += m;
        return y;
    }
}
