package br.com.desafio.phone.VO.galeria;

public class MediaVO {
    // | Media | Controle | -idMedia        | Atributo (long) | Id para indexação e localização do item na galeria.  |
    // | Media | Controle | -tipoMedia      | Atributo (int ) | Tipo de Media: 0-Foto ou 1-Video.                    |
    // | Media | Controle | -resolucaoX     | Atributo (long) | Largura da foto ou quadro se vídeo (em pixel).       |
    // | Media | Controle | -resolucaoY     | Atributo (long) | Altura da foto ou quadro se vídeo (em pixel).        |
    // | Media | Controle | -videoTempo     | Atributo (Time) | Tempo de gravação do vídeo (Horas:minutos:segundos). |
    // | Media | Controle | -videoFPS       | Atributo (int ) | Quantidade de frames por segundo (se vídeo).         |
    // | Media | Controle | -videoPalmNtsc  | Atributo (int ) | Padrão de imagem do Video (PAL-M ou NTSC).           |
    // | Media | Controle | -corpoFotoVideo | Atributo (Hash) | Hash contendo a media propriamente dita.             |


    public MediaVO(Integer tipoMedia, Long resolucaoX, Long resolucaoY, Integer videoTempo, Integer videoFPS, Integer videoPalmNtsc, Object corpoFotoVideo) {
        //this.idMedia = idMedia;
        this.tipoMedia = tipoMedia;
        this.resolucaoX = resolucaoX;
        this.resolucaoY = resolucaoY;
        this.videoTempo = videoTempo;
        this.videoFPS = videoFPS;
        this.videoPalmNtsc = videoPalmNtsc;
        this.corpoFotoVideo = corpoFotoVideo;
    }


    public static final Integer TIPO_MEDIA_FOTO = 0; // Tipo de Media: 0-Foto.
    public static final Integer TIPO_MEDIA_VIDEO = 1; // Tipo de Media: 1-Video.
    public static final Integer TIPO_MEDIA_SOM = 2; // Tipo de Media: 2-Som, Musica, Voz.

    public static final Integer PADRAO_VIDEO_NTSC_FOTO = 0;  // Padrão de imagem do Video: 0-NTSC ou FOTO
    public static final Integer PADRAO_VIDEO_PALM = 1;  // Padrão de imagem do Video: 1-PAL-M


    private Long idMedia = 0L;          // Id para indexação e localização do item na galeria.
    private Integer tipoMedia = 0;      // Tipo de Media: 0-Foto ou 1-Video.
    private Long resolucaoX = 0L;       // Largura da foto ou quadro se vídeo (em pixel).
    private Long resolucaoY = 0L;       // Altura da foto ou quadro se vídeo (em pixel).
    private Integer videoTempo = 0;     // Tempo de gravação do vídeo (em segundos).
    private Integer videoFPS = 0;       // Quantidade de frames por segundo (se vídeo).
    private Integer videoPalmNtsc = 0;  // Padrão de imagem do Video (0-NTSC ou 1-PAL-M).
    private Object corpoFotoVideo = ""; // Hash contendo a media propriamente dita.


    @Override
    public String toString() {
        return  "tipo: " + (tipoMedia.equals(TIPO_MEDIA_FOTO)? "FOTO": "VÍDEO") + " | " +
                "resolucaoX: " + resolucaoX + " | " +
                "resolucaoY: " + resolucaoY + " | " +
                "Tempo: " + videoTempo + " | " +
                "FPS: " + videoFPS + " | " +
                (tipoMedia.equals(TIPO_MEDIA_FOTO)? "": "videoPalmNtsc: " + (videoPalmNtsc.equals(PADRAO_VIDEO_PALM)? "PAL-M": "NTSC") + " | ");
    }


    public Long getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(Long idMedia) {
        this.idMedia = idMedia;
    }

    public Integer getTipoMedia() {
        return tipoMedia;
    }

    public void setTipoMedia(Integer tipoMedia) {
        this.tipoMedia = tipoMedia;
    }

    public Long getResolucaoX() {
        return resolucaoX;
    }

    public void setResolucaoX(Long resolucaoX) {
        this.resolucaoX = resolucaoX;
    }

    public Long getResolucaoY() {
        return resolucaoY;
    }

    public void setResolucaoY(Long resolucaoY) {
        this.resolucaoY = resolucaoY;
    }

    public Integer getVideoTempo() {
        return videoTempo;
    }

    public void setVideoTempo(Integer videoTempo) {
        this.videoTempo = videoTempo;
    }

    public Integer getVideoFPS() {
        return videoFPS;
    }

    public void setVideoFPS(Integer videoFPS) {
        this.videoFPS = videoFPS;
    }

    public Integer getVideoPalmNtsc() {
        return videoPalmNtsc;
    }

    public void setVideoPalmNtsc(Integer videoPalmNtsc) {
        this.videoPalmNtsc = videoPalmNtsc;
    }

    public Object getCorpoFotoVideo() {
        return corpoFotoVideo;
    }

    public void setCorpoFotoVideo(Object corpoFotoVideo) {
        this.corpoFotoVideo = corpoFotoVideo;
    }

}
