
package com.alma.wsimport;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CheckCreditCard", targetNamespace = "http://webservices.alma.org")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CheckCreditCard {


    /**
     * 
     * @param card
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "validateCardReturn", targetNamespace = "http://webservices.alma.org")
    @RequestWrapper(localName = "validateCard", targetNamespace = "http://webservices.alma.org", className = "org.alma.webservices.ValidateCard")
    @ResponseWrapper(localName = "validateCardResponse", targetNamespace = "http://webservices.alma.org", className = "org.alma.webservices.ValidateCardResponse")
    public String validateCard(
        @WebParam(name = "card", targetNamespace = "http://webservices.alma.org")
        String card);

}
