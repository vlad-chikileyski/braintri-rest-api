package pl.braintri.rest.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by EO NETWORKS on 02.10.2017.
 */
@AllArgsConstructor
@Getter
public enum FilterType {
	DEFAULT_FILTER_BY_ID("id"), FILTER_BY_NAME("name"), FILTER_BY_LASTNAME("lastname"), FILTER_BY_POSITION("position"), FILTER_BY_EMAIL("email");

	private String code;

	public static Optional<FilterType> parse(String code) {
		return Stream.of(FilterType.values()).filter( e -> e.getCode().equals(code)).findFirst();
	}
}
