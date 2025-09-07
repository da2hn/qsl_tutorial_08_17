package com.qsl.qsl_tutorial.boundedContext.user.repository;

import com.qsl.qsl_tutorial.boundedContext.user.entity.QSiteUser;
import com.qsl.qsl_tutorial.boundedContext.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SiteUser getQslUser(Long id) {

        QSiteUser siteUser = QSiteUser.siteUser;

        return jpaQueryFactory
                .selectFrom(siteUser) // SELECT * FROM site_user
                .where(siteUser.id.eq(id)) //Where id = 1
                .fetchOne(); // 단일 결과를 반환

    }
}
