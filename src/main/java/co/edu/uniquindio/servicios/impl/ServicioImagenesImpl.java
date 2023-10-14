package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.servicios.interfaces.ServicioImagenes;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service("ServicioImagenes")
@AllArgsConstructor
public class ServicioImagenesImpl implements ServicioImagenes {

    private final Cloudinary cloudinary;

    public ServicioImagenesImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dh2astwoy");
        config.put("api_key", "925797329296596");
        config.put("api_secret", "4MTVPTgtpgXKttozqvnruceyySE");

        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(MultipartFile imagen) throws Exception {
        File file = convertir(imagen);
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "co/edu/uniquindio/imagenes"));
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }

    private File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }

}
