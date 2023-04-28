//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.28 at 12:39:49 PM IDT 
//


package mta.course.java.stepper.xmlparse;

import javax.xml.bind.annotation.*;


/**
 import javax.xml.bind.annotation.XmlType;
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}ST-FlowOutput"/>
 *         &lt;element ref="{}ST-CustomMappings" minOccurs="0"/>
 *         &lt;element ref="{}ST-FlowLevelAliasing" minOccurs="0"/>
 *         &lt;element ref="{}ST-StepsInFlow"/>
 *         &lt;element name="ST-FlowDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "ST-Flow")
public class STFlow {

    @XmlElement(name = "ST-FlowOutput", required = true)
    protected String stFlowOutput;
    @XmlElement(name = "ST-CustomMappings")
    protected STCustomMappings stCustomMappings;
    @XmlElement(name = "ST-FlowLevelAliasing")
    protected STFlowLevelAliasing stFlowLevelAliasing;
    @XmlElement(name = "ST-StepsInFlow", required = true)
    protected STStepsInFlow stStepsInFlow;
    @XmlElement(name = "ST-FlowDescription", required = true)
    protected String stFlowDescription;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the stFlowOutput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTFlowOutput() {
        return stFlowOutput;
    }

    /**
     * Sets the value of the stFlowOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTFlowOutput(String value) {
        this.stFlowOutput = value;
    }

    /**
     * Gets the value of the stCustomMappings property.
     * 
     * @return
     *     possible object is
     *     {@link STCustomMappings }
     *     
     */
    public STCustomMappings getSTCustomMappings() {
        return stCustomMappings;
    }

    /**
     * Sets the value of the stCustomMappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link STCustomMappings }
     *     
     */
    public void setSTCustomMappings(STCustomMappings value) {
        this.stCustomMappings = value;
    }

    /**
     * Gets the value of the stFlowLevelAliasing property.
     * 
     * @return
     *     possible object is
     *     {@link STFlowLevelAliasing }
     *     
     */
    public STFlowLevelAliasing getSTFlowLevelAliasing() {
        return stFlowLevelAliasing;
    }

    /**
     * Sets the value of the stFlowLevelAliasing property.
     * 
     * @param value
     *     allowed object is
     *     {@link STFlowLevelAliasing }
     *     
     */
    public void setSTFlowLevelAliasing(STFlowLevelAliasing value) {
        this.stFlowLevelAliasing = value;
    }

    /**
     * Gets the value of the stStepsInFlow property.
     * 
     * @return
     *     possible object is
     *     {@link STStepsInFlow }
     *     
     */
    public STStepsInFlow getSTStepsInFlow() {
        return stStepsInFlow;
    }

    /**
     * Sets the value of the stStepsInFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link STStepsInFlow }
     *     
     */
    public void setSTStepsInFlow(STStepsInFlow value) {
        this.stStepsInFlow = value;
    }

    /**
     * Gets the value of the stFlowDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTFlowDescription() {
        return stFlowDescription;
    }

    /**
     * Sets the value of the stFlowDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTFlowDescription(String value) {
        this.stFlowDescription = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public String getStFlowOutput() {
        return stFlowOutput;
    }

    public void setStFlowOutput(String stFlowOutput) {
        this.stFlowOutput = stFlowOutput;
    }

    public STCustomMappings getStCustomMappings() {
        return stCustomMappings;
    }

    public void setStCustomMappings(STCustomMappings stCustomMappings) {
        this.stCustomMappings = stCustomMappings;
    }

    public STFlowLevelAliasing getStFlowLevelAliasing() {
        return stFlowLevelAliasing;
    }

    public void setStFlowLevelAliasing(STFlowLevelAliasing stFlowLevelAliasing) {
        this.stFlowLevelAliasing = stFlowLevelAliasing;
    }

    public STStepsInFlow getStStepsInFlow() {
        return stStepsInFlow;
    }

    public void setStStepsInFlow(STStepsInFlow stStepsInFlow) {
        this.stStepsInFlow = stStepsInFlow;
    }

    public String getStFlowDescription() {
        return stFlowDescription;
    }

    public void setStFlowDescription(String stFlowDescription) {
        this.stFlowDescription = stFlowDescription;
    }
}
