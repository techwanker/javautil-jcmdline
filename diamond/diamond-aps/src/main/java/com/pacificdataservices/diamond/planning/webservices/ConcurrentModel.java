package com.pacificdataservices.diamond.planning.webservices;


/* lifted from org.springframework.ui.ConcurrentModel */

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.Conventions;
//import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Implementation of the {@link Model} interface based on a {@link ConcurrentHashMap}
 * for use in concurrent scenarios.
 *
 * <p>Exposed to handler methods by Spring WebFlux, typically via a declaration of the
 * {@link Model} interface. There is typically no need to create it within user code.
 * If necessary a handler method can return a regular {@code java.util.Map},
 * likely a {@code java.util.ConcurrentMap}, for a pre-determined model.
 *
 * @author Rossen Stoyanchev
 * @since 5.0
 */
@SuppressWarnings("serial")
public class ConcurrentModel extends ConcurrentHashMap<String, Object>  {

	/**
	 * Construct a new, empty {@code ConcurrentModel}.
	 */
	public ConcurrentModel() {
	}

	/**
	 * Construct a new {@code ModelMap} containing the supplied attribute
	 * under the supplied name.
	 * @see #addAttribute(String, Object)
	 */
	public ConcurrentModel(String attributeName, Object attributeValue) {
		addAttribute(attributeName, attributeValue);
	}

	/**
	 * Construct a new {@code ModelMap} containing the supplied attribute.
	 * Uses attribute name generation to generate the key for the supplied model
	 * object.
	 * @see #addAttribute(Object)
	 */
	public ConcurrentModel(Object attributeValue) {
		addAttribute(attributeValue);
	}


	@Override
	public Object put(String key, Object value) {
		if (value != null) {
			return super.put(key, value);
		}
		else {
			return remove(key);
		}
	}

	@Override
	public void putAll(Map<? extends String, ?> map) {
		for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Add the supplied attribute under the supplied name.
	 * @param attributeName the name of the model attribute (never {@code null})
	 * @param attributeValue the model attribute value (ignored if {@code null},
	 * just removing an existing entry if any)
	 */
	public ConcurrentModel addAttribute(String attributeName,  Object attributeValue) {
		Assert.notNull(attributeName, "Model attribute name must not be null");
		put(attributeName, attributeValue);
		return this;
	}

	/**
	 * Add the supplied attribute to this {@code Map} using a
	 * {@link org.springframework.core.Conventions#getVariableName generated name}.
	 * <p><i>Note: Empty {@link Collection Collections} are not added to
	 * the model when using this method because we cannot correctly determine
	 * the true convention name. View code should check for {@code null} rather
	 * than for empty collections as is already done by JSTL tags.</i>
	 * @param attributeValue the model attribute value (never {@code null})
	 */
	public ConcurrentModel addAttribute(Object attributeValue) {
		Assert.notNull(attributeValue, "Model attribute value must not be null");
		if (attributeValue instanceof Collection && ((Collection<?>) attributeValue).isEmpty()) {
			return this;
		}
		return addAttribute(Conventions.getVariableName(attributeValue), attributeValue);
	}

	/**
	 * Copy all attributes in the supplied {@code Collection} into this
	 * {@code Map}, using attribute name generation for each element.
	 * @see #addAttribute(Object)
	 */
	public ConcurrentModel addAllAttributes(Collection<?> attributeValues) {
		if (attributeValues != null) {
			for (Object attributeValue : attributeValues) {
				addAttribute(attributeValue);
			}
		}
		return this;
	}

	/**
	 * Copy all attributes in the supplied {@code Map} into this {@code Map}.
	 * @see #addAttribute(String, Object)
	 */
	public ConcurrentModel addAllAttributes(Map<String, ?> attributes) {
		if (attributes != null) {
			putAll(attributes);
		}
		return this;
	}

	/**
	 * Copy all attributes in the supplied {@code Map} into this {@code Map},
	 * with existing objects of the same name taking precedence (i.e. not getting
	 * replaced).
	 */
	public ConcurrentModel mergeAttributes(Map<String, ?> attributes) {
		if (attributes != null) {
			attributes.forEach((key, value) -> {
				if (!containsKey(key)) {
					put(key, value);
				}
			});
		}
		return this;
	}

	/**
	 * Does this model contain an attribute of the given name?
	 * @param attributeName the name of the model attribute (never {@code null})
	 * @return whether this model contains a corresponding attribute
	 */
	public boolean containsAttribute(String attributeName) {
		return containsKey(attributeName);
	}

	public Map<String, Object> asMap() {
		return this;
	}

}
