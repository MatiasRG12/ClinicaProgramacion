package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.extrasDTOs.LoginDTO;
import co.edu.uniquindio.dto.extrasDTOs.TokenDTO;
import co.edu.uniquindio.modelo.entidades.Medico;
import co.edu.uniquindio.modelo.entidades.Paciente;
import co.edu.uniquindio.modelo.entidades.Usuario;
import co.edu.uniquindio.repositorios.UsuarioRepo;
import co.edu.uniquindio.servicios.interfaces.ServicioAutenticacion;
import co.edu.uniquindio.utils.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("ServicioAutenticacion")
@AllArgsConstructor
public class ServicioAutenticacionImpl implements ServicioAutenticacion {

    private final UsuarioRepo usuarioRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> cuentaOptional = usuarioRepo.findByEmail(loginDTO.correo());
        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }
        Usuario usuario = cuentaOptional.get();
        if( !encoder.matches(loginDTO.contrasenia(), usuario.getContrasenia())){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO( crearToken(usuario) );
    }

    private String crearToken(Usuario usuario){
        String rol;
        String nombre;
        if( usuario instanceof Paciente){
            rol = "paciente";
            nombre = ((Paciente) usuario).getNombre();
        }else if( usuario instanceof Medico){
            rol = "medico";
            nombre = ((Medico) usuario).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", usuario.getCodigo());
        return jwtUtils.generarToken(usuario.getEmail(), map);
    }

}
