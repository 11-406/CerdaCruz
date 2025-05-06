public class TraversalMax {
     Nodo root;

     public static int max(Nodo root){
        if (root==null){
            return Integer.MIN_VALUE;
        }

         System.out.println(root.getD());

        int valueNodo = root.getD();

        int maxLeft = max(root.getLeft());

        int maxRight = max(root.getRight());

        return Math.max(valueNodo,Math.max(maxLeft,maxRight));
     }
}
