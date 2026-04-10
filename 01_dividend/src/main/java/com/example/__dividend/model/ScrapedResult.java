package com.example.__dividend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor // 모든 필드를 초기화하는 생성자 코드를 사용할 수 있음.
public class ScrapedResult {
    private Company company;
    private List<Dividend> dividendEntities;

    public ScrapedResult() {
        this.dividendEntities = new ArrayList<>();
    }
}
