# 배당금 프로젝트

## DB 설계 시 고려할 수 있는 것들
- 어떤 타입의 데이터가 저장되는지
- 데이터의 규모는 어떻게 되는지
- 데이터의 저장 주기는 어떻게 되는지
- 데이터의 읽기와 쓰기의 비율
- 속도 vs 정확도
- READ 연산시 어떤 컬럼을 기준으로 읽어오는지 (인덱스)
- 키는 어떻게 생성해줄 것인지
- 예상 트래픽은 어느 정도인지
- 파티션은 어떻게 구성할 것인지 등등

## 회사 컬럼
| column | type   | unique | example   |
|--------|--------|--------|-----------|
| id     | Long   | ✅      | 1         |
| name   | String |        | Coca-Cola |
| ticker | String |        | Coke      |

## 배당금 컬럼
| column     | type          | unique | example    |
|------------|---------------|--------|------------|
| id         | Long          | ✅      | 3          |
| company_id | Long          |        | 1          |
| date       | LocalDateTime |        | 2022-05-05 |
| dividend   | String        |        | 2.00       |

## 분산 데이터베이스
- auto increment가 어려운 환경일 때