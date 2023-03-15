
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOutAddlRelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOutAddlRelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlOutApplId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutLegalTitlPos">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutInternetBkInfo" type="{https://legstar.com/test/coxb/lsfileae}RmmscsrlOutInternetBkInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RmmscsrlOutAddlRelInfo", propOrder = {
    "rmmscsrlOutApplId",
    "rmmscsrlOutLegalTitlPos",
    "rmmscsrlOutInternetBkInfo"
})
public class RmmscsrlOutAddlRelInfo
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-APPL-ID", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(02)", srceLine = 21)
    protected String rmmscsrlOutApplId;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-LEGAL-TITL-POS", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(01)", srceLine = 22)
    protected String rmmscsrlOutLegalTitlPos;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-INTERNET-BK-INFO", type = CobolType.GROUP_ITEM, levelNumber = 15, srceLine = 23)
    protected RmmscsrlOutInternetBkInfo rmmscsrlOutInternetBkInfo;

    /**
     * Gets the value of the rmmscsrlOutApplId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutApplId() {
        return rmmscsrlOutApplId;
    }

    /**
     * Sets the value of the rmmscsrlOutApplId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutApplId(String value) {
        this.rmmscsrlOutApplId = value;
    }

    public boolean isSetRmmscsrlOutApplId() {
        return (this.rmmscsrlOutApplId!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutLegalTitlPos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutLegalTitlPos() {
        return rmmscsrlOutLegalTitlPos;
    }

    /**
     * Sets the value of the rmmscsrlOutLegalTitlPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutLegalTitlPos(String value) {
        this.rmmscsrlOutLegalTitlPos = value;
    }

    public boolean isSetRmmscsrlOutLegalTitlPos() {
        return (this.rmmscsrlOutLegalTitlPos!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutInternetBkInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RmmscsrlOutInternetBkInfo }
     *     
     */
    public RmmscsrlOutInternetBkInfo getRmmscsrlOutInternetBkInfo() {
        return rmmscsrlOutInternetBkInfo;
    }

    /**
     * Sets the value of the rmmscsrlOutInternetBkInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmmscsrlOutInternetBkInfo }
     *     
     */
    public void setRmmscsrlOutInternetBkInfo(RmmscsrlOutInternetBkInfo value) {
        this.rmmscsrlOutInternetBkInfo = value;
    }

    public boolean isSetRmmscsrlOutInternetBkInfo() {
        return (this.rmmscsrlOutInternetBkInfo!= null);
    }

}
