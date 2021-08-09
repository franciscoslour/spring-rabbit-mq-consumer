package com.estudo.servicoemail.repository;

import com.estudo.servicoemail.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailModelRepository extends JpaRepository<EmailModel, UUID> {
}
