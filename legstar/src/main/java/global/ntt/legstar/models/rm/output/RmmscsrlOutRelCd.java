
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOutRelCd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOutRelCd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlOutFromRelCd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutToRelCd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RmmscsrlOutRelCd", propOrder = {
    "rmmscsrlOutFromRelCd",
    "rmmscsrlOutToRelCd"
})
public class RmmscsrlOutRelCd
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-FROM-REL-CD", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(03)", srceLine = 13)
    protected String rmmscsrlOutFromRelCd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-TO-REL-CD", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(03)", srceLine = 14)
    protected String rmmscsrlOutToRelCd;

    /**
     * Gets the value of the rmmscsrlOutFromRelCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutFromRelCd() {
        return rmmscsrlOutFromRelCd;
    }

    /**
     * Sets the value of the rmmscsrlOutFromRelCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutFromRelCd(String value) {
        this.rmmscsrlOutFromRelCd = value;
    }

    public boolean isSetRmmscsrlOutFromRelCd() {
        return (this.rmmscsrlOutFromRelCd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutToRelCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutToRelCd() {
        return rmmscsrlOutToRelCd;
    }

    /**
     * Sets the value of the rmmscsrlOutToRelCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutToRelCd(String value) {
        this.rmmscsrlOutToRelCd = value;
    }

    public boolean isSetRmmscsrlOutToRelCd() {
        return (this.rmmscsrlOutToRelCd!= null);
    }

}
