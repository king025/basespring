package global.ntt.legstar.models.rm.output.bind;

import com.legstar.coxb.CobolContext;
import com.legstar.coxb.transform.AbstractHostToXmlTransformer;
import com.legstar.coxb.transform.HostTransformException;

/**
 * Transforms mainframe data to XML.
 * <p/>
 * This is a typical use of this class:
 * <pre>
 *  RmmscsrlOutHostToXmlTransformer transformer = new RmmscsrlOutHostToXmlTransformer();
 *  StringWriter writer = new StringWriter();
 *  transformer.transform(hostByteArray, writer);
 * </pre>
 *
 */
public class RmmscsrlOutHostToXmlTransformer extends AbstractHostToXmlTransformer {

    /**
     * Create a Host to XML transformer using a Host to Java transformer.
     * @throws HostTransformException if transformer cannot be created
     */
    public RmmscsrlOutHostToXmlTransformer() throws HostTransformException {
        super(new RmmscsrlOutHostToJavaTransformer());
    }
    
    /**
     * Create a Host to XML transformer using a specific COBOL parameters set.
     * @param cobolContext the COBOL parameters set.
     * @throws HostTransformException if transformer cannot be created
     */
    public RmmscsrlOutHostToXmlTransformer(
            final CobolContext cobolContext) throws HostTransformException {
        super(new RmmscsrlOutHostToJavaTransformer(cobolContext));
    }

    /**
     * Create a Host to XML transformer using a specific host character set while
     * other COBOL parameters are set by default.
     * @param hostCharset the host character set
     * @throws HostTransformException if transformer cannot be created
     */
    public RmmscsrlOutHostToXmlTransformer(
            final String hostCharset) throws HostTransformException {
        super(new RmmscsrlOutHostToJavaTransformer(hostCharset));
    }
    
    /** {@inheritDoc} */
    public String getElementName() {
        return "RmmscsrlOut";
    }

    /** {@inheritDoc} */
    public String getNamespace() {
        return "https://legstar.com/test/coxb/lsfileae";
    }

    /** {@inheritDoc} */
    public boolean isXmlRootElement() {
        return false;
    }
    
}
