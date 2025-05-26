public class ABB {
    private Node root;

    public ABB(){
        this.root = null;
    }
    public void inserir(Palavra novaPalavra){
        root = inserirRec(root,novaPalavra,null);
    }
    private Node inserirRec(Node atual, Palavra novaPalavra, Node father){
        if(atual == null){
            Node novo = new Node(novaPalavra);
            novo.setParent(father);
            return novo;
        }
        
        int comparar= novaPalavra.palavra.compareTo(atual.getElemento().palavra); // Entender

        if(comparar == 0){
            atual.getElemento().incrementacao();
        } else if (comparar < 0){
            atual.setLeft(inserirRec(atual.getLeft(), novaPalavra,atual));
        } else {
            atual.setRight(inserirRec(atual.getRight(), novaPalavra, atual));
        }
        
        return atual;
    }
    
    public int contarNos() {
        return contarNosRec(root);
    }   

    private int contarNosRec(Node atual) {
        if (atual == null) 
        return 0;
            return 1 + contarNosRec(atual.getLeft()) + contarNosRec(atual.getRight());
    }

    // Encontrar a palavra mais longa
    public Palavra encontrarLonga() {
        return encontrarLongaRec(root, null);
    }

    private Palavra encontrarLongaRec(Node atual, Palavra atualLonga) {
        if (atual == null) return atualLonga;

        Palavra atualPalavra = atual.getElemento();
        if (atualLonga == null || atualPalavra.palavra.length() > atualLonga.palavra.length()) {
        atualLonga = atualPalavra;
    }

    atualLonga = encontrarLongaRec(atual.getLeft(), atualLonga);
        return encontrarLongaRec(atual.getRight(), atualLonga);
    }

    public Palavra buscar(String palavraBuscada) {
    return buscarRec(root, palavraBuscada);
}

    private Palavra buscarRec(Node atual, String palavraBuscada) {
        if (atual == null) {
        return null;
    }

    int comparar= palavraBuscada.compareTo(atual.getElemento().palavra);

    if (comparar == 0) {
        return atual.getElemento();
    } else if (comparar < 0) {
        return buscarRec(atual.getLeft(), palavraBuscada);
    } else {
        return buscarRec(atual.getRight(), palavraBuscada);
    }
}

    public void exibirEmOrdem() {
    exibirEmOrdemRec(root);
}

    private void exibirEmOrdemRec(Node atual) {
        if (atual != null) {
        exibirEmOrdemRec(atual.getLeft());
        System.out.println(atual.getElemento()); 
        exibirEmOrdemRec(atual.getRight());
    }
}

    public void exibirPorTamanho(int tamanho) {
        int encontrados = exibirPorTamanhoRec(root, tamanho);
            if (encontrados == 0) {
                System.out.println("Nenhuma palavra com essa quantidade de letras foi encontrada.");
            }
        }

    private int exibirPorTamanhoRec(Node atual, int tamanho) {
        if (atual == null) return 0;

        int i = 0;
        i += exibirPorTamanhoRec(atual.getLeft(), tamanho);

        if (atual.getElemento().palavra.length() == tamanho) {
            System.out.println(atual.getElemento());
            i++;
        }

        i += exibirPorTamanhoRec(atual.getRight(), tamanho);
        return i;
    }
}