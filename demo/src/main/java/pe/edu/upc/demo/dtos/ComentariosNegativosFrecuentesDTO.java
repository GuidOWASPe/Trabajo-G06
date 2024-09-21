package pe.edu.upc.demo.dtos;

public class ComentariosNegativosFrecuentesDTO {
    private String contenido;
    private int frecuencia;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
}
