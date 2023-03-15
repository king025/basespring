
package global.ntt.legstar.models.rm.input;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for RmacctnoFromCustCtls complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RmacctnoFromCustCtls">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmacctnoFromCustCtl1">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmacctnoFromCustCtl2">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmacctnoFromCustCtl3">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rmacctnoFromCustCtl4">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
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
@XmlType(name = "RmacctnoFromCustCtls", propOrder = {
    "rmacctnoFromCustCtl1",
    "rmacctnoFromCustCtl2",
    "rmacctnoFromCustCtl3",
    "rmacctnoFromCustCtl4"
})
public class RmacctnoFromCustCtls
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-CTL1", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(4)", srceLine = 3)
    protected String rmacctnoFromCustCtl1;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-CTL2", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(4)", srceLine = 4)
    protected String rmacctnoFromCustCtl2;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-CTL3", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(4)", srceLine = 5)
    protected String rmacctnoFromCustCtl3;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RMACCTNO-FROM-CUST-CTL4", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(4)", srceLine = 6)
    protected String rmacctnoFromCustCtl4;

    /**
     * Gets the value of the rmacctnoFromCustCtl1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoFromCustCtl1() {
        return rmacctnoFromCustCtl1;
    }

    /**
     * Sets the value of the rmacctnoFromCustCtl1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoFromCustCtl1(String value) {
        this.rmacctnoFromCustCtl1 = value;
    }

    public boolean isSetRmacctnoFromCustCtl1() {
        return (this.rmacctnoFromCustCtl1 != null);
    }

    /**
     * Gets the value of the rmacctnoFromCustCtl2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoFromCustCtl2() {
        return rmacctnoFromCustCtl2;
    }

    /**
     * Sets the value of the rmacctnoFromCustCtl2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoFromCustCtl2(String value) {
        this.rmacctnoFromCustCtl2 = value;
    }

    public boolean isSetRmacctnoFromCustCtl2() {
        return (this.rmacctnoFromCustCtl2 != null);
    }

    /**
     * Gets the value of the rmacctnoFromCustCtl3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoFromCustCtl3() {
        return rmacctnoFromCustCtl3;
    }

    /**
     * Sets the value of the rmacctnoFromCustCtl3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoFromCustCtl3(String value) {
        this.rmacctnoFromCustCtl3 = value;
    }

    public boolean isSetRmacctnoFromCustCtl3() {
        return (this.rmacctnoFromCustCtl3 != null);
    }

    /**
     * Gets the value of the rmacctnoFromCustCtl4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmacctnoFromCustCtl4() {
        return rmacctnoFromCustCtl4;
    }

    /**
     * Sets the value of the rmacctnoFromCustCtl4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmacctnoFromCustCtl4(String value) {
        this.rmacctnoFromCustCtl4 = value;
    }

    public boolean isSetRmacctnoFromCustCtl4() {
        return (this.rmacctnoFromCustCtl4 != null);
    }

}
