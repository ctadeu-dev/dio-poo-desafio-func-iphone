package br.com.desafio.phone.interfaces;

import br.com.desafio.phone.excessao.PhoneInitializeException;

public interface IntfcPhoneControle {

    public boolean ligarAparelho() throws PhoneInitializeException;
    public void desligarAparelho();

}
