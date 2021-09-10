package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Veiculo extends Entidade {

    private String modelo;
    private String cor;
    private String placa;
    private String tipo;
    private Long idPlaca;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Veiculo() {

    }
    /**
     * @param id
     * @param modelo Representa o modelo do veículo (hatch, sedan, sport)
     * @param cor Representa a cor do veículo
     * @param placa Representa a placa do veículo (XXX-X0XXX)
     * @param tipo Representa o tipo do veículo (Carro ou moto)
     * @param idPlaca Identificador único do veículo em formato numério.
     *
     */
    
    public Veiculo(Long id, String modelo, String cor, String placa, String tipo, Long idPlaca) {
        super(id);
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipo = tipo;
        this.idPlaca = idPlaca;
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters/setters">
    public Long getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(Long idPlaca) {
        this.idPlaca = idPlaca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

//</editor-fold>
    
    /**
     * 
     * @return retorna o valor que será apresentado na interface combobox, com
     * as possíveis placas de veículos previamente cadastrados.
     */
    @Override
    public String toString() {
        return placa;
    }

    /**
     * O método irá conversar cada caractere da placa em um valor numérico
     * referente ao seu código na tabela ascii, de modo que posso usar como
     * identificador único em formato numérico para um veículo.
     *
     * @param placaVeiculo É a string com a placa do veículo
     * @return Retorna um Long com a conversão de cada caractere da placa em seu
     * respectivo valor número referente à tabela ascii.
     */
    public String CriptografarPlaca(String placaVeiculo) {

        String placaCriptografada = new String();
        char c;
        int ascii;
        Long longPlaca;

        for (int i = 0; i < placaVeiculo.length(); i++) {
            c = placaVeiculo.charAt(i);
            ascii = (int) c;
            placaCriptografada += ascii;
        }

        return placaCriptografada;
    }

}
