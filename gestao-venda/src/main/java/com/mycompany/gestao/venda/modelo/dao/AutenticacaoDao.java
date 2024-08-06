/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao.venda.modelo.dao;

import com.mycompany.gestao.venda.DTO.LoginDTO;
import com.mycompany.gestao.venda.modelo.dominio.Perfil;
import com.mycompany.gestao.venda.modelo.dominio.Usuario;
import com.mycompany.gestao.venda.modelo.exception.NegocioException;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author Felipe Souza Moreira
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;
    
    public AutenticacaoDao(){
        this.usuarioDao = new UsuarioDao();
    }
    
    public boolean temPermissao(Usuario usuario){
        try{
            permisao(usuario);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissão", 0);
            return false;
        }
    }
    public void permisao(Usuario usuario){
        if(!Perfil.ADMIN.equals(usuario.getPerfil())){
            throw new NegocioException("Sem permissão para realizar esta acão");
        }
    }
    public Usuario login(LoginDTO login){
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());
        
        if(usuario == null || !usuario.isEstado())
            return null;
        
        if(usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())){
            
        }
        return null;
    }
// sem spring security
   // private boolean validaSenha(String senhaUsuario, String senhaLogin) {
     //   return senhaUsuario.equals(senhaLogin);
    //}
    
    private boolean validaSenha(String senhaUsuario, String senhaLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(senhaLogin, senhaUsuario);
    }
}