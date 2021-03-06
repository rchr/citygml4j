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
package org.citygml4j.builder.jaxb.marshal.citygml.relief;

import javax.xml.bind.JAXBElement;

import net.opengis.citygml.relief._2.AbstractReliefComponentType;
import net.opengis.citygml.relief._2.BreaklineReliefType;
import net.opengis.citygml.relief._2.GridPropertyType;
import net.opengis.citygml.relief._2.MassPointReliefType;
import net.opengis.citygml.relief._2.ObjectFactory;
import net.opengis.citygml.relief._2.RasterReliefType;
import net.opengis.citygml.relief._2.ReliefComponentPropertyType;
import net.opengis.citygml.relief._2.ReliefFeatureType;
import net.opengis.citygml.relief._2.TINReliefType;
import net.opengis.citygml.relief._2.TinPropertyType;
import net.opengis.gml.TriangulatedSurfaceType;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

public class Relief200Marshaller {
	private final ObjectFactory dem = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Relief200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof ReliefModuleComponent)
			src = marshal((ReliefModuleComponent)src);
		
		if (src instanceof BreaklineReliefType)
			dest = dem.createBreaklineRelief((BreaklineReliefType)src);
		else if (src instanceof MassPointReliefType)
			dest = dem.createMassPointRelief((MassPointReliefType)src);
		else if (src instanceof RasterReliefType)
			dest = dem.createRasterRelief((RasterReliefType)src);
		else if (src instanceof ReliefFeatureType)
			dest = dem.createReliefFeature((ReliefFeatureType)src);
		else if (src instanceof TINReliefType)
			dest = dem.createTINRelief((TINReliefType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof BreaklineRelief)
			dest = marshalBreaklineRelief((BreaklineRelief)src);
		else if (src instanceof GridProperty)
			dest = marshalGridProperty((GridProperty)src);
		else if (src instanceof MassPointRelief)
			dest = marshalMassPointRelief((MassPointRelief)src);
		else if (src instanceof RasterRelief)
			dest = marshalRasterRelief((RasterRelief)src);
		else if (src instanceof ReliefComponentProperty)
			dest = marshalReliefComponentProperty((ReliefComponentProperty)src);
		else if (src instanceof ReliefFeature)
			dest = marshalReliefFeature((ReliefFeature)src);
		else if (src instanceof TinProperty)
			dest = marshalTinProperty((TinProperty)src);
		else if (src instanceof TINRelief)
			dest = marshalTINRelief((TINRelief)src);
		
		return dest;
	}
	
	public void marshalAbstractReliefComponent(AbstractReliefComponent src, AbstractReliefComponentType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetExtent())
			dest.setExtent(jaxb.getGMLMarshaller().marshalPolygonProperty(src.getExtent()));
		
		if (src.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfReliefComponent())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfReliefComponent().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public void marshalBreaklineRelief(BreaklineRelief src, BreaklineReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getRidgeOrValleyLines()));
		
		if (src.isSetBreaklines())
			dest.setBreaklines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getBreaklines()));
		
		if (src.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBreaklineRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBreaklineRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public GridPropertyType marshalGridProperty(GridProperty src) {
		GridPropertyType dest = dem.createGridPropertyType();

		if (src.isSetRectifiedGridCoverage())
			dest.setRectifiedGridCoverage(jaxb.getGMLMarshaller().marshalRectifiedGridCoverage(src.getRectifiedGridCoverage()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public BreaklineReliefType marshalBreaklineRelief(BreaklineRelief src) {
		BreaklineReliefType dest = dem.createBreaklineReliefType();
		marshalBreaklineRelief(src, dest);

		return dest;
	}
	
	public void marshalMassPointRelief(MassPointRelief src, MassPointReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetReliefPoints())
			dest.setReliefPoints(jaxb.getGMLMarshaller().marshalMultiPointProperty(src.getReliefPoints()));
		
		if (src.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfMassPointRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfMassPointRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public MassPointReliefType marshalMassPointRelief(MassPointRelief src) {
		MassPointReliefType dest = dem.createMassPointReliefType();
		marshalMassPointRelief(src, dest);

		return dest;
	}
	
	public void marshalRasterRelief(RasterRelief src, RasterReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetGrid())
			dest.setGrid(marshalGridProperty(src.getGrid()));
		
		if (src.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRasterRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRasterRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public RasterReliefType marshalRasterRelief(RasterRelief src) {
		RasterReliefType dest = dem.createRasterReliefType();
		marshalRasterRelief(src, dest);

		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public ReliefComponentPropertyType marshalReliefComponentProperty(ReliefComponentProperty src) {
		ReliefComponentPropertyType dest = dem.createReliefComponentPropertyType();

		if (src.isSetReliefComponent()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getReliefComponent());
			if (elem != null && elem.getValue() instanceof AbstractReliefComponentType)
				dest.set_ReliefComponent((JAXBElement<? extends AbstractReliefComponentType>)elem);
		}
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public void marshalReliefFeature(ReliefFeature src, ReliefFeatureType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : src.getReliefComponent())
				dest.getReliefComponent().add(marshalReliefComponentProperty(reliefComponentProperty));
		}
		
		if (src.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfReliefFeature())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfReliefFeature().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public ReliefFeatureType marshalReliefFeature(ReliefFeature src) {
		ReliefFeatureType dest = dem.createReliefFeatureType();
		marshalReliefFeature(src, dest);

		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public TinPropertyType marshalTinProperty(TinProperty src) {
		TinPropertyType dest = dem.createTinPropertyType();

		if (src.isSetTriangulatedSurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTriangulatedSurface());
			if (elem != null && elem.getValue() instanceof TriangulatedSurfaceType)
				dest.setTriangulatedSurface((JAXBElement<? extends TriangulatedSurfaceType>)elem);
		}
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public void marshalTINRelief(TINRelief src, TINReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetTin())
			dest.setTin(marshalTinProperty(src.getTin()));
		
		if (src.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTinRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTinRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public TINReliefType marshalTINRelief(TINRelief src) {
		TINReliefType dest = dem.createTINReliefType();
		marshalTINRelief(src, dest);

		return dest;
	}
	
}
