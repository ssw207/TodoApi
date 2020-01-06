package com.song.woo.member.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -147597424L;

    public static final QMember member = new QMember("member1");

    public final com.song.woo.common.domain.QBaseEntity _super = new com.song.woo.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dtFrt = _super.dtFrt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dtLst = _super.dtLst;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath memId = createString("memId");

    public final StringPath memName = createString("memName");

    public final StringPath memPw = createString("memPw");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

