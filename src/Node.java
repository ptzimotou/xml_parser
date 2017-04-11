/**
 * 
 * 
 * @author Tzimotoudis Panagiotis
 * @authos Tziokas George
 * @version 1.0
 * @since 2015-03-27
 */

package xml_parser;

import xml_parser.*;
import java.util.*;

public class Node extends Object {
	private Document doc;
	private Node parent;
	private String name;
	private String text;
	private Namespace namespace;
	private List<Node> childrenNodeList;
	private List<Attribute> attrs;
	private Iterator<Attribute> attrIt;
	private Iterator<Node> nodeIt;

	/** 
	 * public Node()
	 * Node constructor with no initial values.
	 */
	public Node ( ) {

	}

	/** 
	 * public Node(String name)
	 * Node constructor
	 *
	 * @param name - the name of the Node object
	 */
	public Node ( String name ) {

		this.name = name;
	}

	/** 
	 * public Node(String name, String text)
	 * Node constructor
	 * 
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 */
	public Node ( String name, String text ) {

		this.name = name;
		this.text = text;
	}

	/** 
	 * public Node(Document doc, String name, String text)
	 * Node constructor
	 * 
	 * @param doc - the Document object the Node belongs to
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 */
	public Node ( Document doc, String name, String text ) {

		this.doc = doc;
		this.name = name;
		this.text = text;
	}

	/** 
	 * public Node(String name, String text, Node parent)
	 * Node constructor
	 * 
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 */
	public Node ( String name, String text, Node parent ) {

		this.name = name;
		this.text = text;
		this.parent = parent;
	}

	/** 
	 * public Node(Document doc, String name, String text, Node parent)
	 * Node constructor
	 * 
	 * @param doc - the Document object the Node belongs to
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 */
	public Node ( Document doc, String name, String text, Node parent ) {

		this.doc = doc;
		this.name = name;
		this.text = text;
		this.parent = parent;
	}

	/** 
	 * public Node(String name, String text, Node parent, List<Attribute> attrs)
	 * Node constructor
	 * 
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 * @param attr - the list of attributes
	 */
	public Node ( String name, String text, Node parent, List<Attribute> attrs ) {
		
		this.name = name;
		this.text = text;
		this.parent = parent;
		this.attrs = attrs;
	}

	/** 
	 * public Node(Document doc, String name, String text, Node parent, List<Attribute> aatrs)
	 * Node constructor
	 * 
	 * @param doc - the Document object the Node belongs to
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 * @param attr - the list of attributes
	 */
	public Node ( Document doc, String name, String text, Node parent, List<Attribute> attrs ) {

		this.doc = doc;
		this.name = name;
		this.text = text;
		this.parent = parent;
		this.attrs = attrs;
	}

	/** 
	 * public Node(String name, String text, Node parent, List<Attribute> aatrs, Namespace nm)
	 * Node constructor
	 * 
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 * @param attr - the list of attributes
	 * @param nm - the Namespace object the Node references
	 */
	public Node ( String name, String text, Node parent, List<Attribute> attrs, Namespace nm ) {

		this.name = name;
		this.text = text;
		this.parent = parent;
		this.attrs = attrs;
		namespace = nm;
	}

	/**
	 * public Node(Document doc, String name, String text, Node parent, List<Attribute> aatrs, Namespace nm)
	 * Node constructor
	 * 
	 * @param doc - the Document object the Node belongs to
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param parent - a reference to the parent Node object.
	 * @param attr - the list of attributes
	 * @param nm - the Namespace object the Node references
	 */
	public Node ( Document doc, String name, String text, Node parent, List<Attribute> attrs, Namespace nm ) {

		this.doc = doc;
		this.name = name;
		this.text = text;
		this.parent = parent;
		this.attrs = attrs;
		namespace = nm;
	}

	/**
	 * public Node(String name, String text, Node parent, List<Attribute> aatrs, Namespace nm)
	 * Node constructor
	 * 
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param attr - the list of attributes
	 * @param nm - the Namespace object the Node references
	 */
	public Node ( String name, String text, List<Attribute> attrs, Namespace nm ) {

		this.name = name;
		this.text = text;
		this.attrs = attrs;
		namespace = nm;
	}

	/**
	 * public Node(Document doc, String name, String text, Node parent, List<Attribute> aatrs, Namespace nm)
	 * Node constructor
	 * 
	 * @param doc - the Document object the Node belongs to
	 * @param name - the name of the Node object
	 * @param text - the text of the Node object
	 * @param attr - the list of attributes
	 * @param nm - the Namespace object the Node references
	 */
	public Node ( Document doc, String name, String text, List<Attribute> attrs, Namespace nm ) {

		this.doc = doc;
		this.name = name;
		this.text = text;
		this.attrs = attrs;
		namespace = nm;
	}

	/** 
	 * public Namespace getNamespace()
	 * Return the Namespace the Node belongs to, if any exists
	 * 
	 * @return namespace the Namespace of object or null if no namespace exists.
	 */
	public Namespace getNamespace ( ) {
		
		return namespace;
	}

	/** 
	 * public void setNamespace(Namespace n)
	 * Set the Namespace for the Node.
	 */
	public void setNamespace ( Namespace n ) {

		namespace = n;
	}

	/**
	 * public String getName()
	 * Return Node name
	 * 
	 * @return The Node name
	 */
	public String getName ( ) {
		
		return name;
	}

	/** 
	 * public String getText()
	 * Return Node text, if any
	 * 
	 * @return The text String or any empty String if no text exists
	 */
	public String getText ( ) {
		
		return text;
	}

	/** 
	 * public void setName(String name)
	 * Set Node name
	 */
	public void setName ( String name ) {
		
		this.name = name;
	}

	/** 
	 * public void setText(String text)
	 * Set Node text
	 */
	public void setText ( String text ) {

		this.text = text;
	}

	/** 
	 * public Node getParent()
	 * Returns the parent Node.
	 * 
	 * @return The parent Node or null if the object is the root element of the Document
	 */
	public Node getParent ( ) {
		
		return parent;
	}

	/** 
	 * public void setParent(Node parent)
	 * Sets the parent Node.
	 */
	public void setParent ( Node parent ) {

		this.parent = parent;
	}

	/** 
	 * public void addChild(Node child)
	 * Adds a child Node to the list of child Nodes of the Node.
	 */
	public void addChild ( Node child ) {

		try {

			childrenNodeList.add( child );

		}catch ( Exception ex ) {

			/* Enter in this state only if the childrenNodeList
			 * isn't been initialized before.
			 */ 
			childrenNodeList = new LinkedList<Node>();
			childrenNodeList.add( child );
		}
	}

	/** 
	 * public void addChild(int index,Node child)
	 * Adds a child Node at position index to the list of child Nodes of the Node.
	 */
	public void addChild ( int index, Node child ) {

		try {

			childrenNodeList.add( index, child );
		}catch ( IndexOutOfBoundsException e ) {

			/** If index < 0 || index > size insert the new element
			 * after the last element of the list.
			 */
			childrenNodeList.add( child );
		}catch ( Exception ex ) {
			
			/* Enter in this state only if the childrenNodeList
			 * isn't been initialized before.
			 */ 
			childrenNodeList = new LinkedList<Node>();
			childrenNodeList.add( child );
		}
	}

	/** 
	 * public Node getFirstChild()
	 * Returns the first child Node from the list of child Nodes.
	 *
	 * @return First child Node if exist else null
	 */
	public Node getFirstChild ( ) {

		try {
			
			return childrenNodeList.get( 0 );
		}catch ( Exception ex ) {
			
			return null;
		}
	}

	/** 
	 * public Node getNextChild()
	 * Returns the next child Node from the list of child Nodes.
	 *
	 * @return next Child node if exists else null
	 */
	public Node getNextChild ( ) {
		
		try {

			if ( nodeIt.hasNext() ) {

				return nodeIt.next();
			}
		}catch ( Exception e ) {
			
			try {

				nodeIt = childrenNodeList.listIterator();
				if ( nodeIt.hasNext() ) {

					return nodeIt.next();
				}
			}catch ( Exception ex ) {

				return null;
			}
		}

		return null;
	}

	/** 
	 * public Node getChild(int index)
	 * Returns the child Node at position index from the list of child Nodes.
	 *
	 * @return Child node at index position if exists else null
	 */
	public Node getChild ( int index ) {

		try {

			return childrenNodeList.get( index );
		}catch ( IndexOutOfBoundsException e ) {

			return null;
		}catch ( Exception ex ) {
			
			return null;
		}
	}

	/** 
	 * public List<Node> getChildren()
	 * Returns the list of child Nodes of the Node.
	 *
	 * @return list of Children
	 */
	public List<Node> getChildren ( ) {
		
		return childrenNodeList;
	}

	/** 
	 * public void addAttribute(Attribute attr)
	 * Adds an Attribute to the list of Attributes of the Node.
	 */
	public void addAttribute ( Attribute attr ) {

		try {

			attrs.add( attr );
		}catch ( Exception ex ) {
			
			/* Enter in this state only if the childrenNodeList
			 * isn't been initialized before.
			 */ 
			attrs = new LinkedList<Attribute>();
			attrs.add( attr );
		}
	}

	/** 
	 * public void addAttribute(int index, Attribute attr)
	 * Adds an Attribute to the list of Attributes of the Node at the position index
	 */
	public void addAttribute ( int index, Attribute attr ) {

		try {
			
			attrs.add( index, attr );
		}catch ( IndexOutOfBoundsException e ) {

			/** If index < 0 || index > size insert the new element
			 * after the last element of the list.
			 */
			attrs.add( attr );
		}catch ( Exception ex ) {
			
			/* Enter in this state only if the childrenNodeList
			 * isn't been initialized before.
			 */ 
			attrs = new LinkedList<Attribute>();
			attrs.add( attr );
		}
	}

	/** 
	 * public Attribute getFirstAttribute()
	 * Returns the first Attribute from the list of Attributes of the Node.
	 *
	 * @return The first Attribute if exists else null
	 */
	public Attribute getFirstAttribute ( ) {
		
		try {
			
			return attrs.get( 0 );
		}catch ( Exception ex ) {
			
			return null;
		}
	}

	/** 
	 * public Attribute getNextAttribute()
	 * Returns the next Attribute from the list of Attributes of the Node.
	 * 
	 * @return The next Attribute if exists else null
	 */
	public Attribute getNextAttribute ( ) {

		try {
			
			if ( attrIt.hasNext() ) {
				
				return attrIt.next();
			}
		}catch ( Exception e ) {
			
			attrIt = attrs.listIterator();
			if ( attrIt.hasNext() ) {
				
				return attrIt.next();
			}
		}

		return null;
	}

	/** 
	 * public Attribute getAttribute(int index)
	 * Returns the Attribute at position index from the list of Attributes of the Node.
	 *
	 * @return The Attribute at position if exists else null
	 */
	public Attribute getAttribute ( int index ) {
		
		try {

			return attrs.get( index );
		}catch ( IndexOutOfBoundsException e ) {

			return null;
		}catch ( Exception ex ) {
			
			return null;
		}
	}

	/** 
	 * public List<Attribute> getAttributes()
	 * Returns the list of Attributes of the Node.
	 *
	 * @return List of all Attributes
	 */
	public List<Attribute> getAttributes ( ) {
		
		return attrs;
	}

	/** 
	 * public String toString()
	 * Returns a String representation of the Node, without specific indentation.
	 * 
	 * @return String representation of the Node
	 * @overrides toString in class Object
	 */ 
	public String toXMLString ( ) {

		String returnString = "";

		/** Add namespaces if they are exist and name to Node representation.
		 * If Node belongs to a namespace, then put the nameprefix before name.
		 * If Node is parent Node, then put all namespaces as arguments.
		 */
		if ( namespace != null ) {

			returnString = returnString + "<" + namespace.getPrefix() + ":" + name;
		}else if ( parent == null ) {

			List<Namespace> namespaces = doc.getNamespaces();
			Iterator<Namespace> nmIt = namespaces.listIterator();
			String namespacesStr = "";

		    while( nmIt.hasNext() ) {

		    	Namespace nm = nmIt.next();
		    	namespacesStr = namespacesStr + " " + nm.toXMLString();
		    }

			returnString = returnString + "<" + name + namespacesStr;
		}else {

			returnString = returnString + "<" + name;
		}

		/* Add attributes if they are exist to Node representation */
		if ( attrs != null ) {

			Iterator<Attribute> attrsIt = attrs.listIterator();
			String attributesStr = "";

		    while( attrsIt.hasNext() ) {

		    	Attribute attr = attrsIt.next();
		    	attributesStr = attributesStr + " " + attr.toXMLString();
		    }

			returnString = returnString + attributesStr;
		}

		/** Finish Node representation
		 * If there is no children on this node then we have two cases:
		 * 1) if we have text then the node is a Text Node and finishes after text and,
		 * 2) if we have no text the node is an only attribute Node and finishes after attributes.
		 */
		if ( childrenNodeList == null ) {

			if ( text.isEmpty() ) {

				returnString = returnString + "/>";
			}else {

				returnString = returnString + ">" + text + "</" + name + ">";
			}
		}else {

			returnString = returnString + ">";
		}

		return returnString;
	}

	/**
	 * public String toString(int depth, String identStr)
	 * Returns a indented String representation of the Node. Identq	ation string
	 * is two consecutive space characters.
	 * 
	 * @param depth - the identation depth the Node starts at.
	 * @return String representation of the Node
	 */
	public String toXMLString ( int depth, String identStr ) {
		
		String returnString = "";

		while ( depth > 0 ) {

			returnString = returnString + identStr;
			depth--;
		}

		/** Add namespaces if they are exist and name to Node representation.
		 * If Node belongs to a namespace, then put the nameprefix before name.
		 * If Node is parent Node, then put all namespaces as arguments.
		 */
		if ( namespace != null ) {

			returnString = returnString + "<" + namespace.getPrefix() + ":" + name;
		}else if ( parent == null ) {

			List<Namespace> namespaces = doc.getNamespaces();
			Iterator<Namespace> nmIt = namespaces.listIterator();
			String namespacesStr = "";

		    while( nmIt.hasNext() ) {

		    	Namespace nm = nmIt.next();
		    	namespacesStr = namespacesStr + " " + nm.toXMLString();
		    }

			returnString = returnString + "<" + name + namespacesStr;
		}else {

			returnString = returnString + "<" + name;
		}

		/* Add attributes if they are exist to Node representation */
		if ( attrs != null ) {

			Iterator<Attribute> attrsIt = attrs.listIterator();
			String attributesStr = "";

		    while( attrsIt.hasNext() ) {

		    	Attribute attr = attrsIt.next();
		    	attributesStr = attributesStr + " " + attr.toXMLString();
		    }

			returnString = returnString + attributesStr;
		}

		/** Finish Node representation
		 * If there is no children on this node then we have two cases:
		 * 1) if we have text then the node is a Text Node and finishes after text and,
		 * 2) if we have no text the node is an only attribute Node and finishes after attributes.
		 */
		if ( childrenNodeList == null ) {

			if ( text.isEmpty() ) {

				returnString = returnString + "/>";
			}else {

				returnString = returnString + ">" + text + "</" + name + ">";
			}
		}else {

			returnString = returnString + ">";
		}

		return returnString;
	}
}
