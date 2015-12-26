package my.Learning;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class JobStatus {
   public static void main(String[] args){

      try {	
         File inputFile = new File("JobDetails.txt");
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" 
            + doc.getDocumentElement().getNodeName());

         NodeList nodeList=doc.getElementsByTagName("*");
         Set<String> tags = new HashSet<String>();
         for (int i=0; i<nodeList.getLength(); i++) 
         {
             // Get element
             Element element = (Element)nodeList.item(i);
             //System.out.println(element.getNodeName());
             tags.add(element.getNodeName());
             //System.out.println(element.getNodeType());
             //tags.add(Short.toString(element.getNodeType()));
         }
         System.out.println(tags.toString());
         NodeList nList = doc.getElementsByTagName("entry");
         System.out.println("----------------------------" + Node.ELEMENT_NODE + " ::length:" + nList.getLength());

         String[] Tags = new String[5];
         Tags[0]="title";
         Tags[1]="tes:duration";
         Tags[2]="tes:jobname";
         Tags[3]="tes:rundate";
         Tags[4]="tes:statusname";
         //Tags[]="";
         //Tags[]="";
         //Tags[]="";
         //Tags[]="";
         //Tags[]="";
         //Tags[]="";

         for (int i=0; i<Tags.length; i++)
        	   System.out.print(Tags[i] + "|" );
        
         for (int temp = 0; temp < nList.getLength(); temp++) {
        	 System.out.println("");
            Node nNode = nList.item(temp);
            //System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               

               for (int i=0; i<Tags.length; i++)
            	   if (eElement.getElementsByTagName(Tags[i]).item(0) == null )
            		   System.out.print("|");
            	   else
            		   System.out.print(eElement.getElementsByTagName(Tags[i]).item(0).getTextContent() + "|");
            }
         }
      } catch (Exception e) {
    	  System.err.println("Im Out");
         e.printStackTrace();
      }
   }
}

//http://tes-cm-prd1-01.cisco.com:8080/api/tes-6.0/JobRun.getList/?query(parentname='CVC_SRC')