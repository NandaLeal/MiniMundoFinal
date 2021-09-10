package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;
import java.time.LocalDate;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class Fatura extends Entidade {

    private LocalDate dataEmissao;
    private int dataVencimento;
    private String valor;
    private Cliente cliente;
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Fatura() {
    }

    public Fatura(LocalDate dataEmissao, int dataVencimento, String valor, Cliente cliente, Long id) {
        super(id);
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.cliente = cliente;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getDiaVencimento() {
        return dataVencimento;
    }

    public void setDiaVencimento(int dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

//</editor-fold>
    
    
}
