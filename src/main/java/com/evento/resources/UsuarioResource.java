package com.evento.resources;

import com.evento.dtos.UsuarioDTO;
import com.evento.models.Usuario;
import com.evento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }


    @PostMapping()
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
        this.usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario (@RequestBody UsuarioDTO usuarioDTO){

        UsuarioDTO dto = usuarioService.atualizarUsuario(usuarioDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }


    }


