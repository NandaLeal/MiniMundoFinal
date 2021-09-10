package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;
import java.time.LocalDate;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class Ticket extends Entidade {

    private LocalDate entrada;
    private String placa;
    private String descricaoVeiculo;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Ticket() {
    }

    public Ticket(LocalDate entrada, String placa, String descricaoVeiculo, Long id) {
        super(id);
        this.entrada = entrada;
        this.placa = placa;
        this.descricaoVeiculo = descricaoVeiculo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String observacao) {
        this.descricaoVeiculo = observacao;
    }

//</editor-fold>
    
}
