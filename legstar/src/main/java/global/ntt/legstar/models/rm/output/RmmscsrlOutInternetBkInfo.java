
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOutInternetBkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOutInternetBkInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlOutIbAcctInd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutIbBillPayInd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutIbXferFromInd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutIbXferToInd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutIbDownload">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
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
@XmlType(name = "RmmscsrlOutInternetBkInfo", propOrder = {
    "rmmscsrlOutIbAcctInd",
    "rmmscsrlOutIbBillPayInd",
    "rmmscsrlOutIbXferFromInd",
    "rmmscsrlOutIbXferToInd",
    "rmmscsrlOutIbDownload"
})
public class RmmscsrlOutInternetBkInfo
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-IB-ACCT-IND", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(01)", srceLine = 24)
    protected String rmmscsrlOutIbAcctInd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-IB-BILL-PAY-IND", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(01)", srceLine = 25)
    protected String rmmscsrlOutIbBillPayInd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-IB-XFER-FROM-IND", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(01)", srceLine = 26)
    protected String rmmscsrlOutIbXferFromInd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-IB-XFER-TO-IND", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(01)", srceLine = 27)
    protected String rmmscsrlOutIbXferToInd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-IB-DOWNLOAD", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 20, picture = "X(01)", srceLine = 28)
    protected String rmmscsrlOutIbDownload;

    /**
     * Gets the value of the rmmscsrlOutIbAcctInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutIbAcctInd() {
        return rmmscsrlOutIbAcctInd;
    }

    /**
     * Sets the value of the rmmscsrlOutIbAcctInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutIbAcctInd(String value) {
        this.rmmscsrlOutIbAcctInd = value;
    }

    public boolean isSetRmmscsrlOutIbAcctInd() {
        return (this.rmmscsrlOutIbAcctInd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutIbBillPayInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutIbBillPayInd() {
        return rmmscsrlOutIbBillPayInd;
    }

    /**
     * Sets the value of the rmmscsrlOutIbBillPayInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutIbBillPayInd(String value) {
        this.rmmscsrlOutIbBillPayInd = value;
    }

    public boolean isSetRmmscsrlOutIbBillPayInd() {
        return (this.rmmscsrlOutIbBillPayInd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutIbXferFromInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutIbXferFromInd() {
        return rmmscsrlOutIbXferFromInd;
    }

    /**
     * Sets the value of the rmmscsrlOutIbXferFromInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutIbXferFromInd(String value) {
        this.rmmscsrlOutIbXferFromInd = value;
    }

    public boolean isSetRmmscsrlOutIbXferFromInd() {
        return (this.rmmscsrlOutIbXferFromInd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutIbXferToInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutIbXferToInd() {
        return rmmscsrlOutIbXferToInd;
    }

    /**
     * Sets the value of the rmmscsrlOutIbXferToInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutIbXferToInd(String value) {
        this.rmmscsrlOutIbXferToInd = value;
    }

    public boolean isSetRmmscsrlOutIbXferToInd() {
        return (this.rmmscsrlOutIbXferToInd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutIbDownload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutIbDownload() {
        return rmmscsrlOutIbDownload;
    }

    /**
     * Sets the value of the rmmscsrlOutIbDownload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutIbDownload(String value) {
        this.rmmscsrlOutIbDownload = value;
    }

    public boolean isSetRmmscsrlOutIbDownload() {
        return (this.rmmscsrlOutIbDownload!= null);
    }

}
