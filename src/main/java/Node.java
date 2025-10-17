public class Node{
    private Palavra elemento;
    private Node right, left, parent;

    public Node(Palavra elemento){
        this.elemento = elemento;
        right = left = parent = null;
    }
    public Palavra getElemento(){
        return elemento;
    }
    public Node getRight(){
        return right;
    }
    public Node getLeft(){
        return left;
    }
    public Node getParent(){
        return parent;
    }
    public void setElemento(Palavra elemento){
        this.elemento = elemento;
    }
    public void setRight(Node n){
        this.right = n;
    }
    public void setLeft(Node n){
        this.left = n;
    }
    public void setParent(Node n){
        this.parent = n;
    }
    public void mostrarNo(){
        System.out.print(elemento.toString() + " ");
    }
}