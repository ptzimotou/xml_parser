/**
 * 
 * 
 * @author Tzimotoudis Panagiotis
 * @authos Tziokas George
 * @version 1.0
 * @since 2015-03-27
 */

package xml_parser;
import 	xml_parser.*;
import java.lang.*;

public class XMLParserTest {

  public static void main(String args[]) {
    DocumentBuilder docBuilder = new DocumentBuilder( );
    Document doc = docBuilder.getDocument( args[0] );
    System.out.println( doc.toXMLString( "  " ) );
  }
}