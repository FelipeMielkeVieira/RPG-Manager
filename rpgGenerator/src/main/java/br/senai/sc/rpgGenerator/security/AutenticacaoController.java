//package br.senai.sc.rpgGenerator.security;
//
//import br.senai.sc.rpgGenerator.dto.UsuarioDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/login")
//public class AutenticacaoController {
//
//    @Autowired
//    private AutenticacaoService autenticacaoService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping
//    public ResponseEntity<Object> autenticacao(
//            @RequestBody @Valid UserDTO userDTO) {
//        try {
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getSenha());
//            Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//            String token = autenticacaoService.gerarToken(authentication);
//
//            return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO("Bearer", token));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//}
