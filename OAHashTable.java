
public abstract class OAHashTable implements IHashTable {
	
	private final HashTableElement [] table;
	private final int m;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int index = findElementIndex(key);
		if (index != -1)
			return table[index];
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		for (int i = 0; i < m; i++){
			int index = Hash(hte.GetKey(), i);
			System.out.println(index);
			if (table[index] == null || table[index].isEmpty()){
				table[index] = hte;
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
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);

	private int findElementIndex(long key){
		for (int i = 0; i < m; i++){
			int index = Hash(key, i);
			if (!table[index].isEmpty() && table[index].GetKey() == key)
				return index;
			else if (table[index] == null)
				return -1;
		}
		return -1;
	}
}
