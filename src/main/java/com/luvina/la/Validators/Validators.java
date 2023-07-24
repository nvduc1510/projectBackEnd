package com.luvina.la.Validators;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Validators {
    public String validEmployeeLoginId(String loginId) throws ValidatorsException {
        String reg = "^[^0-9][a-zA-Z0-9]{1,50}$";
        List<String> params = new ArrayList<>();
        params.add("アカウント名");
        // kiem tra null
        if (loginId == null) {
            throw new ValidatorsException("ER001", params);
        }
        // kiem tra chieu dai
        if (loginId.length() > 50) {
            throw new ValidatorsException("ER006", params);
        }
        // kiem tra dinh dang
        if (!loginId.matches(reg)) {
            throw new ValidatorsException("ER019", params);
        }
        return loginId;
    }
    public String validEmployeeName(String name) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("氏名");
        // kt null
        if (name == null || name.isEmpty()) {
            throw new ValidatorsException("ER001", params);
        }
        // kt length
        if (name.length() > 125) {
            throw new ValidatorsException("ER006", params);
        }
        return name;
    }

    // Validate nameKatakana: kt null, length, format
    public String validNameKatakana(String nameKatakana) throws ValidatorsException {
        String reg = "^[\\u30A0-\\u30FFー]+$";
        List<String> params = new ArrayList<>();
        params.add("カタカナ氏名");
        // kt null
        if (nameKatakana == null || nameKatakana.isEmpty()) {
            throw new ValidatorsException("ER001", params);
        }
        // kt length
        if (nameKatakana.length() > 125) {
            throw new ValidatorsException("ER006", params);
        }
        // kt katakana
        if (!nameKatakana.matches(reg)) {
            throw new ValidatorsException("ER009", params);
        }
        return nameKatakana;
    }

    //Validator EmployeeBirthDate
    public LocalDate validateBirthDay(String startDateStr) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("生年月日");
        LocalDate date;
        try {
            date = this.validDate(startDateStr);
        } catch (ValidatorsException exception) {
            if (exception.getCode().equals("ER005")) {
                params.add("yyyy/MM/dd");
            }
            exception.setParams(params);
            throw exception;
        }
        return date;
    }

    // validate email
    public String validateEmail(String email) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("メールアドレス");
        //kt null
        if (email == null || email.isEmpty()) {
            throw new ValidatorsException("ER001", params);
        }
        // kt length
        if (email.length() > 125) {
            throw new ValidatorsException("ER006", params);
        }
        return email;
    }

    // validate phone
    public String validatePhoneNumber(String phoneNumber) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("電話番号");
        //kt null
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new ValidatorsException("ER001", params);
        }
        // kt length
        if (phoneNumber.length() > 50) {
            throw new ValidatorsException("ER006", params);
        }
        return phoneNumber;
    }

    // validate departmentId
    public long validateDepartmentId(String departmentIdStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("グループ");
        //kt null
        if (departmentIdStr == null || departmentIdStr.isEmpty()) {
            throw new ValidatorsException("ER002", params);
        }
        if (!departmentIdStr.matches(reg)) {
            throw new ValidatorsException("ER018", params);
        }
        long departmentId = Long.valueOf(departmentIdStr);
        return departmentId;
    }

    // validate Password
    public String validatePassword(String password) throws ValidatorsException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<String> params = new ArrayList<>();
        params.add("パスワード");
        //kt null
        if (password == null || password.isEmpty()) {
            throw new ValidatorsException("ER002", params);
        }
        if (password.length() < 8 || password.length() > 50) {
            params.add("8");
            params.add("50");
            throw new ValidatorsException("ER007", params);
        }
        return passwordEncoder.encode(password);
    }

    // validate certificationId
    public long validateCertificationId(String certificationIdStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("資格");
        //kt null
        if (certificationIdStr == null || certificationIdStr.isEmpty()) {
            throw new ValidatorsException("ER002", params);
        }
        if (!certificationIdStr.matches(reg)) {
            throw new ValidatorsException("ER018", params);
        }
        long certificationId = Long.valueOf(certificationIdStr);
        return certificationId;
    }

    // validate Score
    public BigDecimal validateScore(String scoreStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("点数");
        //kt null
        if (scoreStr == null || scoreStr.isEmpty()) {
            throw new ValidatorsException("ER002", params);
        }
        if (!scoreStr.matches(reg)) {
            throw new ValidatorsException("ER018", params);
        }
        BigDecimal score = BigDecimal.valueOf(Long.parseLong(scoreStr));
        return score;
    }

    //validate StartDate
    public LocalDate validateStartDate(String startDateStr) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("資格交付日");
        LocalDate date;
        try {
            date = this.validDate(startDateStr);
        } catch (ValidatorsException exception) {
            if (exception.getCode().equals("ER005")) {
                params.add("yyyy/MM/dd");
            }
            exception.setParams(params);
            throw exception;
        }
        return date;
    }

    //validate endDate
    public LocalDate validateEndDate(String endDateStr, LocalDate startDate) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("失効日");
        LocalDate endDate;
        try {
            endDate = this.validDate(endDateStr);
        } catch (ValidatorsException exception) {
            if (exception.getCode().equals("ER005")) {
                params.add("yyyy/MM/dd");
            }
            exception.setParams(params);
            throw exception;
        }
        if (endDate.compareTo(startDate) <= 0) {
            throw new ValidatorsException("ER012", new ArrayList<>());
        }
        return endDate;
    }

    private LocalDate validDate(String dateStr) throws ValidatorsException {
        String reg = "\\d{4}/\\d{2}/\\d{2}";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date;
        //kt null
        if (dateStr == null || dateStr.isEmpty()) {
            throw new ValidatorsException("ER001");
        }
        // kt format
        if (!dateStr.matches(reg)) {
            throw new ValidatorsException("ER005");
        }
        // tk ngay hop le
        try {
            date = LocalDate.parse(dateStr, dateFormat);
        } catch (DateTimeParseException e) {// bắt lỗi dateStr đúng định dạng nhưng ngày tháng không hợp lệ
            throw new ValidatorsException("ER011");
        }
        return date;
    }
}
