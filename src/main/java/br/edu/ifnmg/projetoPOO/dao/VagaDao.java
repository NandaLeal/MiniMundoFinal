/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Cliente;
import br.edu.ifnmg.projetoPOO.Usuario;
import br.edu.ifnmg.projetoPOO.Vaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class VagaDao extends AbstractDao<Vaga, Long> {

    /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO vaga (placa, descricao, numero) VALUES (?, ?, ?);";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM vaga WHERE numero = ?;";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM vaga;";
    }

    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM vaga WHERE numero = ?;";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE vaga SET modelo = ?, cor = ?, placa = ?, tipo = ?, cripto_placa = ? WHERE cripto_placa = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Vaga vaga) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
            if (vaga.getId() == null || vaga.getId() == 0) {
                pstmt.setString(1, vaga.getPlaca());
                pstmt.setString(2, vaga.getDescricao());
                pstmt.setLong(3, vaga.getNumero());
            } else {
                pstmt.setString(1, vaga.getPlaca());
                pstmt.setString(2, vaga.getDescricao());
                pstmt.setLong(3, vaga.getNumero());
                pstmt.setLong(4, vaga.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vaga extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem da vaga
        Vaga vaga = new Vaga();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado da vaga a ser mapeada
        try {
            vaga.setPlaca(resultSet.getString("placa"));
            vaga.setDescricao(resultSet.getString("descricao"));
            vaga.setNumero(resultSet.getLong("numero"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a vaga mapeada
        return vaga;
    }

    @Override
    public List<Vaga> extrairObjetos(ResultSet resultSet) {

        // Cria referência para inserção das vagas a serem mapeadas
        ArrayList<Vaga> vagas = new ArrayList<>();

        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem da vaga
                Vaga vaga = new Vaga();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado da vaga a ser mapeada
                vaga.setPlaca(resultSet.getString("placa"));
                vaga.setDescricao(resultSet.getString("descricao"));
                vaga.setNumero(resultSet.getLong("numero"));

                // Insere a tarefa na lista de vagas recuperadas
                vagas.add(vaga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de vagas reconstituídas dos registros do banco 
        // de dados
        return vagas;
    }

}
