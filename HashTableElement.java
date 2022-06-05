
public class HashTableElement{
	private long key;
	private long value;
	
	public HashTableElement(long key, long value) {
		this.key = key;
		this.value = value;
	}
	
	public long GetKey() { return this.key;}
	
	public long GetValue() { return this.value;}

	public boolean isEmpty() { return false;}

	public static class EmptyHashTableElement extends HashTableElement{

		public EmptyHashTableElement() {
			super(0, 0);
		}

		@Override
		public boolean isEmpty() { return true;}
	}
}