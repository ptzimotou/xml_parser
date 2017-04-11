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

public class Document {
	private Node rootNode;
	private List<Namespace> namespaceList;
	
	/** 
	 * public Document()
	 * Create an empty Document object
	 */
	public Document ( ) {

	}

	/** 
	 * public Document(Node rootNode)
	 * Creates a new Document object with root node set to rootNode.
	 * 
	 * @param rootNode - the root node of the Document object
	 */
	public Document ( Node rootNode ) {
		
		this.rootNode = rootNode;
	}

	/** 
	 * public Node getRootNode()
	 * Returns the root node of the Document object
	 * 
	 * @return Node the root node of the Document
	 */
	public Node getRootNode ( ) {

		return rootNode;
	}

	/** 
	 * public void setRootNode(Node rootNode)
	 * Set the root node of the Document object
	 * 
	 * @param rootNode - the root node of the Document object
	 */
	public void setRootNode ( Node rootNode ) {

		this.rootNode = rootNode;
	}

	/** 
	 * protected void addNamespace(Namespace namespace)
	 * Add a Namespace object to the list of Namespaces of the Document
	 * 
	 * @param namespace - the Namespace object to be added
	 */
	protected void addNamespace ( Namespace namespace ) {

		try {

			namespaceList.add( namespace );
		}catch ( Exception ex ) {
			
			namespaceList = new LinkedList<Namespace>();
			namespaceList.add( namespace );
		}
	}

	/** 
	 * public boolean namespacePrefixExists(String prefix)
	 * Check whether a namespace prefix exists or not in the Document
	 * 
	 * @param prefix - the prefix of the Namespace
	 * 
	 * @return boolean whether the selected prefix belongs to one of the Namespaces of the Document
	 */
	public boolean namespacePrefixExists ( String prefix ) {
		
		Iterator<Namespace> it = namespaceList.listIterator();

	    while( it.hasNext() ) {

	      Namespace namespace = it.next();
	      if ( prefix.equals( namespace.getPrefix() ) ) {

	      	return true;
	      }
	    }

		return false;
	}

	/**	
	 * public List<Namespace> getNamespaces()
	 * Returns the list of Namespaces this Document makes available.
	 * 
	 * @return the list of Namespace objects.
	 */
	public List<Namespace> getNamespaces ( ) {

		return namespaceList;
	}

	/** 
	 * public Namespace getNamespace(String prefix)
	 * Returns the Namespace object that belongs to the list of Namespaces
	 * of the Document object, provided that the given prefix belongs to that Namespace.
	 *
	 * @return Namespace if prefix found else null
	 */
	public Namespace getNamespace ( String prefix ) {
		
		Iterator<Namespace> it = namespaceList.listIterator();
	    
	    while( it.hasNext() ) {

	    	Namespace namespace = it.next();
	    	if ( prefix.equals( namespace.getPrefix() ) ) {

	    		return namespace;
	    	}
	    }

	    return null; // Return NULL if prefix doesn't exist at none namespace.
	}

	/**
	 * public String toString()
	 * Returns a String representation of the Document in XML notation
	 * 
	 * @return String representation of the Document in XML notation 
	 * @overrides toString in class Object
	 */
	public String toXMLString ( ) {

		String xmlString = "";
		Node nd = rootNode;
		Node currentParent = rootNode;

		while ( true ) {

			xmlString = xmlString + nd.toXMLString() + "\n";
	      	currentParent = nd;
	      	nd = nd.getNextChild();
			while ( nd == null ) {

				if ( currentParent.getChildren() != null ) {

					xmlString = xmlString + "</" + currentParent.getName() + ">" + "\n";
				}

				if ( currentParent.getParent() == null ) {
					
					return xmlString;
				}

				nd = currentParent.getParent();
				nd = nd.getNextChild();
				currentParent = currentParent.getParent();
			}
		}
	}

	/** 
	 * public String toString(String identStr)
	 * Returns a String representation of the Document in XML notation
	 * 
	 * @param identStr - identification string
	 * @return String representation of the Document in XML notation
	 * @overrides toString in class Object
	 */
	public String toXMLString ( String identStr ) {

		String xmlString = "";
		int depth = 0;
		Node nd = rootNode;
		Node currentParent = rootNode;

		while ( true ) {

			xmlString = xmlString + nd.toXMLString( depth, identStr ) + "\n";
	      	currentParent = nd;
	      	nd = nd.getNextChild();
			while ( nd == null ) {

				if ( currentParent.getChildren() != null ) {

					String depthStr = "";
					int currDepth = depth;

					while ( currDepth > 0 ) {

						depthStr = depthStr + identStr;
						currDepth--;
					}
					xmlString = xmlString + depthStr + "</" + currentParent.getName() + ">" + "\n";
				}

				if ( currentParent.getParent() == null ) {
					
					return xmlString;
				}

				depth--;
				nd = currentParent.getParent();
				nd = nd.getNextChild();
				currentParent = currentParent.getParent();
			}
			
			depth++;
		}
	}
}
