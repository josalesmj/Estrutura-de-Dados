import java.util.*;
import java.lang.*;

/**
 *
 * @author KAMINARI
 */
class HashIt{
    static class  hashList{
        private String[] key;
        private int tamanho = 0;
        
        public hashList(){
            key = new String[101];    
            for(int i=0; i<101; i++){
                key[i] = "";                
            }
        }
        
        public int getTamanho(){
            return tamanho;
        }
        
        public String getKey(int posicao){
            return key[posicao];
        }
                
        public int insere(String key){
            int pos = Hash(key); 
            int aux = pos;       
            
            for(int i = 0;i<20;){                
               if(this.key[aux].equals(key)){
                   return 0;
               }else{
                   i++;
                   aux = (Hash(key)+(i*i)+(23*i))%101;                   
               }
            }
            for(int i = 0;i<20;){
                if(this.key[pos].equals("") || this.key[pos].equals("empty")){
                    this.key[pos] = key;
                    tamanho++;
                    return 1;
                }else{
                    i++;
                    pos = (Hash(key)+(i*i)+(23*i    ))%101;                   
               }
            } 
            return 0;
        }
        
        public void remove(String key){
            int pos = procura(key);
            
            if(pos != -1){
                this.key[pos] = "empty";
                tamanho--;
            }  
        }
        
        public int procura(String key){
            int pos = Hash(key); 
            
            for(int i = 0; i<20;){
               if(this.key[pos].equals(key)){
                   return pos;
               }               
               else{
                   i++;
                   pos = (Hash(key)+(i*i)+(23*i))%101;                   
               }
            }
            return -1;
        }
        
        public int Hash(String key){
            char array[] = key.toCharArray();
            int hashKey;
            int soma=0;
                        
            for(int i=0; i < key.length(); i++){
                soma +=(((int)array[i]) * (i+1));
            }
            hashKey = 19*soma;
            return hashKey%101;
        }
    }
    
    public static void main(String[] args){    
        Scanner input = new Scanner(System.in); 
        String str;
        
        int cont1 = input.nextInt();
        
        hashList[] hash = new hashList[cont1];
        
        for(int i = 0;i<cont1;i++){
            hash[i] = new hashList();
            int cont2 = input.nextInt();
            input.nextLine();
            for(int j=0;j<cont2;j++){
                str = input.nextLine();
                if(str.startsWith("ADD")){
                    hash[i].insere(str.substring(4));
                }
                if(str.startsWith("DEL")){
                    hash[i].remove(str.substring(4));
                }               
            }
            System.out.println(hash[i].getTamanho());
            for(int j=0; j<101; j++){
                if(!(hash[i].getKey(j).equals("")) && !(hash[i].getKey(j).equals("empty"))){
                    System.out.println(j + ":" + hash[i].getKey(j));
                }
            }
        }         
    }   
}