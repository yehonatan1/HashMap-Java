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
        // TODO Complete hash table constructor.
    }

    @Override
    public int Hash(long x, int i) {
        // TODO implement hash function
        return (modHash.Hash(x) + (i * i)) % m;
    }
}
