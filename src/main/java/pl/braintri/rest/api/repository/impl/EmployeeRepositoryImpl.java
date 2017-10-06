package pl.braintri.rest.api.repository.impl;

import com.google.common.primitives.Longs;
import pl.braintri.rest.api.model.EmployeeEntity;
import pl.braintri.rest.api.model.FilterSearchCriteriaDto;
import pl.braintri.rest.api.repository.EmployeeRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@PersistenceContext EntityManager entityManager;

	private static final String EMPLOYEE_SEARCH_NATIVE_QUERY_DATA_SELECT_PART = "SELECT emp FROM EmployeeEntity emp";

	@Override
	public List<EmployeeEntity> findByCriteria(FilterSearchCriteriaDto searchCriteriaDto) {
		StringBuilder queryBuilder = new StringBuilder(EMPLOYEE_SEARCH_NATIVE_QUERY_DATA_SELECT_PART);
		if (!searchCriteriaDto.getSearchParams().isEmpty()) {
			queryBuilder.append(" WHERE " + searchCriteriaDto.getSearchType() + " IN :values ORDER BY :sortBy");
		}
		Query query = entityManager.createQuery(queryBuilder.toString());
		query.setParameter("values", searchCriteriaDto.getSearchParams());
		query.setParameter("sortBy", searchCriteriaDto.getSortBy());
		List<EmployeeEntity> resultList = query.getResultList();
		return resultList;

	}
}
