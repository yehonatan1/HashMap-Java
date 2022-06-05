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
        return (int) ((modHash.Hash(x) + Math.pow(-1, i)) % m);
    }
}
