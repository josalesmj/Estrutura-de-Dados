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

class TREEORD{
    static class Node{
        int valor;
		Node esquerdo;
		Node direito;
	
        public Node(int valor) {
            this.valor = valor;
            esquerdo = null;
            direito = null;
        }
    }
    
    static class Tree{
        protected String posStr = "";
	protected static int preIndex = 0;
		
	private Node montaTree(String in[], String pre[], int inStrt, int inEnd){
            if (inStrt > inEnd)
                return null;
                 
	    int valor = Integer.parseInt(pre[preIndex++]);
	    Node tNode = new Node(valor);
	    if (inStrt == inEnd)
                return tNode;
            
            int inIndex = procura(in, inStrt, inEnd, tNode.valor);
	    tNode.esquerdo = montaTree(in, pre, inStrt, inIndex - 1);
	    tNode.direito = montaTree(in, pre, inIndex + 1, inEnd);
	    return tNode;
        }
        

	private int procura(String arr[], int strt, int end, int valor){
            int i;
	    for (i = strt; i <= end; i++){
                int arrValue = Integer.parseInt(arr[i]);
                if ( arrValue == valor)
                    return i;
            }
            return i;
        }
        
        private void posOrdemTree(Node nó){
            if (nó == null)
                return;
            
			posOrdemTree(nó.esquerdo);
			posOrdemTree(nó.direito);
			posStr += nó.valor + " ";
        }
        
        private String equalsStr(){
            return posStr;
        }
    }
    
    public static void main(String[] args) throws IOException{
        try{
            Tree tree = new Tree();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(in.readLine());
            
            String pre = in.readLine();
            String preOrdem[] = pre.split(" ");
			
            String pos = in.readLine();
	
            String inOr = in.readLine();
            String inOrdem[] = inOr.split(" ");
	
            Node root = tree.montaTree(inOrdem, preOrdem, 0, size-1);
            tree.posOrdemTree(root);
	
            String posTree = tree.equalsStr();

            String posStr = posTree.substring(0, posTree.length() - 1);
            if(pos.equals(posStr)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}