package com.penn;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 圣才题库网页题库转text
 * 
 * @author penn
 *
 */
public class Xuexi100 {

	public static void main(String[] args) throws Exception {

		Document doc = Jsoup.parse(new File("/Users/penn/Downloads/test.htm"), "UTF-8"); // 网页源代码

		Elements elements = doc.select("div.Item.config");
		for (Element ele : elements) {
			Element questionDiv = ele.select("div.question.config").first();
			Element question = questionDiv.child(0).child(0);
			System.out.println(question.text()); // 题目
			Elements answerDiv = questionDiv.select("td.SuSpenSionXu");
			if (answerDiv != null && answerDiv.size() > 0) { // 选择题
				for (Element answer : answerDiv) { // 获得选项
					System.out.print(answer.text() + "\t");
				}
				System.out.println();
				System.out.println("答案：" + ele.select("div.anser.Con").first().text());
				System.out.println("解析：" + ele.select("div.analysits.Con").first().text());
			} else { // 解答题
				Element answer = ele.select("div.anser").first();
				System.out.println("答：" + answer.text());
			}
		}
	}
}
