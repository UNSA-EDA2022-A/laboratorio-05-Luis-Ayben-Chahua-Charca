package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        

        if (s.length()%2==1){
            return false;
        }
        char[] arreglo = dividirString(s);
        // aqui si repide en cada elemento el proceso
        for(int i =0 ; i<arreglo.length;i++){
            //si es de apertura lo almacena dentro de la pila
            if (esApertura(arreglo[i])){
                stack.push(arreglo[i]);
                
            } else{
                /*si es de cierre comprobara si que el tope sea su complemtnto,
                * sino devolvera falso y estara desbalanceado
                */
                    
                if (stack.isEmpty()){
                    return false;
                }
                if(stack.top()==invertir(arreglo[i])){
                    stack.pop();

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //funcion que traslada todos los caracteres del string a un arreglo
    public char[] dividirString(String s){
        char[] arreglo = new char[s.length()];
        for(int i =0 ; i<s.length();i++){
            arreglo[i] = s.charAt(i);
        }
        return arreglo;
    }

    //funcion que determina si el operador es de apertura, servira para almacenar los caracteres en una pila.
    public boolean esApertura(char letra){
        return (letra=='(')||(letra=='[')||(letra=='{');
    }
    // funcion que invierte el operador deseado
    public char invertir(char letra){
        switch (letra){
            case '(': 
                return ')';
            case ')': 
                return '('; 
            case '{': 
                return '}'; 
            case '}': 
                return '{'; 
            case '[': 
                return ']'; 
            case ']': 
                return '[';                    

            default: 
                return ' ';    
        }
            
    }
}
