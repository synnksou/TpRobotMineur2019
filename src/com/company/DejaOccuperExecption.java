package com.company;

public class DejaOccuperExecption extends Exception{

    public  DejaOccuperExecption(String message){
        System.out.println("Si cette exception ce lance, c'est que un objet a essayer de ce placer sur un autre deja placer");
        System.out.println("Relancez l'application !!!");
        System.out.println(message);
    }
}