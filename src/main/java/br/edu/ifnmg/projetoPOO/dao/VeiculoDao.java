/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Veiculo;
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
public class VeiculoDao extends AbstractDao<Veiculo, Long> {

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO veiculo (modelo, cor, placa, tipo, id_placa) VALUES (?,?,?,?,?);";
    }

    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM veiculo WHERE id_placa = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM veiculo;";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE veiculo SET numero = ?, placa = ?, descricao = ? WHERE numero = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM veiculo WHERE id_placa = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Veiculo veiculo) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
            // INSERT
            if (veiculo.getId() == null || veiculo.getId() == 0) {
                pstmt.setString(1, veiculo.getModelo());
                pstmt.setString(2, veiculo.getCor());
                pstmt.setString(3, veiculo.getPlaca());
                pstmt.setString(4, veiculo.getTipo());
                pstmt.setLong(5, veiculo.getIdPlaca());
            } else {
                // UPDATE
                pstmt.setString(1, veiculo.getModelo());
                pstmt.setString(2, veiculo.getCor());
                pstmt.setString(3, veiculo.getPlaca());
                pstmt.setString(4, veiculo.getTipo());
                pstmt.setLong(5, veiculo.getIdPlaca());
                pstmt.setLong(6, veiculo.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Veiculo extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do veiculo
        Veiculo veiculo = new Veiculo();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do veiculo a ser mapeado
        try {
            veiculo.setModelo(resultSet.getString("modelo"));
            veiculo.setCor(resultSet.getString("cor"));
            veiculo.setPlaca(resultSet.getString("placa"));
            veiculo.setTipo(resultSet.getString("tipo"));
            veiculo.setIdPlaca(resultSet.getLong("id_placa"));
            veiculo.setId(resultSet.getLong("id_placa"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve o veiculo mapeado
        return veiculo;
    }

    @Override
    public List<Veiculo> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos Veiculos a serem mapeados
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {

                // Cria referência para montagem dos Veiculos
                Veiculo veiculo = new Veiculo();

                // Cria referência para montagem do Veiculos
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setCor(resultSet.getString("cor"));
                veiculo.setPlaca(resultSet.getString("placa"));
                veiculo.setTipo(resultSet.getString("tipo"));
                veiculo.setIdPlaca(resultSet.getLong("id_placa"));
                veiculo.setId(resultSet.getLong("id_placa"));

                veiculos.add(veiculo);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de Veiculos reconstituídos dos registros do banco 
        // de dados
        return veiculos;
    }

}
