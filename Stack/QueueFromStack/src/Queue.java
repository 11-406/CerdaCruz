import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;


public class Queue<T> {
    private Deque<T> stack1,stack2;

    public Queue(){
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void add(T numb){
        stack1.push(numb);
    }

    public T remove (){
        if (isEmpty()){
            throw new NoSuchElementException();
        }else if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            reverse();
            return stack2.pop();
        }
    }

    private void reverse(){
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }







}
