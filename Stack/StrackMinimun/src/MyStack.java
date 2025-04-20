class MyStack {
    private int[] data;
    private int top;
    private int capacity;

    public MyStack(int initialCapacity) {
        data = new int[initialCapacity];
        top = -1;
        capacity = initialCapacity;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            // Duplicamos el tamaño del arreglo cuando se llena
            expand();
        }
        data[++top] = value;
    }

    public int pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            System.out.println("Stack underflow");
            return -1;  // valor de error
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            return -1; // valor de error
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void expand() {
        // Creamos un nuevo arreglo más grande
        int newCapacity = capacity * 2;
        int[] newData = new int[newCapacity];

        // Copiamos los elementos al nuevo arreglo
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }

        // Reemplazamos el arreglo antiguo por el nuevo
        data = newData;
        capacity = newCapacity;
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
