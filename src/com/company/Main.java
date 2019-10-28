package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.util.Scanner;

//ANGEL MATEU PARIS

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //EJERCICIO 1.1
        String text = "Hola estoy descifrado";

        SecretKey sk = Keys.keygenKeyGeneration(192);
        byte[] cifrado = Keys.encryptData(sk, text.getBytes());
        byte[] descifrado = new byte[0];

        try {
            descifrado = Keys.decryptData(sk, cifrado);
        } catch (BadPaddingException e) {
            //e.printStackTrace();
        }

        System.out.println(new String(descifrado) + "     Descifrado con contraseña automatica.");

        //EJERCICIO 1.2
        SecretKey pass = Keys.passwordKeyGeneration("torte", 192);
        SecretKey userKey;

        boolean contraseña = false;
        System.out.println("Introduce Contraseña: ");

        userKey = Keys.passwordKeyGeneration(sc.nextLine(), 192);
        while (!contraseña) {
            try {
                descifrado = Keys.decryptData(pass, cifrado);
                System.out.println(new String(descifrado) + "     Descifrado con contraseña manual.");
                contraseña = true;
            } catch (BadPaddingException e) {
                System.out.println("Introduce Otra Contraseña");
                userKey = Keys.passwordKeyGeneration(sc.nextLine(), 192);
            }
            cifrado = Keys.encryptData(userKey, text.getBytes());
        }

    }
}
