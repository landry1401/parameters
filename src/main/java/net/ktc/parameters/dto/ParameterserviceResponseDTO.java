package net.ktc.parameters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class ParameterserviceResponseDTO {

    private String id;
    private Boolean status;
    private Date creationDate;
    private Date endDate;

}
