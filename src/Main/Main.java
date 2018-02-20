/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author entrar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nuevo = getAtomicNumber("Neon");
    //System.out.println(nuevo);    

    
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "documento", null);
document.setXmlVersion("1.0");
        Element raiz = document.getDocumentElement();
        
        Element nodoNombreCampo = document.createElement("nuevo"); //creamos un nuevo elemento
Text nodoValorCampo = document.createTextNode(getAtomicNumber("Neon")); //Ingresamos la info				
nodoNombreCampo.appendChild(nodoValorCampo); 						
raiz.appendChild(nodoNombreCampo);
        
Source source = new DOMSource(document);
Result result = new StreamResult(new java.io.File("resultado.xml"));
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.transform(source, result);
	File fXmlFile = new File("resultado.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("nuevo");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		org.w3c.dom.Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("Staff id : " + eElement.getAttribute("AtomicNumber"));
			System.out.println("First Name : " + eElement.getElementsByTagName("AtomicNumber").item(0).getTextContent());
			System.out.println("Last Name : " + eElement.getElementsByTagName("AtomicNumber").item(0).getTextContent());
			System.out.println("Nick Name : " + eElement.getElementsByTagName("AtomicNumber").item(0).getTextContent());
			System.out.println("Salary : " + eElement.getElementsByTagName("AtomicNumber").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getAtomicWeight(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtoms() {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
    
}
