package com.doraemon.dal.impl;

import com.doraemon.dal.BaseDAO;
import org.jooq.*;
import org.jooq.impl.DAOImpl;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.util.Assert;

import java.util.List;

public abstract class BaseDAOImpl<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> implements BaseDAO<R, P, T> {

  protected DSLContext dsl;

  private Field<T> pk;

  @SuppressWarnings("unchecked")
  protected BaseDAOImpl(Table<R> table, Class<P> type, Configuration configuration) {
      super(table, type, configuration);
      dsl = configuration.dsl();
      List<TableField<R, ?>> pkFields = getTable().getPrimaryKey().getFields();
      pk = (Field<T>) table.field("id");
  }

  public P fetchOneById(T id) {
    return fetchOne(pk, id);
  }




  public Page<P> paginate(SelectWhereStep<R> select, Pageable pageable) {

    Assert.notNull(pageable, "Pageable must not be null!");

    if (pageable.isPaged()) {
      select.offset((int) pageable.getOffset()).limit(pageable.getPageSize());
    }
    Sort sort = pageable.getSort();
    if (sort.isSorted()) {
      sort.stream().forEach(order -> {
        Field<?> field = DSL.field(order.getProperty());
        SortField<?> sortField = order.isAscending() ? field.asc() : field.desc();
        select.orderBy(sortField);
      });
    }
    List<P> content = select.fetch().map(mapper());
    return PageableExecutionUtils.getPage(content, pageable, () -> dsl.fetchCount(select));
  }
}
