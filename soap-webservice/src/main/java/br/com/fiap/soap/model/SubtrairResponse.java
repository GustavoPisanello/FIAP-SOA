package br.com.fiap.soap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubtrairResponse {
    private int resultado;
    public SubtrairResponse(){}

    public SubtrairResponse(int resultado){
        this.resultado = resultado;
    }

    public int getResultado(){
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
