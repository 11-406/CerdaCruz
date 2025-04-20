import java.util.Scanner;

public class ExerciseMin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        MyStack stack1 = new MyStack(10);
        MyStack stack2 = new MyStack(10);

        System.out.println("//////////////////////");
        System.out.println("Enter the numbers in stack, " +
                "for finish to add numbers write finish or any letter or word");


        while (true){
                System.out.print("Enter the number =  ");
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                stack1.push(num);
            }else {
                break;
            }
        }

        int min = Integer.MAX_VALUE;

        while (!stack1.isEmpty()){
            int num = stack1.pop();
            min = (num<min)? num:min;

            stack2.push(min);

        }
        System.out.println("/////////////////////////");
        System.out.println("MIN");
        stack2.printStack();
        System.out.println("The minimun numbers is = " + stack2.peek());


    }
}
