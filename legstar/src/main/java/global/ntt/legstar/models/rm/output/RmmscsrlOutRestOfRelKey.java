
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOutRestOfRelKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOutRestOfRelKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlOutToEntCd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutToApplCd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutRelCd" type="{https://legstar.com/test/coxb/lsfileae}RmmscsrlOutRelCd"/>
 *         &lt;element name="rmmscsrlOutCustCtl1">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutCustCtl2">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutCustCtl3">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutCustCtl4">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutToAcctKey">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="27"/>
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
@XmlType(name = "RmmscsrlOutRestOfRelKey", propOrder = {
    "rmmscsrlOutToEntCd",
    "rmmscsrlOutToApplCd",
    "rmmscsrlOutRelCd",
    "rmmscsrlOutCustCtl1",
    "rmmscsrlOutCustCtl2",
    "rmmscsrlOutCustCtl3",
    "rmmscsrlOutCustCtl4",
    "rmmscsrlOutToAcctKey"
})
public class RmmscsrlOutRestOfRelKey
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-TO-ENT-CD", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(02)", srceLine = 10)
    protected String rmmscsrlOutToEntCd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-TO-APPL-CD", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(02)", srceLine = 11)
    protected String rmmscsrlOutToApplCd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-REL-CD", type = CobolType.GROUP_ITEM, levelNumber = 15, srceLine = 12)
    protected RmmscsrlOutRelCd rmmscsrlOutRelCd;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-CUST-CTL1", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(04)", srceLine = 15)
    protected String rmmscsrlOutCustCtl1;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-CUST-CTL2", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(04)", srceLine = 16)
    protected String rmmscsrlOutCustCtl2;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-CUST-CTL3", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(04)", srceLine = 17)
    protected String rmmscsrlOutCustCtl3;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-CUST-CTL4", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(04)", srceLine = 18)
    protected String rmmscsrlOutCustCtl4;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-TO-ACCT-KEY", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 15, picture = "X(27)", srceLine = 19)
    protected String rmmscsrlOutToAcctKey;

    /**
     * Gets the value of the rmmscsrlOutToEntCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutToEntCd() {
        return rmmscsrlOutToEntCd;
    }

    /**
     * Sets the value of the rmmscsrlOutToEntCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutToEntCd(String value) {
        this.rmmscsrlOutToEntCd = value;
    }

    public boolean isSetRmmscsrlOutToEntCd() {
        return (this.rmmscsrlOutToEntCd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutToApplCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutToApplCd() {
        return rmmscsrlOutToApplCd;
    }

    /**
     * Sets the value of the rmmscsrlOutToApplCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutToApplCd(String value) {
        this.rmmscsrlOutToApplCd = value;
    }

    public boolean isSetRmmscsrlOutToApplCd() {
        return (this.rmmscsrlOutToApplCd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutRelCd property.
     * 
     * @return
     *     possible object is
     *     {@link RmmscsrlOutRelCd }
     *     
     */
    public RmmscsrlOutRelCd getRmmscsrlOutRelCd() {
        return rmmscsrlOutRelCd;
    }

    /**
     * Sets the value of the rmmscsrlOutRelCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmmscsrlOutRelCd }
     *     
     */
    public void setRmmscsrlOutRelCd(RmmscsrlOutRelCd value) {
        this.rmmscsrlOutRelCd = value;
    }

    public boolean isSetRmmscsrlOutRelCd() {
        return (this.rmmscsrlOutRelCd!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutCustCtl1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutCustCtl1() {
        return rmmscsrlOutCustCtl1;
    }

    /**
     * Sets the value of the rmmscsrlOutCustCtl1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutCustCtl1(String value) {
        this.rmmscsrlOutCustCtl1 = value;
    }

    public boolean isSetRmmscsrlOutCustCtl1() {
        return (this.rmmscsrlOutCustCtl1 != null);
    }

    /**
     * Gets the value of the rmmscsrlOutCustCtl2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutCustCtl2() {
        return rmmscsrlOutCustCtl2;
    }

    /**
     * Sets the value of the rmmscsrlOutCustCtl2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutCustCtl2(String value) {
        this.rmmscsrlOutCustCtl2 = value;
    }

    public boolean isSetRmmscsrlOutCustCtl2() {
        return (this.rmmscsrlOutCustCtl2 != null);
    }

    /**
     * Gets the value of the rmmscsrlOutCustCtl3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutCustCtl3() {
        return rmmscsrlOutCustCtl3;
    }

    /**
     * Sets the value of the rmmscsrlOutCustCtl3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutCustCtl3(String value) {
        this.rmmscsrlOutCustCtl3 = value;
    }

    public boolean isSetRmmscsrlOutCustCtl3() {
        return (this.rmmscsrlOutCustCtl3 != null);
    }

    /**
     * Gets the value of the rmmscsrlOutCustCtl4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutCustCtl4() {
        return rmmscsrlOutCustCtl4;
    }

    /**
     * Sets the value of the rmmscsrlOutCustCtl4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutCustCtl4(String value) {
        this.rmmscsrlOutCustCtl4 = value;
    }

    public boolean isSetRmmscsrlOutCustCtl4() {
        return (this.rmmscsrlOutCustCtl4 != null);
    }

    /**
     * Gets the value of the rmmscsrlOutToAcctKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutToAcctKey() {
        return rmmscsrlOutToAcctKey;
    }

    /**
     * Sets the value of the rmmscsrlOutToAcctKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutToAcctKey(String value) {
        this.rmmscsrlOutToAcctKey = value;
    }

    public boolean isSetRmmscsrlOutToAcctKey() {
        return (this.rmmscsrlOutToAcctKey!= null);
    }

}
