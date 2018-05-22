/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAMINARI
 */
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

class OMWG{
    static int pontua(int lin, int col){
        int[][] matriz = new int[lin + 2][col + 2];
        int p = 0;
        for (int i = 1; i < lin + 1; i++){
            for (int j = 1; j < col + 1; j++){
                int left = matriz[i][j - 1];
                int right = matriz[i][j + 1];
                int up = matriz[i + 1][j];
                int down = matriz[i - 1][j];
                matriz[i][j] = 1;
                p += left + right + up + down;
            }
        }
        return p;
    }  
    public static void main(String[] args) throws IOException {
        try {
            int lin, col;
            Scanner input = new Scanner(System.in);
            
            int cont = Integer.parseInt(input.nextLine());
            for (int i = 0; i<cont; i++) {
                lin = input.nextInt();
                col = input.nextInt();
                System.out.println(pontua(lin, col));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}