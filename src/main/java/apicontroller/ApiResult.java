package apicontroller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiResult {
    SUCCESS(200, "Success"),
    INVALID_REQUEST(201, "Invalid request"),
    INVALID_BALANCE(202, "Invalid balance value"),
    ACCOUNT_NOT_FOUND(203, "Account is not founded"),
    ACCOUNT_ALREADY_EXIST(204, "Account is already exists"),
    INSUFFICIENT_FUNDS(205, "Insufficient balance"),
    CURRENCY_DOES_NOT_MATCH(206, "Currencies does not match"),
    INVALID_AMOUNT(2007, "Invalid amount value"),
    TRANSFER_EQUAL_ACCOUNTIDS(208, "Account ids are same"),
    INVALID_CURRENCY(209, "Invalid currency type"),
    SYSTEM_ERROR(404, "System error");

    private int status;
    private String description;

    ApiResult(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String toJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "";
        }
    }
}
