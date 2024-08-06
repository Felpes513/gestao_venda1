/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao.venda;

import com.mycompany.gestao.venda.modelo.dao.UsuarioDao;
import com.mycompany.gestao.venda.modelo.dominio.Perfil;
import com.mycompany.gestao.venda.modelo.dominio.Usuario;


/**
 *
 * @author Felipe Souza Moreira
 */
public class UsuarioTeste {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(0L,"Thalia", "2210", "That", Perfil.ADMIN, null, null);
        
        UsuarioDao UsuarioDao = new UsuarioDao();
        String mensagem = UsuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }
}
