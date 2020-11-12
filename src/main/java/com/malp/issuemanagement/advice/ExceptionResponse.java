package com.malp.issuemanagement.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor // generates ctor with all props
@NoArgsConstructor // generates ctor with no args
public class ExceptionResponse {
    private Date date;
    private String message;
}
