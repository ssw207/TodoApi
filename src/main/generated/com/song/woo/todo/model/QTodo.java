package com.song.woo.todo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTodo extends EntityPathBase<Todo> {

    private static final long serialVersionUID = 510242000L;

    public static final QTodo todo = new QTodo("todo");

    public final com.song.woo.common.domain.QBaseEntity _super = new com.song.woo.common.domain.QBaseEntity(this);

    public final BooleanPath done = createBoolean("done");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dtFrt = _super.dtFrt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dtLst = _super.dtLst;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QTodo(String variable) {
        super(Todo.class, forVariable(variable));
    }

    public QTodo(Path<? extends Todo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodo(PathMetadata metadata) {
        super(Todo.class, metadata);
    }

}

