import java.util.*;
import java.lang.*;
import java.util.Scanner;
class Lista {
    
    int dados[];
    int nElementos;
    int tamMax;
    
    public Lista(int t){
        tamMax = t;
        nElementos = 0;
        dados = new int[tamMax];
    }
    
    public boolean insere (int pos, int dado){       
        dados[pos - 1] = dado;
        nElementos++;
        return true;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner input = new Scanner(System.in);
        Lista s = new Lista(input.nextInt());
        
        for(int i=1;i<=s.dados.length;i++){
            s.insere(i, input.nextInt());
        }
        
        Lista q = new Lista(input.nextInt());
        
        for(int i=1;i<=q.dados.length;i++){
            q.insere(i, input.nextInt());
        }
        
        int[] ar = new int[s.dados.length];
        
        int z=0;
        
        for(int i=0;i<s.dados.length;i++){
            for(int j=0;j<q.dados.length;j++){
                if(s.dados[i] == q.dados[j])
                    break;
                else if(j==q.dados.length - 1){
                    ar[z] = s.dados[i];
                    z++;
                }                
            }
        }     
        for(int i=0; i<z; i++){
            for(int j=0; j<z-1; j++){
                if(ar[j]>ar[j + 1]){
                    int aux = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = aux;
                }
            }
	}
        for(int i=0;i<z;i++)
            System.out.print(ar[i] + " ");     
    }
}