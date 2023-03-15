package global.ntt.legstar.models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ApiError implements Serializable {
    private String message;
    private String errorCode;
}
