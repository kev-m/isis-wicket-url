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

import org.apache.isis.viewer.wicket.model.models.ScalarModel;
import org.apache.isis.viewer.wicket.ui.components.scalars.ScalarPanelTextFieldParseableAbstract;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Panel for rendering strings of name Url* as links.
 */
public class UrlPanel extends ScalarPanelTextFieldParseableAbstract { //PanelAbstract<ScalarModel> implements TextFieldValueModel.ScalarModelProvider {
	private static final long serialVersionUID = 1L;
	private static final String ID_LINK = "externalSite";
	
    public UrlPanel(final String id, final ScalarModel scalarModel) {
        super(id, ID_SCALAR_VALUE, scalarModel);
    }

    @Override
    protected IModel<String> getScalarPanelType() {
        return Model.of("stringPanel");
    }
    
    @Override
    protected Component addComponentForCompact() {
    	System.out.println("addComponentForCompact()");
        Fragment compactFragment = getCompactFragment(CompactType.SPAN);
        final String objectAsString = getModel().getObjectAsString();
        final ExternalLink link = new ExternalLink(ID_LINK, objectAsString, objectAsString);
    	compactFragment.add(link);        
        scalarTypeContainer.addOrReplace(compactFragment);
        return link;
    }	

//	public UrlPanel(final String id, final ScalarModel model) {
//		super(id, model);
//
//		buildGui();
//	}

//	private void buildGui() {
//
//		final ScalarModel model = getModel();
//
//		addOrReplace(new Label("label", model.getName()));
//
//		if (EntityModel.Mode.EDIT.equals(model.getMode())) {
//			addOrReplace(getComponentForRegular());
//		} else {
//			addOrReplace(getComponentForCompact());
//		}
//	}
//
//	protected Component getComponentForCompact() {
//		System.out.println("addComponentForCompact()");
//		Fragment compactFragment = new Fragment("fragment", "compact", UrlPanel.this);
//		/*
//		Label label = new Label("editor", new TextFieldValueModel<>(this));
//		label.setEscapeModelStrings(false);
//		compactFragment.add(label);
//		*/
//		final String objectAsString = getModel().getObjectAsString();
//		final ExternalLink link = new ExternalLink(ID_LINK, objectAsString, objectAsString);
//		compactFragment.add(link);
//		return link;
//	}
//	
//    protected Component getComponentForRegular() {
//        Fragment fragment = new Fragment("fragment", "regular", UrlPanel.this);
//
//        UrlPanelFacetAbstract editorFacet = getModel().getFacet(UrlPanelFacetAbstract.class);
//
//        fragment.add(new SummernoteEditor("editor", new TextFieldValueModel<>(this), config) {
//            @Override
//            public void renderHead(IHeaderResponse response) {
//                super.renderHead(response);
//
//                response.render(OnDomReadyHeaderItem.forScript(String.format("debugger;$('#%s').code('%s')",
//                                                                     getMarkupId(), JavaScriptUtils.escapeQuotes(getModelObject()))));
//            }
//        });
//        return fragment;
//    }	


}