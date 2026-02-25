package br.com.desafio.phone.utils;

public class Utils {

    public static void aguardar(long tempo ) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
