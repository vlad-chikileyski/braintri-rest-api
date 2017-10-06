package pl.braintri.rest.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@ToString
public class FilterSearchCriteriaDto {

	@ApiModelProperty(notes = "Which field to search", example = "name")
	private String searchType;
	@ApiModelProperty(notes = "Search criteria", example = "[\"Vladislav\"]")
	private List<String> searchParams;
	@ApiModelProperty(notes = "Sort by for ex:  name", example = "lastname")
	private String sortBy;
}
