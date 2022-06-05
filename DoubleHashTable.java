import java.util.Random;

public class DoubleHashTable extends OAHashTable {

    int m;
    long p;
    ModHash modHash1;
    ModHash modHash2;

    public DoubleHashTable(int m, long p) {
        super(m);
        this.m = m;
        this.p = p;
        modHash1 = ModHash.GetFunc(m, p);
        modHash2 = ModHash.GetFunc(m, p);
        // TODO Complete hash table constructor.
    }

    @Override
    public int Hash(long x, int i) {
        // TODO implement hash function
        return (modHash1.Hash(x) + modHash2.Hash(x) * i) % m;
    }

}
