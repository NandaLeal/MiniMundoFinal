/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

public class Entidade {

    /**
     * Identidade da entidade (chave primária mapeada para o banco de dados)
     */
    private Long id;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * Construtor padrão.
     */
    public Entidade() {
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param id Identidade da entidade
     */
    public Entidade(Long id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //</editor-fold>
}
