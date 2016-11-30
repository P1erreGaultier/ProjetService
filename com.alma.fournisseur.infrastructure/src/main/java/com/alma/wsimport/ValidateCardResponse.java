
package com.alma.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validateCardReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "validateCardReturn"
})
@XmlRootElement(name = "validateCardResponse")
public class ValidateCardResponse {

    @XmlElement(required = true)
    protected String validateCardReturn;

    /**
     * Obtient la valeur de la propriété validateCardReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidateCardReturn() {
        return validateCardReturn;
    }

    /**
     * Définit la valeur de la propriété validateCardReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidateCardReturn(String value) {
        this.validateCardReturn = value;
    }

}
