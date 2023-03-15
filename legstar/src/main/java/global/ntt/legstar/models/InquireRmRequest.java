package global.ntt.legstar.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class InquireRmRequest implements Serializable {
    private String customerControl1;
    private String customerControl2;
    private String customerControl3;
    private String customerControl4;
    private String customerRmNumber;

}
