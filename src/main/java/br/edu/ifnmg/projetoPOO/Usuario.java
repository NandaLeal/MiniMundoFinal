package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Usuario extends Entidade {

    private String nome;
    private String senha;
    private String email;
    private boolean admin;
    private Long cpf;

    public Usuario() {

    }

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * @param id Usado par aidentificação única no BD
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     * @param administrador Identificação se o usuário de é administrador ou não
     * @param cpf Identificação única do usuário
     */
    public Usuario(Long id, String nome, String email, String senha, Boolean administrador, Long cpf) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.admin = administrador;
        this.cpf = cpf;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
//</editor-fold>
    

}
