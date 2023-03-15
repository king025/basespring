
package global.ntt.legstar.models.rm.output;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmmscsrlOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmmscsrlOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmmscsrlCtr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutFromCustNbr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutNextItemFlag">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutNextItemKey">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="55"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutReturnCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutReturnMsg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmmscsrlOutRelMast" type="{https://legstar.com/test/coxb/lsfileae}RmmscsrlOutRelMast"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RmmscsrlOut", propOrder = {
    "rmmscsrlCtr",
    "rmmscsrlOutFromCustNbr",
    "rmmscsrlOutNextItemFlag",
    "rmmscsrlOutNextItemKey",
    "rmmscsrlOutReturnCode",
    "rmmscsrlOutReturnMsg",
    "rmmscsrlOutRelMast"
})
public class RmmscsrlOut
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @CobolElement(cobolName = "RMMSCSRL-CTR", type = CobolType.ZONED_DECIMAL_ITEM, levelNumber = 5, isSigned = false, totalDigits = 3, picture = "9(03)", srceLine = 2)
    protected int rmmscsrlCtr;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-FROM-CUST-NBR", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(14)", srceLine = 3)
    protected String rmmscsrlOutFromCustNbr;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-NEXT-ITEM-FLAG", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(01)", srceLine = 4)
    protected String rmmscsrlOutNextItemFlag;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-NEXT-ITEM-KEY", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(55)", srceLine = 5)
    protected String rmmscsrlOutNextItemKey;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-RETURN-CODE", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(02)", srceLine = 6)
    protected String rmmscsrlOutReturnCode;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-RETURN-MSG", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(40)", srceLine = 7)
    protected String rmmscsrlOutReturnMsg;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMMSCSRL-OUT-REL-MAST", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 8)
    protected RmmscsrlOutRelMast rmmscsrlOutRelMast;

    /**
     * Gets the value of the rmmscsrlCtr property.
     * 
     */
    public int getRmmscsrlCtr() {
        return rmmscsrlCtr;
    }

    /**
     * Sets the value of the rmmscsrlCtr property.
     * 
     */
    public void setRmmscsrlCtr(int value) {
        this.rmmscsrlCtr = value;
    }

    public boolean isSetRmmscsrlCtr() {
        return true;
    }

    /**
     * Gets the value of the rmmscsrlOutFromCustNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutFromCustNbr() {
        return rmmscsrlOutFromCustNbr;
    }

    /**
     * Sets the value of the rmmscsrlOutFromCustNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutFromCustNbr(String value) {
        this.rmmscsrlOutFromCustNbr = value;
    }

    public boolean isSetRmmscsrlOutFromCustNbr() {
        return (this.rmmscsrlOutFromCustNbr!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutNextItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutNextItemFlag() {
        return rmmscsrlOutNextItemFlag;
    }

    /**
     * Sets the value of the rmmscsrlOutNextItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutNextItemFlag(String value) {
        this.rmmscsrlOutNextItemFlag = value;
    }

    public boolean isSetRmmscsrlOutNextItemFlag() {
        return (this.rmmscsrlOutNextItemFlag!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutNextItemKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutNextItemKey() {
        return rmmscsrlOutNextItemKey;
    }

    /**
     * Sets the value of the rmmscsrlOutNextItemKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutNextItemKey(String value) {
        this.rmmscsrlOutNextItemKey = value;
    }

    public boolean isSetRmmscsrlOutNextItemKey() {
        return (this.rmmscsrlOutNextItemKey!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutReturnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutReturnCode() {
        return rmmscsrlOutReturnCode;
    }

    /**
     * Sets the value of the rmmscsrlOutReturnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutReturnCode(String value) {
        this.rmmscsrlOutReturnCode = value;
    }

    public boolean isSetRmmscsrlOutReturnCode() {
        return (this.rmmscsrlOutReturnCode!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutReturnMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmmscsrlOutReturnMsg() {
        return rmmscsrlOutReturnMsg;
    }

    /**
     * Sets the value of the rmmscsrlOutReturnMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmmscsrlOutReturnMsg(String value) {
        this.rmmscsrlOutReturnMsg = value;
    }

    public boolean isSetRmmscsrlOutReturnMsg() {
        return (this.rmmscsrlOutReturnMsg!= null);
    }

    /**
     * Gets the value of the rmmscsrlOutRelMast property.
     * 
     * @return
     *     possible object is
     *     {@link RmmscsrlOutRelMast }
     *     
     */
    public RmmscsrlOutRelMast getRmmscsrlOutRelMast() {
        return rmmscsrlOutRelMast;
    }

    /**
     * Sets the value of the rmmscsrlOutRelMast property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmmscsrlOutRelMast }
     *     
     */
    public void setRmmscsrlOutRelMast(RmmscsrlOutRelMast value) {
        this.rmmscsrlOutRelMast = value;
    }

    public boolean isSetRmmscsrlOutRelMast() {
        return (this.rmmscsrlOutRelMast!= null);
    }

}
