/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import java.util.List;


public interface IDao<T, K> {
    
    public K salvar(T o);
    public T localizarPorId (K id);
    public List<T> localizarTodos();
    public Boolean excluir(T o);    
    
}
