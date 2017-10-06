package pl.braintri.rest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.braintri.rest.api.model.FilterType;
import pl.braintri.rest.api.model.EmployeeEntityDto;
import pl.braintri.rest.api.model.FilterSearchCriteriaDto;
import pl.braintri.rest.api.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/braintri/rest/api")
@Api(value = "management", description = "Operations related to the management of employees in the firm")
public class EmployeeController {

	@Autowired private EmployeeService employeeService;

	@ApiOperation(value = "View a list of employees", response = List.class, position = 3)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/all", produces = "application/json")
	public List<EmployeeEntityDto> findAll() {
		return employeeService.findAll();
	}

	@ApiOperation(value = "Add a employee", position = 0)
	@PostMapping(value = "/create")
	public ResponseEntity createEmployee(@Valid @RequestBody EmployeeEntityDto employee) {
		employeeService.save(employee);
		return new ResponseEntity("Employee created successfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update a employee information", position = 1)
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeeEntityDto> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody EmployeeEntityDto employeeDto) {
		final EmployeeEntityDto resultDto = employeeService.findOne(employeeId);
		if (resultDto == null) {
			return ResponseEntity.notFound().build();
		}
		resultDto.setId(employeeId);
		resultDto.setName(employeeDto.getName() != null ? employeeDto.getName() : null);
		resultDto.setLastname(employeeDto.getLastname() != null ? employeeDto.getLastname() : null);
		resultDto.setEmail(employeeDto.getEmail() != null ? employeeDto.getEmail() : null);
		resultDto.setPosition(employeeDto.getPosition() != null ? employeeDto.getPosition() : null);
		employeeService.save(resultDto);
		return new ResponseEntity("Employee updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete employee", position = 2)
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<EmployeeEntityDto> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		final EmployeeEntityDto resultDto = employeeService.findOne(employeeId);
		if (resultDto == null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.delete(employeeId);
		return new ResponseEntity("Employee deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Search a employee with filters", position = 4)
	@PostMapping(value = "/filter", produces = "application/json")
	public ResponseEntity<List<EmployeeEntityDto>> findByIds(@RequestBody FilterSearchCriteriaDto searchCriteriaDto) {
		if (!FilterType.parse(searchCriteriaDto.getSearchType()).isPresent()) {
			return new ResponseEntity("Search type not valid", HttpStatus.BAD_REQUEST);
		}
		List<EmployeeEntityDto> result = employeeService.findByCriteria(searchCriteriaDto);
		return ResponseEntity.ok(result);
	}
}
