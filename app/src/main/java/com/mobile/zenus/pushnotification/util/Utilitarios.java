package com.mobile.zenus.pushnotification.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Tuca on 14/06/2017.
 */

public class Utilitarios {


    private static String SERVIDOR_LOCAL = "http://192.168.25.9/papo-service/web/";
    private static String SERVIDOR_PRODUCAO = "https://prazercity.000webhostapp.com/prazer/";

    public static final String ADMOB_UNIC = "ca-app-pub-5459227351754314/1383857388";

    public static final String ADMOB_UNIC2 = "ca-app-pub-5459227351754314/6875000981";


    public static boolean verificarConexao(Context context) {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }



    public static String acessarServico(EnuServicos enuServico) {

        StringBuilder realizarServico = new StringBuilder();

        realizarServico.append(SERVIDOR_LOCAL);

        realizarServico.append(enuServico.getNomeAmigavel());

        return realizarServico.toString();
    }
}