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

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class PostalCode implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PostalCodeNumber> postalCodeNumber;
	private List<PostalCodeNumberExtension> postalCodeNumberExtension;
	private PostTown postTown;
	private String type;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		if (this.postalCodeNumber == null)
			this.postalCodeNumber = new ChildList<PostalCodeNumber>(this);

		this.postalCodeNumber.add(postalCodeNumber);
	}

	public void addPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		if (this.postalCodeNumberExtension == null)
			this.postalCodeNumberExtension = new ChildList<PostalCodeNumberExtension>(this);

		this.postalCodeNumberExtension.add(postalCodeNumberExtension);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public PostTown getPostTown() {
		return postTown;
	}

	public List<PostalCodeNumber> getPostalCodeNumber() {
		if (postalCodeNumber == null)
			postalCodeNumber = new ChildList<PostalCodeNumber>(this);

		return postalCodeNumber;
	}

	public List<PostalCodeNumberExtension> getPostalCodeNumberExtension() {
		if (postalCodeNumberExtension == null)
			postalCodeNumberExtension = new ChildList<PostalCodeNumberExtension>(this);

		return postalCodeNumberExtension;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetPostTown() {
		return postTown != null;
	}

	public boolean isSetPostalCodeNumber() {
		return postalCodeNumber != null && !postalCodeNumber.isEmpty();
	}

	public boolean isSetPostalCodeNumberExtension() {
		return postalCodeNumberExtension != null && !postalCodeNumberExtension.isEmpty();
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setPostTown(PostTown postTown) {
		if (postTown != null)
			postTown.setParent(this);

		this.postTown = postTown;
	}

	public void setPostalCodeNumber(List<PostalCodeNumber> postalCodeNumber) {
		this.postalCodeNumber = new ChildList<PostalCodeNumber>(this, postalCodeNumber);
	}

	public void setPostalCodeNumberExtension(List<PostalCodeNumberExtension> postalCodeNumberExtension) {
		this.postalCodeNumberExtension = new ChildList<PostalCodeNumberExtension>(this, postalCodeNumberExtension);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetPostTown() {
		if (isSetPostTown())
			postTown.unsetParent();

		postTown = null;
	}

	public void unsetPostalCodeNumber() {
		if (isSetPostalCodeNumber())
			postalCodeNumber.clear();

		postalCodeNumber = null;
	}

	public boolean unsetPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		return isSetPostalCodeNumber() ? this.postalCodeNumber.remove(postalCodeNumber) : false;
	}

	public void unsetPostalCodeNumberExtension() {
		if (isSetPostalCodeNumberExtension())
			postalCodeNumberExtension.clear();

		postalCodeNumberExtension = null;
	}

	public boolean unsetPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		return isSetPostalCodeNumberExtension() ? this.postalCodeNumberExtension.remove(postalCodeNumberExtension) : false;
	}

	public void unsetType() {
		type = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.POSTAL_CODE;
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
		return copyTo(new PostalCode(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostalCode copy = (target == null) ? new PostalCode() : (PostalCode)target;

		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPostalCodeNumber()) {
			for (PostalCodeNumber part : postalCodeNumber) {
				PostalCodeNumber copyPart = (PostalCodeNumber)copyBuilder.copy(part);
				copy.addPostalCodeNumber(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPostalCodeNumberExtension()) {
			for (PostalCodeNumberExtension part : postalCodeNumberExtension) {
				PostalCodeNumberExtension copyPart = (PostalCodeNumberExtension)copyBuilder.copy(part);
				copy.addPostalCodeNumberExtension(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPostTown()) {
			copy.setPostTown((PostTown)copyBuilder.copy(postTown));
			if (copy.getPostTown() == postTown)
				postTown.setParent(this);
		}

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
