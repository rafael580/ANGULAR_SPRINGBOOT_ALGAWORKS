package com.example.fullapimoney.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends  StandardError{

    private static final Long serialVersionUID = 1L;

    private List<FieldMessage> erros = new ArrayList<>();


    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String Message){
        this.erros.add(new FieldMessage(fieldName,Message));
    }
}