package day02;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter rows of matrix 1: ");
        int rows1=sc.nextInt();
        System.out.println("enter columns of matrix 1: ");
        int cols1=sc.nextInt();
        System.out.println("enter of matrix 1: ");
        int[][] matrix1=new int[rows1][cols1];
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols1;j++){
                matrix1[i][j]= sc.nextInt();
            }
        }
        System.out.println("enter rows of matrix 2: ");
        int rows2=sc.nextInt();
        System.out.println("enter columns of matrix 2: ");
        int cols2=sc.nextInt();
        System.out.println("enter of matrix 2: ");
        int[][] matrix2=new int[rows2][cols2];
        for(int i=0;i<rows2;i++){
            for(int j=0;j<cols2;j++){
                matrix2[i][j]= sc.nextInt();
            }
        }
        int[][] matrix3=new int[rows1][cols2];
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                int sum=0;
                for(int k=0;k<rows1;k++){
                    sum=sum+(matrix1[i][k]*matrix2[k][j]);
                    matrix3[i][j]=sum;
                }
            }
        }

        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                System.out.print(matrix3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
