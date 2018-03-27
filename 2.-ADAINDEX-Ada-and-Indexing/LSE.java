import java.util.*;
class LSE{
    private No cabecaLista;
    private int nElementos;
    public class No{
        private String conteudo;
        private No prox;
        
        public No() {
            setProx(null);
        }
        public void setConteudo(String s){
            conteudo = s;
        }
        public String getConteudo(){
            return conteudo;
        }
        public void setProx(No prox){
            this.prox = prox;
        }
        public No getProx(){
            return prox;
        }
    }
    public LSE(){
        cabecaLista = null;
        nElementos = 0;
    }
    public void insereFimLista(String palavra){
        if(nElementos == 0){
            No novoNo = new No();
	    novoNo.setConteudo(palavra);
	    novoNo.setProx(cabecaLista);
	    cabecaLista = novoNo;
	    nElementos++;
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(palavra);
            No aux = this.cabecaLista;
            while(aux.getProx() != null){
                aux = aux.getProx();
            }        
            novoNo.setProx(null);
            aux.setProx(novoNo);
            this.nElementos++;
        }
    }
    public String elemento(int pos){
        No aux = cabecaLista;
        for(int i=1;i<pos;i++){
            aux = aux.getProx();
        }
        return aux.getConteudo();
    }
    public static void main (String[] args) throws java.lang.Exception{
        LSE lista = new LSE();
        LSE lista1 = new LSE();
        Scanner input = new Scanner(System.in);
        int N, Q;
        N = input.nextInt();
        Q = input.nextInt();   
        input.nextLine();
        for(int i=0;i<N;i++){
            String s = input.nextLine();
            lista.insereFimLista(s);
        }
        for(int i=0;i<Q;i++){
            String s = input.nextLine();
            lista1.insereFimLista(s);
        }
        for(int i=0;i<Q;i++){
            int cont=0;
            String s = lista1.elemento(i+1);
            for(int t=1;t<=N;t++){
                if(lista.elemento(t).startsWith(lista1.elemento(i+1)))
                    cont++;
            }
            System.out.println(cont);
        }
    }
}

//Coloca um outro scanner.nextLine() antes do teu s= scanner.nextline()