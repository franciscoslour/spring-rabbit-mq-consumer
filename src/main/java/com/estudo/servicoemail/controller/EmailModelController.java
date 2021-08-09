package com.estudo.servicoemail.controller;

import com.estudo.servicoemail.dto.EmailModelDto;
import com.estudo.servicoemail.model.EmailModel;
import com.estudo.servicoemail.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailModelController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/send-email")
    public ResponseEntity<EmailModel> sendEmail(@Valid @RequestBody EmailModelDto emailModelDto){

        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailModelDto,emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.ACCEPTED);


    }

}
