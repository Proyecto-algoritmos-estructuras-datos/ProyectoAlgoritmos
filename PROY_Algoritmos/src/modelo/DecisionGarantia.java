/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author antho
 */
public class DecisionGarantia {
     private final String codigo;               // "P1", "D2"...
    private final String texto;                // la pregunta o el motivo
    private final ResultadoGarantia resultado; // null si es una pregunta

    // Pregunta
    public DecisionGarantia(String codigo, String texto) {
        this(codigo, texto, null);
    }

    // Decisión final (hoja)
    public DecisionGarantia(String codigo, String texto, ResultadoGarantia resultado) {
        this.codigo = codigo;
        this.texto = texto;
        this.resultado = resultado;
    }

    public String getCodigo() { return codigo; }
    public String getTexto() { return texto; }
    public ResultadoGarantia getResultado() { return resultado; }
    public boolean esPregunta() { return resultado == null; }

    @Override
    public String toString() { return codigo + " - " + texto; }
}
