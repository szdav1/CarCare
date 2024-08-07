package com.silentsoft.util.config.xml;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com.silentsoft.util.ResourceHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.w3c.dom.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractXMLObjectParser {
	protected final XMLParserConfiguration configuration;

	private boolean isNotElement(final Node node) {
		return node.getNodeType() != Node.ELEMENT_NODE;
	}

	private boolean isNotText(final Node node) {
		return node.getNodeType() != Node.TEXT_NODE;
	}

	private String createKey(final String attribute, final String nodeName) {
		if (attribute.isBlank())
			return nodeName;

		return new StringBuilder(attribute)
			.append(".")
			.append(nodeName)
			.toString();
	}

	public HashMap<String, String> parseXMLFile(final String filePath) throws Exception {
		HashMap<String, String> processedData = new HashMap<>();

		Document XMLDocument = DocumentBuilderFactory.newInstance()
			.newDocumentBuilder()
			.parse(new File(ResourceHandler.get(filePath)));

		XMLDocument.normalize();
		NodeList rootNodes = XMLDocument.getElementsByTagName(this.configuration.getNodeName());

		for (int i = 0; i < rootNodes.getLength(); i++) {
			Node rootNode = rootNodes.item(i);

			if (this.isNotElement(rootNode))
				continue;

			Element rootElement = (Element) rootNode;
			String attribute = rootElement.getAttribute(this.configuration.getAttributeName());
			NodeList childNodes = rootElement.getChildNodes();

			for (int j = 0; j < childNodes.getLength(); j++) {
				Node childNode = childNodes.item(j);

				if (this.isNotElement(childNode))
					continue;

				Element childElement = (Element) childNode;
				NodeList destinationNodes = childElement.getChildNodes();

				for (int k = 0; k < destinationNodes.getLength(); k++) {
					Node destinationNode = destinationNodes.item(k);

					if (this.isNotText(destinationNode))
						continue;

					Text text = (Text) destinationNode;
					processedData.put(this.createKey(attribute, childElement.getTagName()), text.getData());
				}
			}
		}

		return processedData;
	}
}
