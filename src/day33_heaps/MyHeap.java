package day33_heaps;

public class MyHeap {
    int heapSize;
    int heap[];
    int capacity;

    MyHeap(int arr[]) {
        heap = arr;
        heapSize = arr.length;
        capacity = arr.length;
    }

    public void increaseCapacity() {
        int newCapacity = 2 * capacity;
        int[] newHeap = new int[newCapacity];
        for (int i = 0; i < heapSize; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
        capacity = newCapacity;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapify(int i) {
        int largest = i;
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largest]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largest]) {
            largest = rightChildIndex;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void buildTree() {
        // N/2 to N-1
        // 0 to (N/2-1)
        // Start from the last non-leaf node
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int extractMax() {
        if (heapSize <= 0) return -1;
        if (heapSize == 1) {
            heapSize--;
            return heap[0];
        }
        int max = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapify(0);
        return max;
    }

    // increase the key at index 4 eg. 15 bottom to up
    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= heapSize || heap[index] >= newValue) {
            System.out.println("Wrong Operation");
            return;
        }
        heap[index] = newValue;
        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index / 2.0) - 1)]) {
            swap(index, (int) (Math.ceil(index / 2.0) - 1));
            index = (int) (Math.ceil(index / 2.0) - 1);
        }
    }

    // decrease the key at index 4 eg. 15 use heapify
    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= heapSize || heap[index] <= newValue) {
            System.out.println("Wrong Operation");
            return;
        }
        heap[index] = newValue;
        heapify(index);
    }

    // (push) insert a new key
    // vacant leaf node pe insert kar doo phle fir increase key ka concept laga doo
    public void insertKey(int newValue) {
        if (heapSize + 1 >= capacity) {
            increaseCapacity();
        }

        heapSize++;
        heap[heapSize - 1] = newValue;// last element ko rakh doge
        int index = heapSize - 1;
        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index / 2.0) - 1)]) {
            swap(index, (int) (Math.ceil(index / 2.0) - 1));
            index = (int) (Math.ceil(index / 2.0) - 1);
        }

    }

    public void extractMaxAndStore() {
        if (heapSize <= 0) {
            System.out.println("Heap is empty");
            return;
        }

        int max = heap[0];// store the root
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = max;// store in the last node
        heapSize--;// delete the last node
        heapify(0);
        return;
    }

    public int[] heapSort() {
        buildTree();
        int size = heapSize;
        for (int i = 0; i < size; i++) {
            extractMaxAndStore();
        }
        return heap;
    }

    public void printTree() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10, 5, 20, 6, 11};
        MyHeap heap = new MyHeap(arr);
//        heap.buildTree();
//        heap.printTree();
//        System.out.println("Max element: " + heap.extractMax());
//        heap.printTree();
//        heap.increaseKey(4, 15);
//        heap.printTree();
//        heap.decreaseKey(0, 4);
//        System.out.println("Max element: " + heap.extractMax());
//        heap.printTree();
//        heap.insertKey(18);
        heap.printTree();
        int[] sortedArr = heap.heapSort();
        System.out.println("Sorted array: ");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }

    }
}
