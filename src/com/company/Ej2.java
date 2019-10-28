package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ej2 {

    private void probarClaves() throws IOException {


        File f = new File("clausA4.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br =  new BufferedReader(fr);

        Path path = Paths.get("textamagat");
        byte[] textenbytes = Files.readAllBytes(path);



        byte[] descifrado = new byte[0];

        String line = br.readLine();
        boolean salir = false;
        while(!salir) {
            SecretKey sk = Keys.passwordKeyGeneration(line, 128);
            try {
            descifrado = Keys.decryptData(sk,textenbytes);
            salir=true;
            }catch (BadPaddingException e){
                line = br.readLine();
            }
        }
        System.out.println(new String(descifrado));


        br.close();
    }

    public static void main(String[] args) throws IOException {
        Ej2 descifrar = new Ej2();
        descifrar.probarClaves();
    }
}
