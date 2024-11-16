package org.mihailivadaru.sistemadegestionhotel.APIs;

import org.mihailivadaru.sistemadegestionhotel.DTO.UsuarioDTO;
import org.mihailivadaru.sistemadegestionhotel.entidades.Rol;
import org.mihailivadaru.sistemadegestionhotel.entidades.Usuario;
import org.mihailivadaru.sistemadegestionhotel.servicios.RolService;
import org.mihailivadaru.sistemadegestionhotel.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioAPI {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolService rolService;

    // Ver todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Ver un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.existeEmail(usuarioDTO.getEmail())) {
            return ResponseEntity.badRequest().body("El correo ya está registrado.");
        }

        // Convertir DTO a entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        // Verificar si rolesIds no es null y asignar los roles
        List<Long> rolesIds = usuarioDTO.getRolesIds();
        if (rolesIds == null) {
            rolesIds = new ArrayList<>();  // Si es null, asignar una lista vacía
        }

        List<Rol> roles = rolesIds.stream()
                .map(id -> rolService.findById(id))  // Usa el rolService para buscar el rol por ID
                .collect(Collectors.toList());

        usuario.setRoles(roles);

        // Registrar usuario con roles
        usuarioService.registrarUsuario(usuario);

        return ResponseEntity.ok("Usuario registrado con éxito.");
    }
}
