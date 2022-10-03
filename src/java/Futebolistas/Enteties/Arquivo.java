package Futebolistas.Enteties;

/**
 *
 * @author victo
 */
public class Arquivo {
    private int id;
    private byte[] conteudo;
    private String mimetype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Arquivo() {
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Arquivo(byte[] conteudo, String mimetype) {
        this.conteudo = conteudo;
        this.mimetype = mimetype;
    }
    
    
}
