package com.example.__dividend.scraper;

import com.example.__dividend.model.Company;
import com.example.__dividend.model.ScrapedResult;

public interface Scraper {
    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}
