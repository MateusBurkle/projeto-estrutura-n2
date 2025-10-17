

public class Palavra {
    String palavra;
    int ocorrencias;

    public Palavra(String palavra){
        this.palavra = palavra;
        this.ocorrencias = 1;
    }
    public Palavra(String palavra, int ocorrencias){
        this.palavra = palavra;
        this.ocorrencias = ocorrencias; 
    }
    
    public void incrementacao(){
        this.ocorrencias++;
    }
    
    @Override
    public String toString(){
        return palavra + "(" + ocorrencias + ")"; 
    }
}
