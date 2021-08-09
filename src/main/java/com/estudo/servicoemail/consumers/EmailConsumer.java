package com.estudo.servicoemail.consumers;

import com.estudo.servicoemail.dto.EmailModelDto;
import com.estudo.servicoemail.model.EmailModel;
import com.estudo.servicoemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailModelDto emailModelDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailModelDto,emailModel);
        emailService.sendEmail(emailModel);
    }

}
