package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui

        char[] arreglo = dividirString(str);
        for(int i = 0; i<arreglo.length;i++) { 
            
            if (arreglo[i] == ')') { 
                
                char top = stack.top(); 
                stack.pop(); 
  
                int elementsInside = 0; 
                
                while (top != '(') { 
                    elementsInside++; 
                    top = stack.top(); 
                    stack.pop(); 
                } 
                
                if (elementsInside < 1){ 
                    return true; 
                } 
            } 
            
            else{ 
                stack.push(arreglo[i]); 
            } 
        } 
        return false;
    }

    //funcion que traslada todos los caracteres del string a un arreglo
    public char[] dividirString(String s){
        char[] arreglo = new char[s.length()];
        for(int i =0 ; i<s.length();i++){
            arreglo[i] = s.charAt(i);
        }
        return arreglo;
    }
}
