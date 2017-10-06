package pl.braintri.rest.api.service;

import pl.braintri.rest.api.model.EmployeeEntity;
import pl.braintri.rest.api.model.EmployeeEntityDto;
import pl.braintri.rest.api.model.FilterSearchCriteriaDto;

import java.util.List;

public interface EmployeeService {

	List<EmployeeEntityDto> findByCriteria(FilterSearchCriteriaDto searchCriteriaDto);

	List<EmployeeEntityDto> findAll();

	void save(EmployeeEntityDto employeeEntityDto);

	EmployeeEntityDto findOne(Long employeeId);

	void delete(Long employeeId);
}
