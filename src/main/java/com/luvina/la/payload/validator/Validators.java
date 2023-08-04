/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 19, 2023 nvduc
 */
package com.luvina.la.payload.validator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
/**
*Xu ly cac validate cho man ADD
* @author nvduc
*/
@Component
public class Validators {
    /**
     * Xác thực ID đăng nhập của nhân viên.
     * @param loginId ID đăng nhập cần xác thực.
     * @return ID đăng nhập đã được xác thực.
     * @throws ValidatorsException nếu ID đăng nhập không hợp lệ.
     */
    public String validEmployeeLoginId(String loginId) throws ValidatorsException {
        // Biểu thức chính quy để kiểm tra ID đăng nhập: Bắt đầu bằng một chữ cái, tiếp theo là các ký tự chữ số hoặc chữ cái, tối đa 50 ký tự.
        String reg = "^[^0-9][a-zA-Z0-9]{1,50}$";
        List<String> params = new ArrayList<>();
        params.add("アカウント名");
        if (loginId == null) {
            throw new ValidatorsException("ER001", params); // Ném ngoại lệ nếu ID đăng nhập là null.
        }
        if (loginId.length() > 50) {
            throw new ValidatorsException("ER006", params); // Ném ngoại lệ nếu ID đăng nhập quá dài.
        }
        // Kiểm tra định dạng của ID đăng nhập bằng biểu thức chính quy.
        if (!loginId.matches(reg)) {
            throw new ValidatorsException("ER019", params); // Ném ngoại lệ nếu định dạng ID đăng nhập không hợp lệ.
        }
        return loginId;
    }
    /**
     * Xác thực tên đầy đủ của nhân viên.
     * @param name Tên của nhân viên cần xác thực.
     * @return Tên của nhân viên đã được xác thực.
     * @throws ValidatorsException nếu tên không hợp lệ.
     */
    public String validEmployeeName(String name) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("氏名");
        if (name == null || name.isEmpty()) {
            throw new ValidatorsException("ER001", params); // Ném ngoại lệ nếu tên là null hoặc rỗng.
        }
        if (name.length() > 125) {
            throw new ValidatorsException("ER006", params); // Ném ngoại lệ nếu tên quá dài.
        }
        return name;
    }

    /**
     * Xác thực tên viết bằng Katakana.
     * @param nameKatakana Tên viết bằng Katakana cần xác thực.
     * @return Tên viết bằng Katakana đã được xác thực.
     * @throws ValidatorsException nếu tên viết bằng Katakana không hợp lệ.
     */
    public String validNameKatakana(String nameKatakana) throws ValidatorsException {
        // Biểu thức chính quy để kiểm tra các ký tự Katakana.
        String reg = "^[\\u30A0-\\u30FFー]+$";
        List<String> params = new ArrayList<>();
        params.add("カタカナ氏名");
        if (nameKatakana == null || nameKatakana.isEmpty()) {
            throw new ValidatorsException("ER001", params); // Ném ngoại lệ nếu tên viết bằng Katakana là null hoặc rỗng.
        }
        if (nameKatakana.length() > 125) {
            throw new ValidatorsException("ER006", params); // Ném ngoại lệ nếu tên viết bằng Katakana quá dài.
        }
        // Kiểm tra định dạng của tên viết bằng Katakana bằng biểu thức chính quy.
        if (!nameKatakana.matches(reg)) {
            throw new ValidatorsException("ER009", params); // Ném ngoại lệ nếu định dạng tên viết bằng Katakana không hợp lệ.
        }
        return nameKatakana;
    }

    /**
     * Xác thực ngày sinh của nhân viên.
     * @param startDateStr Chuỗi ngày sinh cần xác thực.
     * @return Ngày sinh đã được xác thực.
     * @throws ValidatorsException nếu ngày sinh không hợp lệ.
     */
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

    /**
     * Xác thực địa chỉ email của nhân viên.
     * @param email Địa chỉ email cần xác thực.
     * @return Địa chỉ email đã được xác thực.
     * @throws ValidatorsException nếu địa chỉ email không hợp lệ.
     */
    public String validateEmail(String email) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("メールアドレス");
        if (email == null || email.isEmpty()) {
            throw new ValidatorsException("ER001", params); // Ném ngoại lệ nếu địa chỉ email là null hoặc rỗng.
        }
        if (email.length() > 125) {
            throw new ValidatorsException("ER006", params); // Ném ngoại lệ nếu địa chỉ email quá dài.
        }
        return email;
    }

    /**
     * Xác thực số điện thoại của nhân viên.
     * @param phoneNumber Số điện thoại cần xác thực.
     * @return Số điện thoại đã được xác thực.
     * @throws ValidatorsException nếu số điện thoại không hợp lệ.
     */
    public String validatePhoneNumber(String phoneNumber) throws ValidatorsException {
        List<String> params = new ArrayList<>();
        params.add("電話番号");
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new ValidatorsException("ER001", params); // Ném ngoại lệ nếu số điện thoại là null hoặc rỗng.
        }
        if (phoneNumber.length() > 50) {
            throw new ValidatorsException("ER006", params); // Ném ngoại lệ nếu số điện thoại quá dài.
        }
        return phoneNumber;
    }

    /**
     * Xác thực ID của bộ phận.
     * @param departmentIdStr Chuỗi ID bộ phận cần xác thực.
     * @return ID của bộ phận đã được xác thực.
     * @throws ValidatorsException nếu ID bộ phận không hợp lệ.
     */
    public long validateDepartmentId(String departmentIdStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("グループ");
        // Kiểm tra null
        if (departmentIdStr == null || departmentIdStr.isEmpty()) {
            throw new ValidatorsException("ER002", params); // Ném ngoại lệ nếu ID bộ phận là null hoặc rỗng.
        }
        if (!departmentIdStr.matches(reg)) {
            throw new ValidatorsException("ER018", params); // Ném ngoại lệ nếu ID bộ phận không hợp lệ.
        }
        long departmentId = Long.valueOf(departmentIdStr);
        return departmentId;
    }

    /**
     * Xác thực mật khẩu của nhân viên.
     * @param password Mật khẩu cần xác thực.
     * @return Mật khẩu đã được xác thực và đã được mã hóa.
     * @throws ValidatorsException nếu mật khẩu không hợp lệ.
     */
    public String validatePassword(String password) throws ValidatorsException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<String> params = new ArrayList<>();
        params.add("パスワード");
        // Kiểm tra null
        if (password == null || password.isEmpty()) {
            throw new ValidatorsException("ER002", params); // Ném ngoại lệ nếu mật khẩu là null hoặc rỗng.
        }
        if (password.length() < 8 || password.length() > 50) {
            params.add("8");
            params.add("50");
            throw new ValidatorsException("ER007", params); // Ném ngoại lệ nếu mật khẩu không đủ dài hoặc quá dài.
        }
        return passwordEncoder.encode(password);
    }

    /**
     * Xác thực ID của chứng chỉ.
     * @param certificationIdStr Chuỗi ID chứng chỉ cần xác thực.
     * @return ID của chứng chỉ đã được xác thực.
     * @throws ValidatorsException nếu ID chứng chỉ không hợp lệ.
     */
    public long validateCertificationId(String certificationIdStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("資格");
        // Kiểm tra null
        if (certificationIdStr == null || certificationIdStr.isEmpty()) {
            throw new ValidatorsException("ER002", params); // Ném ngoại lệ nếu ID chứng chỉ là null hoặc rỗng.
        }
        if (!certificationIdStr.matches(reg)) {
            throw new ValidatorsException("ER018", params); // Ném ngoại lệ nếu ID chứng chỉ không hợp lệ.
        }
        long certificationId = Long.valueOf(certificationIdStr);
        return certificationId;
    }


    /**
     * Xác thực điểm số.
     * @param scoreStr Chuỗi điểm số cần xác thực.
     * @return Điểm số đã được xác thực dưới dạng BigDecimal.
     * @throws ValidatorsException nếu điểm số không hợp lệ.
     */
    public BigDecimal validateScore(String scoreStr) throws ValidatorsException {
        String reg = "^[1-9]\\d*$";
        List<String> params = new ArrayList<>();
        params.add("点数");
        // Kiểm tra null
        if (scoreStr == null || scoreStr.isEmpty()) {
            throw new ValidatorsException("ER002", params); // Ném ngoại lệ nếu điểm số là null hoặc rỗng.
        }
        if (!scoreStr.matches(reg)) {
            throw new ValidatorsException("ER018", params); // Ném ngoại lệ nếu điểm số không hợp lệ.
        }
        BigDecimal score = BigDecimal.valueOf(Long.parseLong(scoreStr));
        return score;
    }

    /**
     * Xác thực ngày bắt đầu theo định dạng yyyy/MM/dd.
     * @param startDateStr Chuỗi ngày bắt đầu cần xác thực.
     * @return Ngày bắt đầu đã được xác thực.
     * @throws ValidatorsException nếu ngày không hợp lệ hoặc định dạng sai.
     */
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

    /**
     * Xác thực ngày kết thúc theo định dạng yyyy/MM/dd và so sánh với ngày bắt đầu.
     * @param endDateStr Chuỗi ngày kết thúc cần xác thực.
     * @param startDate Ngày bắt đầu cần so sánh.
     * @return Ngày kết thúc đã được xác thực và lớn hơn ngày bắt đầu.
     * @throws ValidatorsException nếu ngày kết thúc không hợp lệ hoặc định dạng sai, hoặc nếu ngày kết thúc nhỏ hơn hoặc bằng ngày bắt đầu.
     */
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
            throw new ValidatorsException("ER012", new ArrayList<>()); // Ném ngoại lệ nếu ngày kết thúc nhỏ hơn hoặc bằng ngày bắt đầu.
        }
        return endDate;
    }


    /**
     * Xác thực ngày theo định dạng yyyy/MM/dd.
     * @param dateStr Chuỗi ngày cần xác thực.
     * @return Ngày đã được xác thực.
     * @throws ValidatorsException nếu ngày không hợp lệ hoặc định dạng sai.
     */
    private LocalDate validDate(String dateStr) throws ValidatorsException {
        String reg = "\\d{4}/\\d{2}/\\d{2}";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date;
        // Kiểm tra null
        if (dateStr == null || dateStr.isEmpty()) {
            throw new ValidatorsException("ER001"); // Ném ngoại lệ nếu ngày là null hoặc rỗng.
        }
        if (!dateStr.matches(reg)) {
            throw new ValidatorsException("ER005"); // Ném ngoại lệ nếu định dạng ngày không hợp lệ.
        }
        try {
            date = LocalDate.parse(dateStr, dateFormat); // Chuyển đổi chuỗi ngày thành đối tượng LocalDate.
        } catch (DateTimeParseException e) {
            throw new ValidatorsException("ER011"); // Ném ngoại lệ nếu chuỗi ngày không thể chuyển đổi thành ngày hợp lệ.
        }
        return date;
    }

}
