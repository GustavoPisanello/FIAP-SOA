package br.com.fiap.soap.service;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import br.com.fiap.soap.model.SomaResponse;
import br.com.fiap.soap.model.SubtrairResponse;

@WebService
public class CalculadoraService {
    @WebMethod
    public SomaResponse somar(
            // @WebParam define explicitamente o nome do campo no XML
            @WebParam(name = "numero1") int numero1,
            @WebParam(name = "numero2") int numero2
    ) {
        int resultado = numero1 + numero2;
        return new SomaResponse(resultado);
    }

    @WebMethod
    public SubtrairResponse subtrair(
            @WebParam(name = "numero1") int numero1,
            @WebParam(name = "numero2") int numero2
    ){
        int resultado = numero1 - numero2;
        return new SubtrairResponse(resultado);
    }
}