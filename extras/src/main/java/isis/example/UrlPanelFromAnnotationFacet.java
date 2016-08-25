/**
 * 
 */
package isis.example;

import org.apache.isis.core.metamodel.facetapi.FacetHolder;

/**
 * @author kevin
 *
 */
public class UrlPanelFromAnnotationFacet extends UrlPanelFacetAbstract {
	
    public UrlPanelFromAnnotationFacet(final FacetHolder holder) {
        super(holder);
    }

    public static UrlPanelFromAnnotationFacet create(IsUrl annotation, FacetHolder holder) {

        return new UrlPanelFromAnnotationFacet(holder);
    }
}
