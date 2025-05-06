public class Nodo {
    private int d;
    private Nodo l;
    private Nodo r;

    public Nodo(int d) {
        this.l = null;
        this.d = d;
        this.r = null;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Nodo getLeft() {
        return l;
    }

    public void setLeft(Nodo l) {
        this.l = l;
    }

    public Nodo getRight() {
        return r;
    }

    public void setRight(Nodo v) {
        this.r = v;
    }

    public void left(Nodo nodo){
        this.setLeft(nodo);
    }
    public void right(Nodo nodo){
        this.setRight(nodo);
    }
}
