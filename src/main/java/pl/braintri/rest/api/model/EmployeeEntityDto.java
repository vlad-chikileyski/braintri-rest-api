package pl.braintri.rest.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeEntityDto {

	@ApiModelProperty(notes = "The database generated employee ID", hidden = true)
	private Long id;

	@ApiModelProperty(notes = "The employee name", example = "Vladislav")
	private String name;

	@ApiModelProperty(notes = "The employee lastname",example = "Chikileyski")
	private String lastname;

	@ApiModelProperty(notes = "The employee position", example = "Java Software Developer")
	private String position;

	@ApiModelProperty(notes = "The employee email address", example = "vlad.chikileyski@gmail.com")
	private String email;

	@ApiModelProperty(notes = "The auto-generated date create value of the employee" , hidden = true)
	private Date dateCreate;

	@ApiModelProperty(notes = "The auto-generated last updated value of the employee", hidden = true)
	private Date lastUpdated;
}
