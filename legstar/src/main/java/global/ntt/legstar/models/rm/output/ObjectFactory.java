
package global.ntt.legstar.models.rm.output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the global.ntt.legstar.models.rm.output package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RmmscsrlOut_QNAME = new QName("https://legstar.com/test/coxb/lsfileae", "rmmscsrlOut");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: global.ntt.legstar.models.rm.output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RmmscsrlOutRelMast }
     * 
     */
    public RmmscsrlOutRelMast createRmmscsrlOutRelMast() {
        return new RmmscsrlOutRelMast();
    }

    /**
     * Create an instance of {@link RmmscsrlOutRelCd }
     * 
     */
    public RmmscsrlOutRelCd createRmmscsrlOutRelCd() {
        return new RmmscsrlOutRelCd();
    }

    /**
     * Create an instance of {@link RmmscsrlOutRestOfRelKey }
     * 
     */
    public RmmscsrlOutRestOfRelKey createRmmscsrlOutRestOfRelKey() {
        return new RmmscsrlOutRestOfRelKey();
    }

    /**
     * Create an instance of {@link RmmscsrlOutInternetBkInfo }
     * 
     */
    public RmmscsrlOutInternetBkInfo createRmmscsrlOutInternetBkInfo() {
        return new RmmscsrlOutInternetBkInfo();
    }

    /**
     * Create an instance of {@link RmmscsrlOut }
     * 
     */
    public RmmscsrlOut createRmmscsrlOut() {
        return new RmmscsrlOut();
    }

    /**
     * Create an instance of {@link RmmscsrlOutAddlRelInfo }
     * 
     */
    public RmmscsrlOutAddlRelInfo createRmmscsrlOutAddlRelInfo() {
        return new RmmscsrlOutAddlRelInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RmmscsrlOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://legstar.com/test/coxb/lsfileae", name = "rmmscsrlOut")
    public JAXBElement<RmmscsrlOut> createRmmscsrlOut(RmmscsrlOut value) {
        return new JAXBElement<RmmscsrlOut>(_RmmscsrlOut_QNAME, RmmscsrlOut.class, null, value);
    }

}
