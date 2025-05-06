public class Main {
    public static int fact(int n ){
        if (n==0 || n==1) return 1;
        else {
            return n*fact(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        Nodo r = new Nodo(1);
        r.left(new Nodo(2));
        r.right(new Nodo(3));
        r.getLeft().left(new Nodo(4));
        r.getLeft().right(new Nodo(5));


        Traversal.order(r);
        System.out.println("max= " + TraversalMax.max(r));
    }
}