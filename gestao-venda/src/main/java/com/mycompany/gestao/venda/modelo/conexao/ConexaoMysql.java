/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao.venda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe Souza Moreira
 */
public class ConexaoMysql implements Conexao{
    private final String USUARIO = "root";
    private final String SENHA = "2210";
    private final String URL = "jdbc:mysql://localhost:3307/gestao_venda1";
    private Connection conectar;

    @Override
    public Connection obterConexao() throws SQLException {
        if(conectar == null){
                conectar = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conectar;
    }

    @Override
    public void fecharConexao() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
