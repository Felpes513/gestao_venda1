/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestao.venda.modelo.conexao;

import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Felipe Souza Moreira
 */
public interface Conexao {
    
    public Connection obterConexao() throws SQLException;
    public void fecharConexao() throws SQLException;
}
