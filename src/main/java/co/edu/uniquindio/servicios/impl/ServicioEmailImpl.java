package co.edu.uniquindio.servicios.impl;

import co.edu.uniquindio.dto.extrasDTOs.EmailDTO;
import co.edu.uniquindio.servicios.interfaces.ServicioEmail;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("ServicioEmail")
@AllArgsConstructor
public class  ServicioEmailImpl implements ServicioEmail {

    private final JavaMailSender javaMailSender;

    @Override
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.mensaje(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("no_reply@dominio.com");

        javaMailSender.send(mensaje);
    }
}
