
public abstract class OAHashTable implements IHashTable {

    private HashTableElement[] table;
    private final int m;
	private int size;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
        this.m = m;
		size = 0;
    }


    @Override
    public HashTableElement Find(long key) {
        int index = findElementIndex(key);
        if (index != -1)
            return table[index];
        return null;
    }

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
		size++;
        for (int i = 0; i < m; i++) {
            int index = Hash(hte.GetKey(), i);
            if (table[index] == null) {
                table[index] = hte;
                return;
            } else if (table[index].isEmpty()) {
                table[index] = hte;
                for (int j = i + 1; j < m; j++) {
                    index = Hash(hte.GetKey(), j);
                    if (table[index] == null)
                        return;
                    else if (!table[index].isEmpty() && table[index].GetKey() == hte.GetKey())
                        throw new KeyAlreadyExistsException(hte);
                }
                return;
            } else if (table[index].GetKey() == hte.GetKey())
                throw new KeyAlreadyExistsException(hte);
        }
        throw new TableIsFullException(hte);
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        int index = findElementIndex(key);
        if (index == -1)
            throw new KeyDoesntExistException(key);
        table[index] = new HashTableElement.EmptyHashTableElement();
		size--;
		if (size == 0)
			table = new HashTableElement[m];
    }

    /**
     * @param x - the key to hash
     * @param i - the index in the probing sequence
     * @return the index into the hash table to place the key x
     */
    public abstract int Hash(long x, int i);

    private int findElementIndex(long key) {
        for (int i = 0; i < m; i++) {
            int index = Hash(key, i);
            if (!table[index].isEmpty() && table[index].GetKey() == key)
                return index;
            else if (table[index] == null)
                return -1;
        }
        return -1;
    }
}
