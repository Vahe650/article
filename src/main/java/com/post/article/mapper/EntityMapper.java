package com.post.article.mapper;

import java.util.List;

/**
 * Интерфейс маппинга DTO на Entity.
 *
 * @param <D> DTO.
 * @param <E> Entity.
 * @author durdyev
 */
public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}