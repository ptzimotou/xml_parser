/**
 * 
 * @author Tzimotoudis Panagiotis
 * @authos Tziokas George
 * @version 1.0
 * 
 */

package xml_parser;
import xml_parser.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class DocumentBuilder {

	/**
	 * public DocumentBuilder()
	 * Create an empty DocumentBuilder object
	 */
	public DocumentBuilder ( ) {

	}

	/** 
	 * public String getDocumentAsString(String location)
	 * This method reads a text file from the given location and returns 
	 * its contents as a String. The location can be either a filesystem
	 * path or a URL
	 * 
	 * @param location - The location of the file to read from. Location can be 
	 * either a filesystem path(i.e. /home/user/documents/rss.xml) or a 
	 * network URL(i.e. http://feeds.bbci.co.uk/news/rss/xml).
	 * 
	 * @return The contents of the XML file in a String. String containing the 
	 * contents of the actual text file
	 */
	public String getDocumentAsString ( String location ) {
	 	
	 	Pattern fileP = Pattern.compile( "http://" );
		Matcher fileM = fileP.matcher( location );

		if ( fileM.find() ){

			try {

				URL loc = new URL( location );
				BufferedReader in = new BufferedReader ( new InputStreamReader ( loc.openStream() ) );
				String inputLine;
				StringBuffer strDocument = new StringBuffer();

				while (( inputLine = in.readLine() ) != null ) {

					strDocument.append( inputLine );
				}

				in.close();
				return strDocument.toString();
			}catch ( MalformedURLException ex ) {

				System.out.println( "the specified URL was not found at " + location );
				return "";
			}catch ( IOException ex ) {

				System.out.println( "IOException occured while reading from file " + location );
				return "";
			}
		}else {

		 	try {

		      File file = new File ( location );
		      FileReader fReader = new FileReader( file );
		      BufferedReader in = new BufferedReader( fReader );
		      String inputLine;
		      StringBuffer strDocument = new StringBuffer();

		      while ( ( inputLine = in.readLine() ) != null ) {
		        
		        strDocument.append( inputLine );
		      }

		      fReader.close();
		      return strDocument.toString();
		    }catch( FileNotFoundException ex ) {
		     
		      System.out.println( "The specified file was not found at "+ location );
		      return "";
		    }catch( IOException ex ) {
		      
		      System.out.println( "IOException occured while reading from file "+ location );
		    }
		}

	    return "Nothing to return..";
	}

	 /** 
	  * public Document getDocument(String location)
	  * Reads a file or URL located at location and returns an Document 
	  * object. Parameter location can be either a filesystem path or a
	  * URL.
	  * 
	  * @param location - The location of the file to read from. Location can be 
	  * either a filesystem path(i.e. /home/user/documents/rss.xml) or a 
	  * network URL(i.e. http://feeds.bbci.co.uk/news/rss/xml).
	  *  
	  * @return The actual XML file
	  */
	 public Document getDocument ( String location ) {
	 	
	 	String documentAsString = getDocumentAsString ( location );
	 	return parseDocument( documentAsString );
	 }

	/** 
	 * public Document parseDocument(String documentStr)
	 * Parses an XML String and returns a Document object. The method DOES
	 * NOT perform any verification on the validity of the XML document,
	 * prior to processing it.
	 * 
	 * @param documentStr - XML document read as String.
	 *
	 * @return The actual XML Document.
	 */
	public Document parseDocument ( String documentStr ) {
		
		Pattern nodeP = Pattern.compile( "<(/?)([a-zA-Z_]+)([a-zA-Z_0-9:]*)([^>]*)(/?)>([ ]*)(([^<]*)?)" );
		Matcher nodeM = nodeP.matcher( documentStr );
		Node current = null;
		Node currentParent = null;
		List<Namespace> namespaces;
		Namespace nm = null;
		List<Attribute> attrs = null;
		Document doc = new Document();
		String name;

		namespaces = namespaceMatch( documentStr, doc );

		if ( nodeM.find() ) {
		    
		    if( nodeM.group(3).isEmpty() ) {

		    	// then name is on group(2)
		    	name = nodeM.group(2);
		    }else {

			    name = nodeM.group(3).substring(1);
			    if ( doc.namespacePrefixExists( nodeM.group(2) ) ) {

			   		nm = doc.getNamespace( nodeM.group(2) );
			   	}else {

			   		System.out.println( "Namespace: " + nodeM.group(2) + " , is not exists..." );
			   	}
			}
		    if ( !nodeM.group(4).isEmpty() ) {

		    	// Node has attributes
		    	attrs = parseNodeAttributes( nodeM.group(4) );
		    }
		   	
	    	/** public Node(String name, String text, Node parent, List<Attribute> attrs, Namespace nm)*/
		    current = new Node ( doc, name, nodeM.group(7), null, attrs, nm );
		    attrs = null;
		    doc.setRootNode ( current );
		    currentParent = current;
		    if ( !nodeM.group(5).isEmpty() ) {
		   		
		   		// then this node is only attribute node
		   		current = current.getParent();
		   	}
	    }

	    while ( nodeM.find() ) {
		    
		    if ( nodeM.group(1).isEmpty() ) {

			    if( nodeM.group(3).isEmpty() ) {

			    	// then name is on group(2)
			    	name = nodeM.group(2);
			    	nm = null;	// Node isn't belong to namespace
			    }else {

			    	name = nodeM.group(3).substring(1);
			    	if ( doc.namespacePrefixExists( nodeM.group(2) ) ) {

			    		nm = doc.getNamespace( nodeM.group(2) );
			    	}else {

			    		System.out.println( "Namespace: " + nodeM.group(2) + " , is not exists..." );
			    	}
			    }
			    if ( !nodeM.group(4).isEmpty() ) {

			    	// Node has attributes
			    	attrs = parseNodeAttributes( nodeM.group(4) );
			    }
			   	
		    	Node newNode = new Node ( doc, name, nodeM.group(7), current, attrs, nm );
		    	current = newNode;
			    attrs = null;
			    nm = null;
			    currentParent.addChild( current );
			    currentParent = current;

			    if ( !nodeM.group(4).isEmpty() ) {

			    	String str = nodeM.group(4);
			    	str = str.substring( str.length() - 1 );

			    	if ( str.charAt(0)  == '/' ) {
				   		
				   		// then this node is only attribute node
				   		current = current.getParent();
				   		currentParent = currentParent.getParent();
				   	}
				}
			    
			}else {

				// End node
				current = current.getParent();
				currentParent = currentParent.getParent();

			}
	    }

	    return doc;
	}

	private List<Namespace> namespaceMatch ( String str, Document doc ) {
	    Pattern nmP = Pattern.compile("xmlns:([a-zA-Z_]+)([a-zA-Z_0-9]*)(=\")([\\p{Alnum}\\p{Punct}]+)(\")([\\s]*)");
	    Matcher nmM = nmP.matcher(str);
		int firstTime = 1;
		List<Namespace> namespaceList=null;
		Namespace nm;

	    while( nmM.find() ) {

	    	if ( firstTime == 1 ) {

	    		namespaceList = new LinkedList<Namespace>();
	 			firstTime = 0;
	    	}

	    	nm = new Namespace ( nmM.group(1), nmM.group(4) );
	    	namespaceList.add( nm );
	    	doc.addNamespace( nm );
	    }

	    return namespaceList;
	}
	  
	private List<Attribute> parseNodeAttributes( String str ) {
	    
	    Pattern attrP = Pattern.compile( " ([a-zA-z_]+)=\"([\\p{Alnum}\\p{Punct}]+)\"" );
	    Matcher attrM = attrP.matcher( str );
	    List<Attribute> attrs = new LinkedList<Attribute>();

	    while( attrM.find() ) {

	    	attrs.add( new Attribute ( attrM.group(1), attrM.group(2) ) );
	    }

	    return attrs;
	}

}
