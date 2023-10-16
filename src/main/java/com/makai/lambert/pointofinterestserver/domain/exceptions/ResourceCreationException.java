package com.makai.lambert.pointofinterestserver.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceCreationException  extends RuntimeException{
    public ResourceCreationException(String message) {super(message);}

    }


