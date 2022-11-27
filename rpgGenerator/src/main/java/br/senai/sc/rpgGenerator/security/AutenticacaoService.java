//package br.senai.sc.rpgGenerator.security;
//
//import br.senai.sc.rpgGenerator.model.entities.Usuario;
//import br.senai.sc.rpgGenerator.repository.UsuarioRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class AutenticacaoService implements UserDetailsService {
//
//    private final String senhaForte = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(username);
//        if (usuarioOptional.isPresent()) {
//            return usuarioOptional.get();
//        }
//        throw new UsernameNotFoundException("Usuário não encontrado!");
//    }
//
//    public String gerarToken(Authentication authentication) {
//        Usuario usuario = (Usuario) authentication.getPrincipal();
//        return Jwts.builder()
//                .setIssuer("RPG Manager")
//                .setSubject(usuario.getEmail().toString())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + 18000000))
//                .signWith(SignatureAlgorithm.HS256, senhaForte)
//                .compact();
//    }
//
//    public Boolean validarToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(senhaForte).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Usuario getUsuario(String token) {
//        String email = (Jwts.parser()
//                .setSigningKey(senhaForte)
//                .parseClaimsJws(token)
//                .getBody().getSubject());
//        return usuarioRepository.findByEmail(email).get();
//    }
//}
