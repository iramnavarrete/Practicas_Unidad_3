/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_sorting;

import java.util.Scanner;

/**
 *
 * @author temporal2
 */
public class EVA3_1_SORTING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tam = 100000;
        int[] iArreglo  = new int[tam];
        int[] iArreglo2 = new int[tam];
        int[] iArreglo3 = new int[tam];
        int[] iArreglo4 = new int[tam];
        int[] iArreglo5 = new int[tam];

        System.out.println("Método selectionSort:");

        for (int i = 0; i < 10; i++) {

            llenar(iArreglo);
            long lIni = System.nanoTime();
            selectionSort(iArreglo);
            long lFin = System.nanoTime();
            long lTot = lFin - lIni;
            System.out.println(lTot);

        }

        System.out.println("Método insertionSort:");
        for (int i = 0; i < 10; i++) {

            llenar(iArreglo2);
            long lIni2 = System.nanoTime();
            insertionSort(iArreglo2);
            long lFin2 = System.nanoTime();
            long lTot2 = lFin2 - lIni2;
            System.out.println(lTot2);
        }

        System.out.println("Método bubbleSort:");
        for (int i = 0; i < 10; i++) {

            llenar(iArreglo3);
            long lIni3 = System.nanoTime();
            bubbleSort(iArreglo3);
            long lFin3 = System.nanoTime();
            long lTot3 = lFin3 - lIni3;
            System.out.println(lTot3);
        }

        
        System.out.println("Método quickSort:");
        for (int i = 0; i < 10; i++) {

            llenar(iArreglo5);
            long lIni5 = System.nanoTime();
            quickSort(iArreglo5, 0, iArreglo5.length - 1);
            long lFin5 = System.nanoTime();
            long lTot5 = lFin5 - lIni5;
            System.out.println(lTot5);
        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Valor a buscar por binarySearch");
//        int iVal=sc.nextInt();
//        int iRes= binarySearch(iArreglo, iVal);
//        System.out.println(iRes);
//        
//        System.out.println("Valor a buscar por busquedaSecuencial");
//        int iVal2 = sc.nextInt();
//        int iPos=busquedaSecuencial(iArreglo, iVal2);
//        System.out.println(iPos);
//        
//        System.out.println("Método intertionSort:");
    }

    public static void llenar(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            iArre[i] = (int) (Math.random() * 1000000) + 1;
        }
    }

    public static void imprimirArreglo(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            System.out.print("[" + iArre[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < iArre.length; j++) {//BUSQUEDA DEL MAS PEQUEÑO
                if (iArre[j] < iArre[iMin]) {
                    iMin = j; //Guarda la posicion del mas pequeño
                }//TERMINO DE BUSQUEDA, EL INTERCAMBIO

            }
            int iTemp = iArre[iMin];
            iArre[iMin] = iArre[i];
            iArre[i] = iTemp;
        }
    }

    public static void insertionSort(int[] iArre) {
        for (int i = 1; i < iArre.length; i++) {
            int iTemp = iArre[i];
            int j = i;
            while ((j > 0 && iTemp < iArre[j - 1])) {
                iArre[j] = iArre[j - 1];
                j--;
            }
            iArre[j] = iTemp;
        }
    }

    public static void bubbleSort(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {

            for (int j = i + 1; j < iArre.length; j++) {
                int iTemp = iArre[i];
                if (iArre[i] > iArre[j]) {
                    iArre[i] = iArre[j];
                    iArre[j] = iTemp;
                }
            }
        }
    }

    public static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) { //copia los elementos que quedan de la primera mitad (si los hay)
            A[k++] = B[i++];
        }
    }

    public static void mergeSort(int A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergeSort(A, izq, m);
            mergeSort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public static void quickSort(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {// mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A[j] > pivote) {
                j--;// busca elemento menor que pivote
            }
            if (i < j) {// si no se han cruzado                      
                aux = A[i];// los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quickSort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quickSort(A, j + 1, der); // ordenamos subarray derecho
        }
    }

    public static int binarySearch(int[] iArre, int iValorBuscar) {
        return binSearchRec(iArre, iValorBuscar, 0, iArre.length - 1);
    }

    private static int binSearchRec(int[] iArre, int iValorBuscar, int iLo, int iHi) {
        int iPos = -1;
        int iMid = iLo + ((iHi - iLo) / 2);
        if (iLo <= iHi) {
            if (iValorBuscar == iArre[iMid]) {//Si es igual, ahi esta el valor
                iPos = iMid;
            } else if (iValorBuscar < iArre[iMid]) {
                iPos = binSearchRec(iArre, iValorBuscar, iLo, iMid - 1);
            } else if (iValorBuscar > iArre[iMid]) {
                iPos = binSearchRec(iArre, iValorBuscar, iMid + 1, iHi);
            }
        }
        return iPos;
    }

    public static int busquedaSecuencial(int[] iArre, int iValorBuscar) {
        int iPos = 0;
        for (int i = 0; i < iArre.length; i++) {
            if (iValorBuscar == iArre[i]) {

                iPos = i;
            }
        }
        return iPos;
    }
}
