import java.util.Random;

public class LPHashTable extends OAHashTable {

    int m;
    long p;
    ModHash modHash;

    public LPHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int y = (modHash.Hash(x) + i) % m;
        if (y < 0)
            y += m;
        return y;
    }

}
