/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class MailStopNumber implements XAL, GrPostal, Child, Copyable {
	private String content;
	private String nameNumberSeparator;
	private String code;
	private ModelObject parent;
	
	public String getContent() {
		return content;
	}

	public String getNameNumberSeparator() {
		return nameNumberSeparator;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNameNumberSeparator() {
		return nameNumberSeparator != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNameNumberSeparator(String nameNumberSeparator) {
		this.nameNumberSeparator = nameNumberSeparator;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNameNumberSeparator() {
		nameNumberSeparator = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.MAIL_STOP_NUMBER;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MailStopNumber(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MailStopNumber copy = (target == null) ? new MailStopNumber() : (MailStopNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNameNumberSeparator())
			copy.setNameNumberSeparator(copyBuilder.copy(nameNumberSeparator));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
