package com.blogproject.springbootblogrestapi.payload;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(
        description = "ErrorDetails Model Information"
)
public class ErrorDetails {
    @Schema(
            description = "Error Timestamp"
    )
    private Date timestamp;
    @Schema(
            description = "Error Message"
    )
    private String message;
    @Schema(
            description = "Error Detail"
    )
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }


}
