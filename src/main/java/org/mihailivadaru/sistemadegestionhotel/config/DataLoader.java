package org.mihailivadaru.sistemadegestionhotel.config;

import org.mihailivadaru.sistemadegestionhotel.entidades.Rol;
import org.mihailivadaru.sistemadegestionhotel.entidades.Usuario;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoRol;
import org.mihailivadaru.sistemadegestionhotel.repositorios.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RepoUsuario repoUsuario;

    @Autowired
    private RepoRol repoRol;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Verificar y crear roles si no existen
        Rol rolAdmin = repoRol.findByNombre("ROLE_ADMIN").orElseGet(() -> {
            Rol nuevoRolAdmin = new Rol();
            nuevoRolAdmin.setNombre("ROLE_ADMIN");
            return repoRol.save(nuevoRolAdmin);
        });

        Rol rolUser = repoRol.findByNombre("ROLE_USER").orElseGet(() -> {
            Rol nuevoRolUser = new Rol();
            nuevoRolUser.setNombre("ROLE_USER");
            return repoRol.save(nuevoRolUser);
        });

        // Verificar y crear usuarios si no existen
        if (!repoUsuario.existsByEmail("admin")) {
            Usuario admin = new Usuario();
            admin.setEmail("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRoles(List.of(rolAdmin));
            repoUsuario.save(admin);
        }

        if (!repoUsuario.existsByEmail("user")) {
            Usuario user = new Usuario();
            user.setEmail("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setRoles(List.of(rolUser));
            repoUsuario.save(user);
        }
    }


}
