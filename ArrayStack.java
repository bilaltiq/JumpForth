class ArrayStack implements Stack {

    private int[] array;
    private int capacity;
    private int index;

    public ArrayStack() {
        this.capacity = 10;
        this.array = new int[10];
        this.index = 0;
    }

    public void resize() {
        if (index == capacity) {
            capacity += 10;
            int[] resizedArray = new int[capacity];
            System.arraycopy(array, 0, resizedArray, 0, index);
            array = resizedArray;
        }
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void push(int toPush) {
        if (index < capacity) {
            array[index] = toPush;
            index++;
        }
    }

    @Override
    public int pop() {

        if (index != 0) {
            index--;
        }
        return array[index + 1];

    }

    @Override
    public void print() {

        for (int i = 0; i < index; i++) {
            System.out.println(array[i]);
        }

    }

    @Override
    public void insertBottom(int toInsert) {

        resize();
        for (int i = index; i < 0; i--) {
            array[i] = array[i + 1];
            array[0] = toInsert;
        }

    }

    @Override
    public int extractBottom() {
        int bottom = array[0];

        for (int i = 1; i < index; i++) {
            array[i] = array[i - 1];
        }

        return bottom;
    }

}