package com.pacificdataservices.diamond.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.pacificdataservices.diamond.models.IcItemMast;

/**
 * https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/jpa.repositories.html
 * @author jjs
 *
 */

public interface IcItemMastRepository extends Repository<IcItemMast, Long>,
		CrudRepository<IcItemMast,Long>{


}
