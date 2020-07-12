# Annotations

  
## Parameters
 
* Every parameter must have one of 
     * **@Optional**   Options 
     * **@Required**   Options
     * **@Argument**   Arguments
* Files
     * **@FileExists**   File must exist
     * **@FileReadable** File must exist and be readable
     * **@FileWritable** does it need to exist
* Inter parameter dependencies
      * **@Exlusive**
      * **@Requires** [Requires](#@Requires)

 * **@AcceptableValues** Annotation type to indicate a list of values that may be assumed by a String, 

 * **@Required** Annotation type to indicate a parameter should be treated is mandatory. This   
    annotation is mutually exclusive to the Optional annotation.
    
    Required options are better self documenting than positional arguments


 ```
 @Required
  @AcceptableValues(values = {"a", "b"}) 
  private String abba;
```
 
 
  * **@DependentField**   Annotation type to indicate a parameter is required by another parameter. The
  argument property should be set to a string with the name of the property on
  the same class that requires it.
  
  example:
  
  The property "schemaName" is required by the property "xsd"

<a name="@Requires">   
### @Requires  
</a>

```
  @Requires("schemaName") String xsd;
```

<a name="@Exclusive">
### Exclusive 
</a>

  
 * **@Exclusive**  * Annotation type to indicate a parameter is exclusive to another parameter.
 
  The annotation may be on either of the mutually exclusive fields. Having on
  both fields is not an error, but is redundant.
  
  example:
  
  If parameter 'input' is specified 'workbookLoadId' may not be specified and
 vice versa.
  
  code:
```  
  @Exclusive(property = "input") Long workbookLoadId = null;
```  
    * FieldValue  * Annotation type to assign a command line parameter type to a bean property.
  This annotation is mutually exclusive to the MultiValue annotation.
 
*    **@Hidden**  * Annotation type to indicate that an argument is hidden; that is, not displayed on help messages.
 
*    **@MultiValue**  Annotation type to indicate a parameter is accepted multiple times. This annotation is mutually exclusive to the FieldValue annotation.
 
 
  example:
  
  The property "downloadUrls" is to be multiple urls to download
 
  code:
````  
 @MultiValue(type=ParamType.STRING) ArrayList<String>  downloadUrls;
 ```
    
 *   **@RequiredUnless**   Annotation type to indicate a parameter should be treated as required unless another parameter is specified.
 
 *   **@Requires**  Annotation type to indicate a parameter is required by another parameter. The
 argument property should be set to a string with the name of the property on
the same class that requires it.
  
 example:
  
 The property "schemaName" is required by the property "xsd"'
 


