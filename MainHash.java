import java.util.Random;

public class MainHash {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        int m = 10000019;
        long p = 1000000007;
        int n = Math.floorDiv(m, 2);
        Random random = new Random();
        OAHashTable table = new DoubleHashTable(m, p);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            table.Insert(new HashTableElement(100L * i + random.nextInt(100), 0));
        }
        long estimatedTime = System.currentTimeMillis();
        System.out.println(estimatedTime - startTime);
    }
}