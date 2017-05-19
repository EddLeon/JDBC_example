/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eddy_
 */

package mensajeria;
public class Mensaje {
    private String de, para, contenido;

    public Mensaje(String de, String para, String contenido) {
        this.de = de;
        this.para = para;
        this.contenido = contenido;
    }

    public String getDe() {
        return de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}
