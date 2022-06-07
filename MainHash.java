import java.util.Random;

public class MainHash {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException{
        int m = 10000019;
        long p = 1000000007;
        int n = Math.floorDiv(m, 2);
        int[] array = new int[n];
        Random random = new Random();
        int a, b;
        OAHashTable table = new AQPHashTable(m, p);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            b = random.nextInt(100);
            a = 100 * i + b;
            //array[i] = a;
            table.Insert(new HashTableElement(a, 0));
        }
        long estimatedTime = System.currentTimeMillis();
        System.out.println(estimatedTime - startTime);
    }
}