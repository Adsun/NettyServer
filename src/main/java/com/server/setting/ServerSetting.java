package com.server.setting;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServerSetting {
	private static final String SETTING_PATH = "web.xml";
	private static ServerSetting instance;
	@SuppressWarnings("unchecked")
	private ServerSetting() {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(ClassLoader.getSystemResourceAsStream(SETTING_PATH));
			Element root = doc.getRootElement();
			if (!root.elements().isEmpty()) {
				List<Element> elements = root.elements();
				for (Element e : elements) {
					System.out.println(e.getName());
				}
			}
			System.out.println(root.getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public static synchronized ServerSetting getInstance(){
		if (instance == null) {
			instance = new ServerSetting();
		}
		return instance;
	}
}
