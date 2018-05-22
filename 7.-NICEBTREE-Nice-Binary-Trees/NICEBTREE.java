/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.*;
import java.util.*;
import java.lang.*;


class NICEBTREE{

    static class No{

        protected char content;
        protected No direito;
        protected No esquerdo;

        public No(char content){
            this.content = content;
            esquerdo = null;
            direito = null;
        }
    }

    static class Tree{

        protected No root;
        protected No aux;
        protected int index = 0;

        public Tree(){
            root = null;
        }

        public void insere(char c[]){

            No novoNo = new No(c[index]);
            root = novoNo;
            if(c[index] == 'n'){
                novoNo.esquerdo = insereFolha(root, c[++index], c);
                novoNo.direito = insereFolha(root, c[++index], c);
            }
        }

        public No insereFolha(No parent, char content, char c[]){
            No aux = new No(content);

            if(content == 'n'){
                aux.esquerdo = insereFolha(aux, c[++index], c);
                aux.direito = insereFolha(aux, c[++index], c);

            }
            return aux;
        }

        public int getProfundidade(No n){
            if(n.content == 'l'){
                return 0;
            }

            int profundidadeEsquerda = getProfundidade(n.esquerdo);
            int profundidadeDireita = getProfundidade(n.direito);

            if(profundidadeEsquerda > profundidadeDireita){
                return ++profundidadeEsquerda;
            }else{
                return ++profundidadeDireita;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            int tamanho = Integer.parseInt(in.readLine());
            int output[] = new int[tamanho];

            for(int i = 0; i < tamanho; i++){
                String aux = in.readLine();
                char letters[] = aux.toCharArray();
                Tree t = new Tree();
                t.insere(letters);
                output[i] = t.getProfundidade(t.root);
            }

            for(int i = 0; i<tamanho; i++){
                System.out.println(output[i]);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}