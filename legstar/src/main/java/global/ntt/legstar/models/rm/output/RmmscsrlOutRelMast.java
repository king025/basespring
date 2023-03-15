
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOutRelMast complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOutRelMast">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlOutRestOfRelKey" type="{https://legstar.com/test/coxb/lsfileae}RmmscsrlOutRestOfRelKey"/>
 *         &lt;element name="rmmscsrlOutAddlRelInfo" type="{https://legstar.com/test/coxb/lsfileae}RmmscsrlOutAddlRelInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RmmscsrlOutRelMast", propOrder = {
    "rmmscsrlOutRestOfRelKey",
    "rmmscsrlOutAddlRelInfo"
})
public class RmmscsrlOutRelMast
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-REST-OF-REL-KEY", type = CobolType.GROUP_ITEM, levelNumber = 10, srceLine = 9)
    protected RmmscsrlOutRestOfRelKey rmmscsrlOutRestOfRelKey;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-ADDL-REL-INFO", type = CobolType.GROUP_ITEM, levelNumber = 10, srceLine = 20)
    protected RmmscsrlOutAddlRelInfo rmmscsrlOutAddlRelInfo;

    /**
     * Gets the value of the rmmscsrlOutRestOfRelKey property.
     * 
     * @return
     *     possible object is
     *     {@link RmmscsrlOutRestOfRelKey }
     *     
     */
    public RmmscsrlOutRestOfRelKey getRmmscsrlOutRestOfRelKey() {
        return rmmscsrlOutRestOfRelKey;
    }

    /**
     * Sets the value of the rmmscsrlOutRestOfRelKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmmscsrlOutRestOfRelKey }
     *     
     */
    public void setRmmscsrlOutRestOfRelKey(RmmscsrlOutRestOfRelKey value) {
        this.rmmscsrlOutRestOfRelKey = value;
    }

    public boolean isSetRmmscsrlOutRestOfRelKey() {
        return (this.rmmscsrlOutRestOfRelKey!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutAddlRelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RmmscsrlOutAddlRelInfo }
     *     
     */
    public RmmscsrlOutAddlRelInfo getRmmscsrlOutAddlRelInfo() {
        return rmmscsrlOutAddlRelInfo;
    }

    /**
     * Sets the value of the rmmscsrlOutAddlRelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmmscsrlOutAddlRelInfo }
     *     
     */
    public void setRmmscsrlOutAddlRelInfo(RmmscsrlOutAddlRelInfo value) {
        this.rmmscsrlOutAddlRelInfo = value;
    }

    public boolean isSetRmmscsrlOutAddlRelInfo() {
        return (this.rmmscsrlOutAddlRelInfo!= null);
    }

}
