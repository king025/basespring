
package global.ntt.legstar.models.rm.input;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for Rmacctno complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rmacctno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmacctnoFromCustCtls" type="{https://legstar.com/test/coxb/lsfileae}RmacctnoFromCustCtls"/>
 *         &lt;element name="rmacctnoFromCustNbr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmacctnoNextItemKey">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="55"/>
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
@XmlType(name = "Rmacctno", propOrder = {
    "rmacctnoFromCustCtls",
    "rmacctnoFromCustNbr",
    "rmacctnoNextItemKey"
})
public class Rmacctno
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-CTLS", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 2)
    protected RmacctnoFromCustCtls rmacctnoFromCustCtls;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-NBR", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(14)", srceLine = 7)
    protected String rmacctnoFromCustNbr;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-NEXT-ITEM-KEY", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 5, picture = "X(55)", srceLine = 8)
    protected String rmacctnoNextItemKey;

    /**
     * Gets the value of the rmacctnoFromCustCtls property.
     * 
     * @return
     *     possible object is
     *     {@link RmacctnoFromCustCtls }
     *     
     */
    public RmacctnoFromCustCtls getRmacctnoFromCustCtls() {
        return rmacctnoFromCustCtls;
    }

    /**
     * Sets the value of the rmacctnoFromCustCtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link RmacctnoFromCustCtls }
     *     
     */
    public void setRmacctnoFromCustCtls(RmacctnoFromCustCtls value) {
        this.rmacctnoFromCustCtls = value;
    }

    public boolean isSetRmacctnoFromCustCtls() {
        return (this.rmacctnoFromCustCtls!= null);
    }

    /**
     * Gets the value of the rmacctnoFromCustNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoFromCustNbr() {
        return rmacctnoFromCustNbr;
    }

    /**
     * Sets the value of the rmacctnoFromCustNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoFromCustNbr(String value) {
        this.rmacctnoFromCustNbr = value;
    }

    public boolean isSetRmacctnoFromCustNbr() {
        return (this.rmacctnoFromCustNbr!= null);
    }

    /**
     * Gets the value of the rmacctnoNextItemKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoNextItemKey() {
        return rmacctnoNextItemKey;
    }

    /**
     * Sets the value of the rmacctnoNextItemKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoNextItemKey(String value) {
        this.rmacctnoNextItemKey = value;
    }

    public boolean isSetRmacctnoNextItemKey() {
        return (this.rmacctnoNextItemKey!= null);
    }

}
