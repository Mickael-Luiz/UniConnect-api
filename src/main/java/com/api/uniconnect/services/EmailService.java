package com.api.uniconnect.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailConfirmacaoHtml(String destino, String token) throws MessagingException {
        String assunto = "Confirmação de Cadastro - UniConnect";

        String corpo = "<html>" +
                "<body>" +
                "<h2>Bem-vindo ao UniConnect!</h2>" +
                "<p>Por favor, clique no link abaixo para confirmar seu cadastro:</p>" +
                "<a href='http://localhost:4200/registrar/confirmar?token=" + token + "'>Confirmar cadastro</a>" +
                "<p>Esse link expira em 1 hora.</p>" +
                "</body>" +
                "</html>";

        MimeMessage mensagem = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true, "UTF-8");

        helper.setTo(destino);
        helper.setSubject(assunto);
        helper.setText(corpo, true);
        helper.setFrom("seu-email@gmail.com");

        mailSender.send(mensagem);
    }
}
