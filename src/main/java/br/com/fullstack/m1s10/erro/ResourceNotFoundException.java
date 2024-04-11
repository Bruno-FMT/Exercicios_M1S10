package br.com.fullstack.m1s10.erro;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(
            String resource,
            String fieldName,
            Object fieldValue
    )
    {
        super(String.format(
                "%s não encontrado com %s : '%s'",
                resource, fieldName, fieldValue
        ));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
