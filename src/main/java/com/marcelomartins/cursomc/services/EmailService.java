package com.marcelomartins.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.marcelomartins.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
