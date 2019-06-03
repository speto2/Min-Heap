package MinHeap;
import java.util.ArrayList;

public class minHeap {
	 public static ArrayList<Integer> items = new ArrayList<Integer>();
	 public int size = 0;
	
	public void swap(int indOne, int indTwo) {
		int temp = items.get(indOne);
		items.set(indOne, indTwo);
		items.set(indTwo, temp);
	}
	
	public int peek() {
		if(size == 0) {
			throw new IllegalStateException();
		}else {
			return items.get(0);
		}
	}
	
	public int delete() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		int item = items.get(0);
		items.set(0, size-1);
		size--;
		heapifyDown();
		return item;
	}
	
	public void heapifyDown() {
		int index = 0; 
		while(hasLChild(index)) {
			int smallerCIndex = getLeftChildIndex(index);
			if(hasRChild(index) && rightChild(index) < leftChild(index)) {
				smallerCIndex = getRightChildIndex(index);
			}
			
			if(items.get(index) < items.get(smallerCIndex)) {
				break;
			}else {
				swap(index, smallerCIndex);
			}
			index = smallerCIndex;
		}
		
	}
	
	/*insert into the heap*/
	public void insert(int item) {
		items.set(size, item);
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && parent(index) > items.get(index)) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	/*child index's*/
	public int getLeftChildIndex(int pIndex) {
		return(2 * pIndex + 1);
	}
	public int getRightChildIndex(int pIndex) {
		return(2 * pIndex + 2);
	}
	public int getParentIndex(int cIndex) {
		return((cIndex-1) /2);
	}
	
	/*test for child*/
	public boolean hasLChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	public boolean hasRChild(int index) {
		return getRightChildIndex(index) < size;	
	}
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	/*the child*/
	public int leftChild(int index) {
		return items.get(getLeftChildIndex(index));
	}
	public int rightChild(int index) {
		return items.get(getRightChildIndex(index)); 
	}
	public int parent(int index) {
		return items.get(getParentIndex(index));
	}	
}
