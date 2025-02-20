/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao.venda;

import com.mycompany.gestao.venda.modelo.conexao.Conexao;
import com.mycompany.gestao.venda.modelo.conexao.ConexaoMysql;
import com.mycompany.gestao.venda.modelo.dominio.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Felipe Souza Moreira
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        String sql = "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        Categoria categoria = new Categoria(null, "Bebida Java0", "Insercao no netbeans");
        
        String inserirSQL = "INSERT INTO categoria(nome, descricao) VALUES(?,?)";
        
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        
        preparedStatement.setString(1,categoria.getNome());
        preparedStatement.setString(2,categoria.getDescricao());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        System.out.println(resultadoDoCadastro);
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()){
            System.out.println(result.getString("nome"));
        }
    }
}