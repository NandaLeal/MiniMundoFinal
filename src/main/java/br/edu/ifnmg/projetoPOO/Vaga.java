package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Vaga extends Entidade {

    private Long numero;
    private String placa;
    private String descricao;

    public Vaga() {

    }
    //<editor-fold defaultstate="collapsed" desc="Contrutores">
    /**
     * @param id Usado par aidentificação única no BD
     * @param numero Numero da vaga de estacionamento onde o veiculo se encontra
     * @param placa Placa do veículo que está na vaga
     * @param descricao Breve descricção com as características do veículo
     */
    public Vaga(Long id, Long numero, String placa, String descricao) {
        super(id);
        this.numero = numero;
        this.placa = placa;
        this.descricao = descricao;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
//</editor-fold>
    

}
