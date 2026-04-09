package com.example.__dividend;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

		try {
			// 웹 사이트 요청보내서 HTML 문서 받아오기
			Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/COKE/history/?frequency=1mo&period1=99153000&period2=1775696998");
			Document document = connection.get();

			Elements elements = document.getElementsByAttributeValue("data-testid", "history-table");
			Element table = elements.get(0).children().get(2).children().get(0); // table 전체
			Element tbody = table.children().get(1);

			for (Element e: tbody.children()) {
				String text = e.text();
				if (text.contains("Dividend") && !text.contains("Splits")) {
//					System.out.println(text);

					String[] splits = text.split(" ");
					String month = splits[0];
					int day = Integer.valueOf(splits[1].replace(",", ""));
					int year = Integer.valueOf(splits[2]);
					String dividend = splits[3];

					System.out.println(month + ", " + day + ", " + year + ", " + dividend);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
