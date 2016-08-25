/**
 * 
 */
package isis.example;

import org.apache.isis.core.metamodel.facetapi.Facet;
import org.apache.isis.core.metamodel.facetapi.FacetHolder;
import org.apache.isis.core.metamodel.facets.MultipleValueFacet;
import org.apache.isis.core.metamodel.facets.MultipleValueFacetAbstract;

/**
 * @author kevin
 *
 */
public class UrlPanelFacetAbstract extends MultipleValueFacetAbstract implements MultipleValueFacet {


    public UrlPanelFacetAbstract(final FacetHolder holder) {
        super(type(), holder);

    }


    public static Class<? extends Facet> type() {
        return UrlPanelFacetAbstract.class;
    }

}