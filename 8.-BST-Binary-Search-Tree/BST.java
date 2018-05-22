/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BST{
    static class Node{
        int data;
        Node esq;
        Node dir;

        public Node(int data){
            this.data = data;
            esq = null;
            dir = null;
        }
    }

    static class Tree{
        protected Node root;
        protected int count;

        public Tree(){
            root = null;
            count = 0;
        }
        
        public void insertRoot(int x){
            Node aux = new Node(x);
            root = aux;

        }

        public void insert(int x, Node n){

            count++;

            if(x < n.data){
                if(n.esq == null){
                    Node leftNode = new Node(x);
                    n.esq = leftNode;
                }else{
                    insert(x, n.esq);
                }
            }else if (x > n.data){
                if(n.dir == null){
                    Node rightNode = new Node(x);
                    n.dir = rightNode;
                }else{
                    insert(x, n.dir);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        try{
            Tree tree = new Tree();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(in.readLine());

            for(int i = 0; i<len;i++) {

                String input = in.readLine();
                int x = Integer.parseInt(input);

                if(i == 0){
                    tree.insertRoot(x);
                }else{
                    Node n;
                    tree.insert(x, tree.root);
                }
                System.out.println(tree.count);
            }
        }catch(Exception e){
        }
    }
}