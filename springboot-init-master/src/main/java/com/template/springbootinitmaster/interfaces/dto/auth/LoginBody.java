package com.template.springbootinitmaster.interfaces.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LoginBody implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String grantType;


}
