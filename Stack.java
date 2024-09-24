public interface Stack {
    public int size();

    public void push(int toPush);

    public int pop();

    public void print(); // just for debugging

    public void insertBottom(int toInsert);

    public int extractBottom();

}
