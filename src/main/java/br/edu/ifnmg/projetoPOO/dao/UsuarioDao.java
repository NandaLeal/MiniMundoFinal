/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filipi Classe dao com as sentenças sql que serão usadas pra interagir
 * com o banco.
 */
public class UsuarioDao extends AbstractDao<Usuario, Long> {

    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO usuario (nome, email, senha, administrador, cpf) VALUES (?, ?, MD5(?), ?, ?);";
    }

    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM usuario WHERE cpf = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM usuario";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE usuario SET nome = ?, email = ?, senha = MD5(?), administrador = ?, cpf = ? WHERE cpf = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM usuario WHERE cpf = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Usuario usuario) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
            // insert
            if (usuario.getId() == null || usuario.getId() == 0) {
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getSenha());
                pstmt.setBoolean(4, usuario.isAdmin());
                pstmt.setLong(5, usuario.getCpf());
            } // update
            else {
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getSenha());
                pstmt.setBoolean(4, usuario.isAdmin());
                pstmt.setLong(5, usuario.getCpf());
                pstmt.setLong(6, usuario.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do usuario
        Usuario usuario = new Usuario();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do usuario a ser mapeado
        try {
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdmin(resultSet.getBoolean("administrador"));
            usuario.setCpf(resultSet.getLong("cpf"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Devolve o usuario mapeada
        return usuario;
    }

    @Override
    public List<Usuario> extrairObjetos(ResultSet resultSet) {

        // Cria referência para inserção dos usuarios a serem mapeadas
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do usuario
                Usuario usuario = new Usuario();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do usuario a ser mapeado
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAdmin(resultSet.getBoolean("administrador"));
                usuario.setCpf(resultSet.getLong("cpf"));

                // Insere o usuario na lista de usuarios recuperados
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de usuarios reconstituídas dos registros do banco 
        // de dados
        return usuarios;
    }

    public Usuario autenticar(Usuario usuario) {
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para validação de usuário
                        "SELECT * "
                        + "FROM tcdpoo.usuario "
                        + "WHERE email = ? "
                        + "AND senha = MD5(?)")) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getSenha());

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... implica que email e senha estão corretos 
                // para o usuário e devolve os dados completos deste
                return extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
