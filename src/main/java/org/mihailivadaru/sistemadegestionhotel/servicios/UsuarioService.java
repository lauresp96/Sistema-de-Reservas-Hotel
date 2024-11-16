package org.mihailivadaru.sistemadegestionhotel.servicios;


import org.mihailivadaru.sistemadegestionhotel.entidades.Usuario;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private RepoUsuario repoUsuario;

    public Usuario registrarUsuario(Usuario usuario) {
        return repoUsuario.save(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return repoUsuario.findByEmail(email);
    }

    public boolean existeEmail(String email) {
        return repoUsuario.existsByEmail(email);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return repoUsuario.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return repoUsuario.findById(id);
    }
    public boolean eliminarUsuario(Long id) {
        if (repoUsuario.existsById(id)) {
            repoUsuario.deleteById(id);
            return true;
        }
        return false;
    }
}
