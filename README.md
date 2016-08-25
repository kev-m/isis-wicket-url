# isis-wicket-url
A demonstration project showing how to add an override to an Apache Isis property (in this example, String), in order to render it differently in the Wicket UI.

In this example, the String property will be rendered as a click-able URL, when the proerty is viewed in a collection.

The various stages have been separated into individual commits:

1. Create the "IsURL" annotation [e7520bc](https://github.com/kev-m/isis-wicket-url/blob/e7520bce32a2454f4c897d66002596102e412028/extras/src/main/java/isis/example/IsUrl.java)
2. Add the annotation to the property/properties of your choice [6b904bf](https://github.com/kev-m/isis-wicket-url/commit/6b904bf2b73ced21ca0b3db7a8a14bd848951bbb)
3. Adding the UrlPanel Facet and FacetFactory [18d2c7e](https://github.com/kev-m/isis-wicket-url/commit/18d2c7e5d17d935d5d064d862276ef1e04e7db92)
4. Adding the Facet Factory to the Isis properties, so that the facet factory is picked up at runtime [68e3d17](https://github.com/kev-m/isis-wicket-url/commit/68e3d1751d51d4a1706aadd60a50bf12d488aabf)
5. Adding the UrlPanelFactory to the Isis services, so that the Panel Factory is picket up by Wicket at runtime [c258bae](https://github.com/kev-m/isis-wicket-url/commit/c258bae70c8e5d67878fa859c0f7463ad00e17e9)
6. Finally, add the UrlPanel itself - a new Wicket panel that displays annotated properties as click-able links [f1fa136](https://github.com/kev-m/isis-wicket-url/commit/f1fa136ad6d1783199022fffba6020505ff99527)

Hopefully these steps show you two things about Apache Isis: Firstly, it's easy to add new annotations and add them to Wicket (for example) and secondly, it's also very easy to override the default rendering of components in the Wicket UI.

#Acknowledgements
Thanks to Martin Grigorov for providing the hints! Check out Martin's example of using a [WYSIWYG Text Editor (Summernote)](https://github.com/isisaddons/isis-wicket-summernote/) as an editor for annotated Apache Isis "String" properties!
