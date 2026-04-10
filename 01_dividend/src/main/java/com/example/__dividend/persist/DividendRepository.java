package com.example.__dividend.persist;

import com.example.__dividend.persist.entity.DividendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendRepository extends JpaRepository<DividendEntity, Long> {

    /**
     * 구현 동작
     * 1. 인풋으로 저장할 회사의 ticker를 받는다.
     * 2. 이미 저장 되어 있는 회사의 ticker일 경우 오류 처리
     * 3. 받은 ticker의 데이터를 야후 파이낸스에서 스크래핑 한다.
     * 4. 스크래핑 데이터가 조회되지 않는 경우 오류 처리
     * 5. 스크래핑한 회사의 메타 정보와 배당금 정보를 각각 DB에 저장한다.
     * 6. 저장한 회사의 메타 정보를 응답으로 내려준다.
     */
}
