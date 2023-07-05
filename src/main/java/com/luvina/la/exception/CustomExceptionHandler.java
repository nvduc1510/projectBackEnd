/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * CustomExceptionHandler.java, July 5, 2023 nvduc
 */
package com.luvina.la.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* Xử lý ngoại lệ
* @author nvduc
*/

@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * Xử lý ngoại lệ DatabaseException.
     *
     * @param ex Ngoại lệ DatabaseException
     * @return Phản hồi (response) lỗi với thông báo và trạng thái 500 (Lỗi máy chủ)
     */
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<String> handleDatabaseException(DatabaseException ex) {
        String errorMessage = "システムエラーが発生しました。:" + ex.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
    /**
     * Xử lý ngoại lệ NotFoundException.
     * @param ex Ngoại lệ NotFoundException
     * @return Phản hồi (response) lỗi với thông báo và trạng thái 500 (Lỗi máy chủ)
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handNotFoundException(NotFoundException ex){
        String errorMessage = "「画面項目名」は存在していません。:" + ex.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    /**
     * Xử lý ngoại lệ YourCustomException.
     * @param ex Ngoại lệ YourCustomException
     * @return Phản hồi (response) lỗi với thông báo và trạng thái 500 (Lỗi máy chủ)
     */
    @ExceptionHandler(YourCustomException.class)
    public ResponseEntity<String> handleDatabaseException(YourCustomException ex) {
        String errorMessage = "システムエラーが発生しました。:" + ex.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
