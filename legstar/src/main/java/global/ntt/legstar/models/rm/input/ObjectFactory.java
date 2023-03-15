
package global.ntt.legstar.models.rm.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the global.ntt.legstar.models.rm.input package. 
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

    private final static QName _Rmacctno_QNAME = new QName("https://legstar.com/test/coxb/lsfileae", "rmacctno");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: global.ntt.legstar.models.rm.input
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RmacctnoFromCustCtls }
     * 
     */
    public RmacctnoFromCustCtls createRmacctnoFromCustCtls() {
        return new RmacctnoFromCustCtls();
    }

    /**
     * Create an instance of {@link Rmacctno }
     * 
     */
    public Rmacctno createRmacctno() {
        return new Rmacctno();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rmacctno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://legstar.com/test/coxb/lsfileae", name = "rmacctno")
    public JAXBElement<Rmacctno> createRmacctno(Rmacctno value) {
        return new JAXBElement<Rmacctno>(_Rmacctno_QNAME, Rmacctno.class, null, value);
    }

}
