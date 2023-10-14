package co.edu.uniquindio.servicios.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public interface ServicioImagenes {

    Map subirImagen(MultipartFile imagen) throws Exception;
    Map eliminarImagen(String idImagen) throws Exception;

}
