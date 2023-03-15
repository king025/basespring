package global.ntt.legstar.models.rm.output.bind;

import com.legstar.coxb.transform.AbstractXmlTransformers;
import com.legstar.coxb.transform.HostTransformException;

/**
 * XML Transformers provider for RmmscsrlOut.
 *
 */
public class RmmscsrlOutXmlTransformers extends AbstractXmlTransformers {

    /**
     * Create a set of directional transformers.
     * @throws HostTransformException if transformer cannot be created
     */
    public RmmscsrlOutXmlTransformers() throws HostTransformException {
        super(new RmmscsrlOutXmlToHostTransformer(),
                new RmmscsrlOutHostToXmlTransformer());
    }

}
