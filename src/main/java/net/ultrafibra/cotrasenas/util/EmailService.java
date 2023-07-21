package net.ultrafibra.cotrasenas.util;

import lombok.extern.slf4j.Slf4j;
import net.ultrafibra.cotrasenas.excepciones.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
   public void enviarEmail(String destino, String asunto, String cuerpo) {
    try {
        SimpleMailMessage mensage = new SimpleMailMessage();
        mensage.setTo(destino);
        mensage.setSubject(asunto);
        mensage.setText(cuerpo);
        mailSender.send(mensage);
    } catch (Exception e) {
        throw new EmailException("Error al enviar el correo electrónico.", e);
    }
}

}
