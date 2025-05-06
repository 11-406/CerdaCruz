public class Traversal {
     Nodo root;

     public static void order(Nodo root){
        if (root==null){
            return;
        }

         System.out.println(root.getD());
         order(root.getLeft());
         order(root.getRight());
     }
}
