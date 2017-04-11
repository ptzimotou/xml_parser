/**
 * 
 * 
 * @author Tzimotoudis Panagiotis
 * @authos Tziokas George
 * @version 1.0
 * @since 2015-03-27
 */

package xml_parser;
import java.lang.Object;

public class Namespace extends Object {
	private String prefix;
	private String uri;

	/** 
	 * public Namespace(String prefix, String uri)
	 * Creates a new Namespace object by passing the
	 * prefix and the URI of the XML Namespace
	 */
	public Namespace ( String prefix, String uri ) {
		this.prefix = prefix;
		this.uri = uri;
	}

	/** 
	 * public String getPrefix()
	 * Returns the Namespace prefix as a String
	 *
	 * @return Namespace prefix
	 */
	public String getPrefix ( ) {
		
		return prefix;
	}

	/** 
	 * public String getURI()
	 * Returns the URI of the Namespace as a String
	 * 
	 * @return URI
	 */
	public String getURI ( ) {

		return uri;
	}

	/** 
	 * public String toString()
	 * Returns a String representation of the Namespace object
	 * 
	 * @return String representation of Namespace
	 * @override toString in class Object
	 */
	public String toXMLString ( ) {

		return "xmlns:" + prefix + "=\"" + uri + "\"";
	}
}
