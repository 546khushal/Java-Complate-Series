public class Create_ArrayList {
    public static class ArrayList {
        private int[] arr;
        private int size;
        private int capacity;

        // Constructor with default capacity
        public ArrayList() {
            this(5); // Calls the parameterized constructor
        }

        // Parameterized constructor (was missing in your original code)
        public ArrayList(int initialCapacity) {
            this.arr = new int[initialCapacity];
            this.capacity = initialCapacity;
            this.size = 0;
        }

        public void add(int ele) {
            // Check if we need to resize
            if (size == capacity) {
                resize();
            }
            arr[size++] = ele;
        }

        private void resize() {
            capacity *= 2; // Double the capacity
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }

        public int size() {
            return size;
        }
        public void set(int index,int value){
            arr[index]=value;
        }
        public void printArray(){
            for(int i=0;i<size;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.set(0,10);
        System.out.println("Size: " + arr.size()); // Output: 2
        arr.printArray();
    }
}