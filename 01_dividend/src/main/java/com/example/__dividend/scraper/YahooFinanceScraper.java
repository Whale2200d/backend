package com.example.__dividend.scraper;

import com.example.__dividend.model.Company;
import com.example.__dividend.model.Dividend;
import com.example.__dividend.model.ScrapedResult;
import com.example.__dividend.model.constants.Month;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class YahooFinanceScraper implements Scraper {
    // final: 초기화 이후 값을 변경할 수 없음.
    /** static:
     * 인스턴스를 생성할 때, 여러 개를 생성해서 사용함. 그래서 인스턴스가 생성될 때마다 URL 영역 만큼 Heap 메모리를 할당받게 됨. (비효율적)
     * 이때 URL을 static 변수로 선언하게 되면, Static 변수를 저장하기 위한 Static 영역에 따로 저장하게 됨. (효율적)
     */
    private static final String STATISTICS_URL = "https://finance.yahoo.com/quote/%s/history/?frequency=1mo&period1=%d&period2=%d";
    private static final String SUMMARY_URL = "https://finance.yahoo.com/quote/%s";
    private static final long START_TIME = 86400; // 1일, 60초 * 60분 * 24시간

    @Override
    public ScrapedResult scrap(Company company) {
        var scrapedResult = new ScrapedResult();
        scrapedResult.setCompany(company);

        try {
//            long start = 99153000;
//            long end = 1775696998;
            long now = System.currentTimeMillis() / 1000;
            String url = String.format(STATISTICS_URL, company.getTicker(), START_TIME, now);
            // 웹 사이트 요청보내서 HTML 문서 받아오기
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            Elements parsingElements = document.getElementsByAttributeValue("data-testid", "history-table");
            Element tableElement = parsingElements.get(0).children().get(2).children().get(0); // table 전체
            Element tbodyELement = tableElement.children().get(1);

            List<Dividend> dividends = new ArrayList<>();
            for (Element e: tbodyELement.children()) {
                String text = e.text();
                if (text.contains("Dividend") && !text.contains("Splits")) {
                    String[] splits = text.split(" ");
                    int month = Month.stringToNumber(splits[0]); // 생성자 함수 없이 사용할 수 있는 이유는 static으로 메서드를 선언했기 때문
                    int day = Integer.valueOf(splits[1].replace(",", ""));
                    int year = Integer.valueOf(splits[2]);
                    String dividend = splits[3];

                    if (month < 0) {
                        throw new RuntimeException("Unexpected Month enum value -> " + splits[0]);
                    }

                    dividends.add(Dividend.builder()
                                            .date(LocalDateTime.of(year, month, day, 0, 0))
                                            .dividend(dividend)
                                            .build());
                }
            }
            scrapedResult.setDividendEntities(dividends);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scrapedResult;
    }

    @Override
    public Company scrapCompanyByTicker(String ticker) {
        String url = String.format(SUMMARY_URL, ticker);

        try {
            Document document = Jsoup.connect(url).get();
            Element titleElement = document.getElementsByTag("h1").get(1);
            String title = titleElement.text().trim();

            return Company.builder()
                            .ticker(ticker)
                            .name(title)
                            .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
