package com.mobile.zenus.pushnotification.util;

/**
 * Created by Tuca on 12/09/2017.
 */

public enum EnuServicos {


    NOTIFICACAO(1, "service.php");

    /**
     * Opção que será armazenada.
     */
    private final Integer codigo;

    /**
     * Nome amigavel pro usuário.
     */
    private final String nomeAmigavel;

    EnuServicos(final Integer codigo, final String nomeAmigavel) {
        this.codigo = codigo;
        this.nomeAmigavel = nomeAmigavel;
    }

    public Integer getCodigo() {

        return codigo;
    }

    public String getNomeAmigavel() {
        return nomeAmigavel;
    }

    public static EnuServicos valueOf(final Integer codigo) {

        EnuServicos result = null;

        final EnuServicos[] values = EnuServicos.values();

        for (final EnuServicos enumAtributoEspecial : values) {

            if (enumAtributoEspecial.codigo.equals(codigo)) {
                result = enumAtributoEspecial;
                break;
            }

        }

        return result;
    }
}