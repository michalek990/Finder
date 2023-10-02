package com.example.finder.Exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    @NotBlank
    private String code;

    @NotBlank
    private String message;

    @NotNull
    private Integer status;

    @SneakyThrows
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    public static ErrorResponse errBuild(String code, String message, Integer status) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .status(status)
                .build();
    }
}
