class ListStack implements Stack {
    private Node head;
    private Node tail;

    public ListStack() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public void push(int toPush) {
        Node node = new Node(toPush);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    @Override
    public int pop() {

        if (head == null) {
            throw new IllegalStateException();
        }

        int tmp = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return tmp;
    }

    @Override
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    @Override
    public void insertBottom(int toInsert) {
        Node temp = new Node(toInsert);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    @Override
    public int extractBottom() {

        int tmp = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return tmp;
    }

}
