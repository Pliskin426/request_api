package com.cultfilminreview.requestApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.cultfilminreview.requestApi.entity.Request;

public interface RequestRepository extends CrudRepository<Request,Long> {

}
