import java.util.*;
import java.lang.*;
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
    private boolean flag;
    public LDE(){
        inicio = null;
	fim = null;		
	tamanho = 0;
        flag = false;     
    }
    public boolean vazia() {
        if (tamanho == 0)
            return true;
        else
            return false;
    }
    public int tamanho() {
        return tamanho;
    }
    private void insereInicioLista(int dado){
        if(flag == true){
            inverteLista();
            insereFimLista(dado);
            inverteLista();
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(dado);
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
    }
    private void insereFimLista(int dado){
        if(vazia()){
            insereInicioLista(dado);
        }
        else if(flag == true){
            inverteLista();
            insereInicioLista(dado);
            inverteLista();
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(dado);
            novoNo.setProx(null);
            novoNo.setAnt(fim);
            fim.setProx(novoNo);
            fim = novoNo; 
            this.tamanho++;
        }
    }
    private int removeInicioLista(){
        int dado = 0;
        if(flag == true){
            inverteLista();
            dado = removeFimLista();
            inverteLista();
            return dado;
        }
        else{
            No p = inicio;
            dado = p.getConteudo();
            if(inicio == fim){
                inicio = null;
                fim = null;
            }
            else{
                inicio = p.getProx();
                p.setProx(null);
                inicio.setAnt(null);
            }
            tamanho--;
            p = null;   
            return dado;
        }
    }
    private int removeFimLista(){          
        int dado = 0;
        if(flag == true){
            inverteLista();
            dado = removeInicioLista();
            inverteLista();
            return dado;
        }
        else{
            No p = fim;
            dado = p.getConteudo();
            if(inicio == fim){
                inicio = null;
                fim = null;
            }
            else{
                fim = p.getAnt();
                fim.setProx(null);
            }
            tamanho--;
            p = null;
            return dado;
        }
    }
    private void inverteLista(){
        if(vazia()){
            return;
        }
        else{
            No aux = inicio;
            inicio = fim;
            fim = aux;
            flag = !flag;        
        }
    }
    public static void main (String[] args) throws java.lang.Exception{
        try{
        Scanner input = new Scanner(System.in);
        int cont = input.nextInt();
        LDE lista = new LDE();
        input.nextLine();
        String str[] = new String[cont];
        for(int i=0;i<cont;i++){
            str[i] = input.nextLine();
        }
        int j = 0;
        for(int i=0;i<cont;i++){
            if(str[i].equals("back") || str[i].equals("front") || str[i].startsWith("push_back") || str[i].startsWith("toFront") || str[i].equals("reverse")){
                j++;
            }
        }
        if(j==cont){
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
        else{
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}