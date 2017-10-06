package pl.braintri.rest.api.restapi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.braintri.rest.api.model.EmployeeEntityDto;
import pl.braintri.rest.api.model.FilterSearchCriteriaDto;
import pl.braintri.rest.api.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplicationTests {

	@Autowired EmployeeService employeeService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void shouldFindByCriteria() {
		FilterSearchCriteriaDto searchCriteriaDto = new FilterSearchCriteriaDto();
		List<String> params = new ArrayList<String>();
		params.add("Vlad");
		params.add("Vladislav");
		params.add("Vladyslav");
		searchCriteriaDto.setSearchParams(params);
		searchCriteriaDto.setSearchType("name");
		searchCriteriaDto.setSortBy("lastname");
		List<EmployeeEntityDto> list = employeeService.findByCriteria(searchCriteriaDto);
		Assert.assertEquals(0, list.size());
	}

}
