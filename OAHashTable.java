
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
			if (table[Hash(hte.GetKey(), i)] == null || table[Hash(hte.GetKey(), i)].isEmpty()){
				table[Hash(hte.GetKey(), i)] = hte;
				return;
			} else if (table[Hash(hte.GetKey(), i)].GetKey() == hte.GetKey())
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
			if (!table[Hash(key, i)].isEmpty() && table[Hash(key, i)].GetKey() == key)
				return Hash(key, i);
			else if (table[Hash(key, i)] == null)
				return -1;
		}
		return -1;
	}
}
