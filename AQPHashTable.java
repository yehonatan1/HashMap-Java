import java.util.Random;

public class AQPHashTable extends OAHashTable {

    int m;
    long p;
    ModHash modHash;

    public AQPHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int y = (int) ((modHash.Hash(x) + Math.pow(-1, i)) % m);
        if (y < 0)
            y += m;
        return y;
    }
}
