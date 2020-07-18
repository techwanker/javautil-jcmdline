   
##Parameters  
</a>  

 
* Every parameter must have one of 
     * **@Optional**   Options 
     * **@Required**   Options
     * **@Argument**   Arguments
* Files
     * **@FileExists**   File must exist
     * **@FileReadable** File must exist and be readable
     * **@FileWritable** does it need to exist
* Inter parameter dependencies
     * **@Exclusive**
     * **@Requires** [Requires](#@Requires)
     
<a name="Annotations"> 

# Annotations
</a>

<a name="@AcceptableValues">

## @AcceptableValues 
</a>

Annotation type to indicate a list of values that may be assumed by a String, 

```
 @AcceptableValues(values = {"a", "b"}) private String text;
```

<a name="@Argument">

## @Argument
</a>

Annotation type to indicate a parameter should be treated as argument.

```
TODO add Argument Code
```

<a name="@DependentField">

## @DependentField
</a>

 Annotation type to indicate a parameter is required by another parameter. The argument property should be set to a string with the name of the property on the same class that requires it.

example:

The property "schemaName" is required by the property "xsd"
 
code:

```
@Requires("schemaName") String xsd;
```

<a name="@DirectoryExists">

## @DirectoryExists
</a>

Annotation type to indicate a directory must exist.

code:

```
@DirectoryExists private File inputDirectory;
```

<a name="@DirectoryReadable">

## @DirectoryReadable
</a>

Annotation type to indicate a directory must be readable. By definition it must exist. TODO ensure that this is true.

code:

```
	@DirectoryReadable
	private File databaseDirectory;
```

<a name="@DirectoryWritable">

## @DirectoryWritable
</a>

Annotation type to indicate a directory must be writable.

code:

```
	@DirectoryWriteable
	private File databaseDirectory;
```

<a name="@Exclusive">

### @Exclusive 
</a>
  
Annotation type to indicate a parameter is exclusive to another parameter.

The annotation may be on either of the mutually exclusive fields. Having on both fields is not an error, but is redundant.

example:

If parameter 'input' is specified 'workbookLoadId' may not be specified and vice versa.

code:
  
```
  @Exclusive(property = "input") Long workbookLoadId = null;
```

<a name="@FieldValue">

## @FieldValue
</a>

Annotation type to assign a command line parameter type to a bean property.
This annotation is mutually exclusive to the MultiValue annotation.

code:

```
TODO add FieldValue code
```

<a name="@FileExists">

## @FileExists
</a>

Annotation type to indicate a file must exist.

code:

```
@FileExists
private File outputFile;
```

<a name="@FileReadable">

## @FileReadable
</a>

Annotation type to indicate a file must be readable.

code:

```
@FileReadable
private File definition;
```

<a name="@FileWritable">

## @FileWritable
</a>

Annotation type to indicate a file must be writable

code:

```
@FileWritable
private File definitionOutput;
```

<a name="@Hidden">   
 
### @Hidden

</a>
 
Annotation type to indicate that an argument is hidden; that is, not displayed on help messages.

TODO this is not implemented in the CommandLineHandler

```
TODO add code to hidden
```

<a name="@MultiValue">  

  
### @MultiValue

</a>   
 
Annotation type to indicate a parameter is accepted multiple times. This annotation is mutually exclusive to the FieldValue annotation.
 
 
  example:
  
  The property "downloadUrls" is to be multiple urls to download
 
  code:
  
```
 @MultiValue(type=ParamType.STRING) ArrayList<String>  downloadUrls;
```

<a name="@Optional">

## @Optional
</a>

Annotation type to indicate a parameter should be treated as optional. This annotation is mutually exclusive to the Required annotation.

TODO jjs is one or the other required? What happens if a field has neither

code:

```
@Optional
private String breed;
```

<a name="@Required">

## @Required 
</a>

Annotation type to indicate a parameter should be treated is mandatory. This annotation is mutually exclusive to the Optional annotation.
    
Required options are better self documenting than positional arguments


 ```
 @Required
  @AcceptableValues(values = {"a", "b"}) 
  private String abba;
```

<a name="@RequiredUnless">
  
### @RequiredUnless
</a>
 
Annotation type to indicate a parameter should be treated as required unless another parameter is specified.

```
@RequiredUnless(property = "toad")
private String frog;

@Optional
private String toad;
```

<a name="@Requires">

### @Requires

</a>
 
Annotation type to indicate a parameter is required by another parameter. The argument property should be set to a string with the name of the property on the same class that requires it.
  
 example:
  
 The property "schemaName" is required by the property "xsd"'

```
@Requires("schemaName") String xsd;
```
