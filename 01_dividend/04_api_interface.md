# 배당금 프로젝트

## API 인터페이스 설계

1. 특정 회사의 배당금 조회
  - GET request: `/finance/dividend/{companyName}` (parameter로 조회하기)
  - GET response
      ```
      {
        companyName: "회사명",
        dividend: [
          {
            date: "2025.12.31",
            price: "2.00"
          }, ...
        ]
      }
    ```
 
2. 배당금 검색 - 자동완성
  - GET request: `/company/autocomplete?keyword=O` (parameter로 조회하기)
  - GET response:
      ```
      {
        result: ["O", "OAS", ...]
      }
    ```
    
3. 회사 리스트 조회
- GET request: `/company`
- GET response:
    ```
      {
        result: [
          {
            companyName: "회사명",
            ticker: "TICK"
          }, ...
        ]
      }
    ```

4. 관리자 기능 - 배당금 저장
- POST request: `/company, { ticker: "TICK" }` (request body에 담아서 보내기)
- POST response:
    ```
      {
        ticker: "TICK",
        companyName: "회사명"
      }
    ```

5. 관리자 기능 - 배당금 삭제
- DELETE request: `/company?ticker=TICK` (parameter로 보내기)
  - POST에서는 request body의 역할이 정의된 반면, GET, DELETE에서는 명시적인 약속이 없다.
  - 필요에 따라 DELETE 요청을 보낼 때, request body를 무시할 수 있음.

- 이러한 정해진 규칙을 볼 수 있는 곳 [해당 페이지로 이동](https://www.rfc-editor.org/rfc/rfc9110.html#name-method-definitions)
  - "GET, POST 메서드 차이 설명"과 같은 면접 질문 대비에 필요함.
  - GET, POST, PUT, DELETE에 대한 설명을 읽어보는 것을 추천

6. 회원 API
- 회원가입
- 로그인
- 로그아웃

구현에 있어 결과도 중요하지만, 내가 왜 이렇게 구현했는지 과정을 이해하고 설명할 수 있는 게 훨씬 더 중요하다.
면접관은 어디까지 고민해서 코드를 구현했는지 훨씬 더 관심을 갖는다. 