package pl.braintri.rest.api.repository;

import pl.braintri.rest.api.model.EmployeeEntity;
import pl.braintri.rest.api.model.FilterSearchCriteriaDto;

import java.util.List;

public interface EmployeeRepositoryCustom {

	List<EmployeeEntity> findByCriteria(FilterSearchCriteriaDto searchCriteriaDto);

}
