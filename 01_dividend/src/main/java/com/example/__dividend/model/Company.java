package com.example.__dividend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // 참고: https://www.baeldung.com/java-builder-pattern
public class Company {
    private String ticker;
    private String name;
}
