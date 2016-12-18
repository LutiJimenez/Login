package aaluti.login;

/**
 * Created by xIS13864 on 28/07/2016.
 */
public class Lista_Entrada {
    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private int activity;

    public Lista_Entrada (int idImagen, String textoEncima, String textoDebajo, int activity) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.activity = activity;
    }

    public String get_textoEncima() {
        return textoEncima;
    }

    public String get_textoDebajo() {
        return textoDebajo;
    }

    public int get_idImagen() {
        return idImagen;
    }

    public int get_activity() {
        return activity;
    }
}