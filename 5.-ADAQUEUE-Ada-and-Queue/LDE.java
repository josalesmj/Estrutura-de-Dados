import java.util.*;
class LDE {
    class No {
        private No ant;
	private int conteudo;
	private No prox;
	public No(){
            setProx(null);
        }
	public int getConteudo() {
            return conteudo;
	}
	public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
	}
	public No getProx() {
            return prox;
	}
	public void setProx(No prox) {
            this.prox = prox;
	}
	public No getAnt() {
            return ant;
	}
	public void setAnt(No ant) {
            this.ant = ant;
	}
    }
    private No inicio;
    private No fim;
    private int tamanho;
    public LDE(){
        inicio = null;
	fim = null;		
	tamanho = 0;
    }
    /** Verifica se a Lista está vazia */
    public boolean vazia() {
        if (tamanho == 0)
            return true;
        else
            return false;
    }
    /**Obtém o tamanho da Lista*/
    public int tamanho() {
        return tamanho;
    }
    /** Insere nó em lista vazia */
    private void insereInicioLista(int valor){
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setAnt(null);
        if (vazia()){
            inicio = novoNo;
            fim = novoNo;
        }
        else{
            inicio.setAnt(novoNo);    	    
            novoNo.setProx(inicio);
        }
	inicio = novoNo;
	tamanho++;
    }
    /** Insere nó no fim da lista */
    private void insereFimLista(int dado){
        if(vazia()){
            insereInicioLista(dado);
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(dado);
            No aux = inicio;
            while(aux.getProx() != null){
                aux = aux.getProx();
            }
            novoNo.setProx(null);
            aux.setProx(novoNo);
            novoNo.setAnt(fim);
            fim.setProx(novoNo);
            fim = novoNo; 
            this.tamanho++;
        }
    }
    /** Remove elemento do início da lista */
    private int removeInicioLista(){
        No p = inicio;
        int dado = p.getConteudo();
        if(inicio != fim){
            inicio = p.getProx();
            inicio.setAnt(null);
        }
        tamanho--;
        p = null;
        return dado;
    }	
    /** Remove elemento do início da lista */
    private int removeFimLista(){          
        No p = fim;
        int dado = p.getConteudo();
        if(inicio != fim){
            fim.getAnt().setProx(null);
            fim = fim.getAnt();
        }
        tamanho--;  
        p = null; 
	return dado;
    }
    private void inverteLista(){
        if(vazia()){
        }
        else{
            No aux = inicio;
            No temp = null;
            while(aux != null){
                temp = aux.ant;
                aux.ant = aux.prox;
                aux.prox = temp;
                aux = aux.ant;
            }
            if(temp != null){
                inicio = temp.ant;
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception{
        Scanner input = new Scanner(System.in);
        int cont = input.nextInt();
        LDE lista = new LDE();
        input.nextLine();
        String str[] = new String[cont];
        for(int i=0;i<cont;i++){
            str[i] = input.nextLine();
        }
        for(int i=0;i<cont;i++){
            if(str[i].equals("back")){
                if(lista.vazia())
                    System.out.println("No job for Ada?");
                else
                    System.out.println(lista.removeFimLista());
            }
            else if(str[i].equals("front")){
                if(lista.vazia())
                    System.out.println("No job for Ada?");
                else
                    System.out.println(lista.removeInicioLista());
            }
            else if(str[i].startsWith("push_back")){
                int valor = Integer.parseInt(str[i].substring(10));
                lista.insereFimLista(valor);
            }
            else if(str[i].startsWith("toFront")){
                int valor = Integer.parseInt(str[i].substring(8));
                lista.insereInicioLista(valor);
            }
            else if(str[i].equals("reverse")){
                lista.inverteLista();
            }
        }   
    }
}