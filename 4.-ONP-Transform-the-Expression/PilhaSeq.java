/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.util.*;
class PilhaSeq {
    private char dados[];
    private int topo;
    private int tamMax;
    
    public PilhaSeq(){
        tamMax = 100;
        dados = new char[tamMax];
        topo = -1;
    }
    public PilhaSeq(int n){
        tamMax = n;
        dados = new char[tamMax];
        topo = -1;
    }
    
    //Retorna o tamanho da pilha
    public int tamanho(){
        return topo+1;
    }
  
    //Insere um elemento no topo da pilha
    public boolean push(char s){
        topo++;
        dados[topo] = s;
        return true;
    }
    
    public char pop(){
        char s = dados[topo];
        topo--;
        return s;
    }
    
    public static String toOnp(String str){
        PilhaSeq operadores = new PilhaSeq();
        PilhaSeq operados = new PilhaSeq();
        String s = "";
        char exp[] = str.toCharArray();
        for(int i=0;i<exp.length;i++){
            if(exp[i] == '('){
            }
            else if(exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/' || exp[i] == '^'){
                operadores.push(exp[i]);
            }
            else if(exp[i] == ')'){
                s += operadores.pop();
            }
            else{
                s += exp[i];
            }
        }
        return s;
    } 
    public static void main (String[] args) throws java.lang.Exception{
        Scanner input = new Scanner(System.in);
        int cont = input.nextInt();
        input.nextLine();
        for(int i = 0;i<cont;i++){
        System.out.println(toOnp(input.nextLine()));
        }
    }   
}