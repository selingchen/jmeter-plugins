/*!
 * AtlantBH Custom Jmeter Components v1.0.0
 * http://www.atlantbh.com/jmeter-components/
 *
 * Copyright 2011, AtlantBH
 *
 * Licensed under the under the Apache License, Version 2.0.
 */
package com.atlantbh.jmeter.plugins.jsonutils.jsonpathassertion.gui;

import com.atlantbh.jmeter.plugins.jsonutils.jsonpathassertion.JSONPathAssertion;
import kg.apc.jmeter.JMeterPluginsUtils;
import org.apache.jmeter.assertions.gui.AbstractAssertionGui;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.gui.JLabeledTextField;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Java class representing GUI for the JSON Path Assertion component in JMeter
 */
public class JSONPathAssertionGui extends AbstractAssertionGui implements ChangeListener {

    //private static final Logger log = LoggingManager.getLoggerForClass();
    private static final long serialVersionUID = 1L;
    private JLabeledTextField jsonPath = null;
    private JLabeledTextField jsonValue = null;
    private JCheckBox jsonValidation = null;
    private JCheckBox expectNull = null;
    private static final String WIKIPAGE = "JSONPathAssertion";

    public JSONPathAssertionGui() {
        init();
    }

    public void init() {
        setLayout(new BorderLayout());
        setBorder(makeBorder());
        add(JMeterPluginsUtils.addHelpLinkToPanel(makeTitlePanel(), WIKIPAGE), BorderLayout.NORTH);

        VerticalPanel panel = new VerticalPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        jsonPath = new JLabeledTextField("JSON Path: ");
        jsonValidation = new JCheckBox("Validate against expected value");
        jsonValue = new JLabeledTextField("Expected Value: ");
        expectNull = new JCheckBox("Expect null");

        jsonValidation.addChangeListener(this);
        expectNull.addChangeListener(this);

        panel.add(jsonPath);
        panel.add(jsonValidation);
        panel.add(jsonValue);
        panel.add(expectNull);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void clearGui() {
        super.clearGui();
        jsonPath.setText("");
        jsonValue.setText("");
        jsonValidation.setSelected(false);
        expectNull.setSelected(false);
    }

    @Override
    public TestElement createTestElement() {
        JSONPathAssertion jpAssertion = new JSONPathAssertion();
        modifyTestElement(jpAssertion);
        jpAssertion.setComment(JMeterPluginsUtils.getWikiLinkText(WIKIPAGE));
        return jpAssertion;
    }

    @Override
    public String getLabelResource() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getStaticLabel() {
        return JMeterPluginsUtils.prefixLabel("JSON Path Assertion");
    }

    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);
        if (element instanceof JSONPathAssertion) {
            JSONPathAssertion jpAssertion = (JSONPathAssertion) element;
            jpAssertion.setJsonPath(jsonPath.getText());
            jpAssertion.setExpectedValue(jsonValue.getText());
            jpAssertion.setJsonValidationBool(jsonValidation.isSelected());
            jpAssertion.setExpectNull(expectNull.isSelected());
        }
    }

    @Override
    public void configure(TestElement element) {
        super.configure(element);
        JSONPathAssertion jpAssertion = (JSONPathAssertion) element;
        jsonPath.setText(jpAssertion.getJsonPath());
        jsonValue.setText(jpAssertion.getExpectedValue());
        jsonValidation.setSelected(jpAssertion.isJsonValidationBool());
        expectNull.setSelected(jpAssertion.isExpectNull());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        jsonValue.setEnabled(jsonValidation.isSelected() && !expectNull.isSelected());
    }
}