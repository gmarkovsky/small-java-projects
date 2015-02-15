package com.gmail.gbmarkovsky.gmaps;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

import com.google.common.io.Files;

public class KmlParser {
	public static List<GeoObject> parse(File file) {
		DOMImplementationRegistry registry;
		try {
			registry = DOMImplementationRegistry.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(); // shouldn't happen;
		}

		DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");

		LSParser serializer = impl.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);

		LSInput in = impl.createLSInput();
		try {
			in.setByteStream(new ByteArrayInputStream(Files.toByteArray(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		Document doc = serializer.parse(in);
		serializer.getDomConfig();

		List<GeoObject> result = new ArrayList<GeoObject>();
		
		Element root = doc.getDocumentElement();

		NodeList list = root.getElementsByTagName("Placemark");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (org.w3c.dom.Element) list.item(i);
			GeoObject geoObject = new GeoObject();
			geoObject.name = readTag(element, "name");
			geoObject.description = readTag(element, "description");
			String geom = readTag(element, "Point");
			if (geom != null) {
				geoObject.geometry = "<Point><coordinates>" + geom + "</coordinates></Point>";
			} else {
				NodeList subList = root.getElementsByTagName("LineString");
				Element e = (Element) subList.item(0);
				geoObject.geometry = "<LineString><coordinates>" + readTag(e, "coordinates") + "</coordinates></LineString>";
			}
			result.add(geoObject);
		}
		
		return result;
	}
	
	private static String readTag(Element element, String tagName) {
		String result = null;
		NodeList localList = element.getElementsByTagName(tagName);
		if (localList.getLength() > 0) {
			result = ((Element) localList.item(0)).getTextContent();
		}
		return result;
	}
}
