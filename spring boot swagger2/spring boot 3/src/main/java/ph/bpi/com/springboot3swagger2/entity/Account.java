package ph.bpi.com.springboot3swagger2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String id;
    private String name;
    private String number;
    private String address;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
}
