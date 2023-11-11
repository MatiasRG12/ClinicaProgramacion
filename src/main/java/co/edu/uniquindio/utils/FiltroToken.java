package co.edu.uniquindio.utils;

import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
//@AllArgsConstructor
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        res.addHeader("Access-Control-Allow-Headers", "Origin, Accept, Content-Type, Authorization");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        if (req.getMethod().equals("OPTIONS")) {
            res.setStatus(HttpServletResponse.SC_OK);
        }else{
            String requestURI = req.getRequestURI();
            String token = getToken(req);
            boolean error = true;

            try{
                if (requestURI.startsWith("/inicioPaciente") || requestURI.startsWith("/inicioMedico") ||
                        requestURI.startsWith("/inicioAdmin")){
                    if (token != null) {
                        Jws<Claims> jws = jwtUtils.parseJwt(token);

                        if ((requestURI.startsWith("/inicioPaciente")&&!jws.getBody().get("rol").equals("paciente"))
                                ||(requestURI.startsWith("/inicioMedico")&&!jws.getBody().get("rol").equals("medico"))
                                ||(requestURI.startsWith("/inicioAdmin")&&!jws.getBody().get("rol").equals("admin"))){

                            crearRespuestaError("No tiene los permisos para acceder",HttpServletResponse.SC_FORBIDDEN,res);
                        }else{
                            error = false;
                        }
                    }else{
                        crearRespuestaError("No hay un Token",HttpServletResponse.SC_FORBIDDEN,res);
                    }
                }else {
                    error = false;
                }
            }catch (MalformedJwtException | SignatureException e){
                crearRespuestaError("El token es incorrecto", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
            }catch (ExpiredJwtException e ){
                crearRespuestaError("El token está vencido", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
            }catch (Exception e){
                crearRespuestaError(e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
            }
            if(!error){
                filterChain.doFilter(request, response);
            }
            filterChain.doFilter(request, response);

        }
    }


    private String getToken(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer "))
            return header.replace("Bearer ", "");
        return null;
    }

    private void crearRespuestaError(String mensaje, int codigoError, HttpServletResponse
            response) throws IOException {
        MensajeDTO<String> dto = new MensajeDTO<>(true, mensaje,null);
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(dto));
        response.getWriter().flush();
        response.getWriter().close();
    }

}
