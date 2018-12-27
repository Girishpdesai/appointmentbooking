package com.cgi.appointmentbooking.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class ResourceAssembler <DomainType, ResourceType>{
	public abstract ResourceType toResource(DomainType domainObject);
	
	public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects){
		Iterator<DomainType> iterator = domainObjects.iterator();
        Collection<ResourceType> resourceTypeCollection = new ArrayList<ResourceType>();

        // while loop
        while (iterator.hasNext()) {
        ResourceType resourceType = toResource((DomainType)iterator.next());
        resourceTypeCollection.add(resourceType);
        }
        
		return resourceTypeCollection;
	}
	

}
