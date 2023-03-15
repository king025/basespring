package global.ntt.legstar.models.rm.input.bind;

import com.legstar.coxb.transform.AbstractXmlTransformers;
import com.legstar.coxb.transform.HostTransformException;

/**
 * XML Transformers provider for Rmacctno.
 *
 */
public class RmacctnoXmlTransformers extends AbstractXmlTransformers {

    /**
     * Create a set of directional transformers.
     * @throws HostTransformException if transformer cannot be created
     */
    public RmacctnoXmlTransformers() throws HostTransformException {
        super(new RmacctnoXmlToHostTransformer(),
                new RmacctnoHostToXmlTransformer());
    }

}
