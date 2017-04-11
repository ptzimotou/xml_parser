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

public class Attribute {
	private Document doc;
	private String name;
	private String value;
	private Namespace namespace;

	/** 
	 * public Attribute(String name, String value)
	 * A constructor that passes as arguement the attribute name
	 * and the attribute value
	 * 
	 * @param name - the attribute name
	 * @param value - the attribute value
	 */
	public Attribute ( String name, String value ) {

		this.name = name;
		this.value = value;
	}

	/** 
	 * public Attribute(String name, String value, Document doc)
	 * Aconstructor that passes as arguement the attribute name,
	 * the attribute value and the Document it belongs.
	 * 
	 * @param name - the attribute name
	 * @param value - the attribute value
	 * @param doc - the Document object this attribute belongs to.
	 */
	public Attribute ( String name, String value, Document doc ) {

		this.name = name;
		this.value = value;
		this.doc = doc;
	}

	/** 
	 * public Attribute(String name, String value, Namespace nm)
	 * Aconstructor that passes as arguement the attribute name,
	 * the attribute value and the Namespace it belongs to.
	 * 
	 * @param name - the attribute name
	 * @param value - the attribute value
	 * @param nm - the Namespace object this attribute belongs to.
	 */
	public Attribute ( String name, String value, Namespace nm ) {

		this.name = name;
		this.value = value;
		namespace = nm;
	}

	/** 
	 * public Attribute(String name, String value, Document doc, Namespace nm)
	 * Aconstructor that passes as arguement the attribute name,
	 * the attribute value, thee Document it belongs
	 * and the Namespace it belongs to.
	 * 
	 * @param name - the attribute name
	 * @param value - the attribute value
	 * @param doc - the Document object this attribute belongs to
	 * @param nm - the Namespace object this attribute belongs to.
	 */
	public Attribute ( String name, String value, Document doc, Namespace nm ) {

		this.name = name;
		this.value = value;
		this.doc = doc;
		namespace = nm;
	}

	/** 
	 * public void setName(String name)
	 * Set Attribute name
	 * 
	 * @param name - the name of the attribute without any namespace prefix
	 */
	public void setName ( String name ) {
		
		this.name = name;
	}

	/** 
	 * public void setValue(String value)
	 * Set Attribute value
	 * 
	 * @param value - the attribute value
	 */
	public void setValue ( String value ) {
		
		this.value = value;
	}

	/** 
	 * public String getName()
	 * Returns the attribute name
	 *
	 * @return attribute name
	 */
	public String getName ( ) {

		return name;
	}

	/** 
	 * public String getValue()
	 * Return the attribute value
	 *
	 * @return attribute value
	 */
	public String getValue ( ) {

		return value;
	}

	/** 
	 * public Namespace getNamespace()
	 * Returns a reference to the Namespace the Attribute belongs to.
	 *
	 * @return Namespace
	 */
	public Namespace getNamespace ( ) {
		
		return namespace;
	}

	/** 
	 * public void setNamespace(Namespace nm)
	 * Sets the Namespace the Attribute belongs to.
	 */
	public void setNamespace ( Namespace nm ) {
		
		namespace = nm;
	}

	/** 
	 * public String toString()
	 * Returns a String representation of the Attribute object
	 * 
	 * @return String representation of the Attribute object
	 * @overrides toString in class Object
	 */
	public String toXMLString ( ) {

		return name + "=\"" + value + "\"";
	}

}
