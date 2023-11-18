package co.edu.uniquindio.controladores;

import co.edu.uniquindio.dto.extrasDTOs.ImagenDTO;
import co.edu.uniquindio.dto.extrasDTOs.MensajeDTO;
import co.edu.uniquindio.servicios.interfaces.ServicioImagenes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/imagenes")
public class ControllerImagenes {

    private final ServicioImagenes servicioImagenes;

    @PostMapping("/subir")
    public ResponseEntity<MensajeDTO<Map>> subir(@RequestParam("file") MultipartFile imagen) throws Exception{
        Map respuesta = servicioImagenes.subirImagen(imagen);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "", respuesta));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO<Map>> eliminar(@RequestBody ImagenDTO imagenDTO) throws Exception{
        Map respuesta = servicioImagenes.eliminarImagen( imagenDTO.id() );
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"",respuesta ));
    }
}
