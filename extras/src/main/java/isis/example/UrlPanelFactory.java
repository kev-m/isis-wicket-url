/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package isis.example;

import org.apache.isis.core.metamodel.specloader.SpecificationLoader;
import org.apache.isis.core.runtime.system.context.IsisContext;
import org.apache.isis.viewer.wicket.model.models.ScalarModel;
import org.apache.isis.viewer.wicket.ui.ComponentFactory;
import org.apache.isis.viewer.wicket.ui.ComponentFactoryAbstract;
import org.apache.isis.viewer.wicket.ui.ComponentType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * {@link ComponentFactory} for {@link UrlPanel}.
 */
public class UrlPanelFactory extends ComponentFactoryAbstract {

    private static final long serialVersionUID = 1L;

    public UrlPanelFactory() {
    	 super(ComponentType.SCALAR_NAME_AND_VALUE);
    	 }
    
    @Override
    public ApplicationAdvice appliesTo(IModel<?> model) {
        if (!(model instanceof ScalarModel)) {
            return ApplicationAdvice.DOES_NOT_APPLY;
        }

        ScalarModel scalarModel = (ScalarModel) model;

        UrlPanelFacetAbstract facet = scalarModel.getFacet(UrlPanelFacetAbstract.class);
        return appliesExclusivelyIf(facet != null);
    }
    

    @Override
    public Component createComponent(final String id, final IModel<?> scalarModel) {
        return new UrlPanel(id, (ScalarModel)scalarModel);
    }

    protected SpecificationLoader getSpecificationLoader() {
        return IsisContext.getSessionFactory().getSpecificationLoader();
    }    
}
