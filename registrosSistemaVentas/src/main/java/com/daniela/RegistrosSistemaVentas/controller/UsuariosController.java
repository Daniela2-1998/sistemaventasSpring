package com.daniela.RegistrosSistemaVentas.controller;

import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.UsuariosResponseDto;
import com.daniela.RegistrosSistemaVentas.service.IUsuariosService;
import com.daniela.RegistrosSistemaVentas.service.UsuariosServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;

    public UsuariosController(UsuariosServiceImp usuariosServiceImp) {
        this.usuariosService = usuariosServiceImp;
    }


    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<UsuariosResponseDto>> getAllUsuarios(){
        return new ResponseEntity<>(usuariosService.getAllUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosResponseDto> getUsuariosById(@PathVariable Long id){
        return new ResponseEntity<>(usuariosService.getUsuarioById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<UsuariosResponseDto> createUsuarios(@RequestBody @Valid UsuariosRequestDto usuariosRequestDto){
        return new ResponseEntity<>(usuariosService.addUsuario(usuariosRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<UsuariosResponseDto> updateUsuarios(@RequestBody @Valid UsuariosRequestConIdDto usuariosRequestConIdDto){
        return new ResponseEntity<>(usuariosService.editUsuario(usuariosRequestConIdDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeRespondeDto> deleteUsuarios(@PathVariable Long id){
        return new ResponseEntity<>(usuariosService.deleteUsuario(id), HttpStatus.OK);
    }
}
