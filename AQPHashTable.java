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
        // TODO Complete hash table constructor.
    }

    @Override
    public int Hash(long x, int i) {
        // TODO implement hash function
        return (int) ((modHash.Hash(x) + Math.pow(-1, i)) % m);
    }
}
