package br.com.desafio.phone.VO.telefone;

import java.util.HashMap;

public class ContatoVO {

    // | Contato | Informação | -nomeContato | Atributo (String) | Nome do contato. |
    // | Contato | Informação | -tipoTelefone | Atributo (String) | Tipo do contato (Residencial, Comercial, Whatsapp, etc). |
    // | Contato | Informação | -paisTelefone | Atributo (String) | País onde o numero de telefone está (ex.: +55 Brasil). |
    // | Contato | Informação | -dddTelefone | Atributo (String) | DDD referente à região onde a operadora está. |
    // | Contato | Informação | -numTelefone | Atributo (String) | Numero do telafone. |


    private static HashMap<Long, String> tipoDescTelefone = new HashMap<>();


    public static final Long TIPO_TELEF_CELULAR     = 1L; // Tipo do Contato: 1-Celular
    public static final Long TIPO_TELEF_RESIDENCIAL = 2L; // Tipo do Contato: 2-Residencial
    public static final Long TIPO_TELEF_COMERCIAL   = 3L; // Tipo do Contato: 3-Comercial
    public static final Long TIPO_TELEF_WHATSAPP    = 4L; // Tipo do Contato: 4-Whatsapp
    public static final Long TIPO_TELEF_OUTRO       = 5L; // Tipo do Contato: 5-Outro


    static {
        tipoDescTelefone.put(ContatoVO.TIPO_TELEF_CELULAR, "Celular");
        tipoDescTelefone.put(ContatoVO.TIPO_TELEF_RESIDENCIAL, "Residencial");
        tipoDescTelefone.put(ContatoVO.TIPO_TELEF_COMERCIAL, "Comercial");
        tipoDescTelefone.put(ContatoVO.TIPO_TELEF_WHATSAPP, "Whatsapp");
        tipoDescTelefone.put(ContatoVO.TIPO_TELEF_OUTRO, "Outro");
    }


    public ContatoVO(String nomeContato, String paisTelefone, String dddTelefone, String numTelefone, Long tipoTelefone, String descTipoOutro) {
        this.nomeContato = nomeContato;
        this.paisTelefone = paisTelefone;
        this.dddTelefone = dddTelefone;
        this.numTelefone = numTelefone;
        this.tipoTelefone = tipoTelefone;
        this.descTipoOutro = descTipoOutro;
    }

    private Long   idContato     = 0L; // Id para indexação e localização do item na Agenda.
    private String nomeContato   = ""; // Nome do contato.
    private String paisTelefone  = ""; // País onde o nÚmero de telefone está (ex.: +55 Brasil).
    private String dddTelefone   = ""; // DDD referente à região onde a operadora está.
    private String numTelefone   = ""; // Numero do telefone.
    private Long   tipoTelefone  = 0L; // Tipo do telefone (1-Celular, 2-Residencial, 3-Comercial, 4-Whatsapp, 5-Outro).
    private String descTipoOutro = ""; // Descrição de outro tipo de telefone

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    @Override
    public String toString() {
        return  "| id: " + this.idContato + " " +
                "| Nome: " + this.nomeContato + " " +
                "| Telefone: (+" + this.paisTelefone.trim() + ") (" + this.dddTelefone + ") " + this.numTelefone + " " +
                "| tipo: " + getDescTipoTelefone(this.tipoTelefone);
    }

    public String getNumeroTelefone() {
        return "+" + this.paisTelefone.trim() + this.dddTelefone + this.numTelefone;
    }

    private String getDescTipoTelefone(Long pTipoTelefone) {
        String valorRetorno = "";

        if (pTipoTelefone.equals(TIPO_TELEF_OUTRO)) {
            valorRetorno = this.descTipoOutro.trim();
        } else {
            valorRetorno = this.tipoDescTelefone.get(pTipoTelefone).trim();
        }

        return valorRetorno;
    }


}
